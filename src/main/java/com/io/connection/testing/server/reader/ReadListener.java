package com.io.connection.testing.server.reader;

import com.io.connection.testing.server.model.Connection;
import com.io.connection.testing.server.model.Message;
import com.io.connection.testing.server.model.User;
import com.io.connection.testing.server.mq.MQImpl;
import com.io.connection.testing.server.processor.ProcessRegister;
import com.io.connection.testing.server.store.IStore;
import com.io.connection.testing.server.store.Store;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadListener extends Thread implements IReadListener {
    private User user;
    private ProcessRegister processRegister;
    private Socket socket;

    private MQImpl mqWrite;

    private IStore iStore;

    public ReadListener(ProcessRegister processRegister, Socket socket, MQImpl mqWrite) {
        this.processRegister = processRegister;
        this.socket = socket;
        this.mqWrite = mqWrite;
        this.iStore = Store.getInstance();
        System.out.println("MQInstance in ReadListener"+mqWrite);
    }

    @Override
    public void listenRead() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            socket.setSoTimeout(10000);
            while (true) {
                if ((line = reader.readLine() ) != null) {
                    System.out.println("Reading line "+line);
                    user = User.createConnection("1", "1", Connection.createConnection(socket));

                    iStore.addUser(user);

                    Message message = Message.createMessage(1, "1", line);
                    mqWrite.write(message);
                    }
            }

        } catch (Exception e) {
            System.out.println("Stopped Reading....");
            try {
                socket.close();
            } catch (IOException ex) {
                System.out.println("IOException Reading...."+ex);
            }
        }

        System.out.println("Socket is closed...");
    }

    @Override
    public void run() {
        listenRead();
    }
}
