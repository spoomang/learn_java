package com.io.connection.testing.server.listener;

import com.io.connection.testing.server.broadcast.BroadCast;
import com.io.connection.testing.server.mq.MQImpl;
import com.io.connection.testing.server.processor.ProcessRegister;
import com.io.connection.testing.server.reader.ReadListener;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ListenerImpl implements IListener {

    private ServerSocket serverSocket;
    private ExecutorService executorService;

    private ProcessRegister processRegister;

    private int port;

    private volatile MQImpl mq;

    public ListenerImpl(int port, ProcessRegister processRegister) {
        this.port = port;
        this.processRegister = processRegister;
        mq = MQImpl.getInstance();
    }

    @Override
    public void listenSocket() {

        executorService = Executors.newFixedThreadPool(100);
        try {
            serverSocket = new ServerSocket(port);

            executorService.submit(new BroadCast(mq));

            System.out.println("Server Starting....");
            while (true) {
                System.out.println("Waiting for connection....");
                Socket socket = serverSocket.accept();

                executorService.submit(new ReadListener(processRegister, socket, mq));
            }

        } catch (Exception e) {
            System.out.println("Shutting down Server");
            executorService.shutdown();
        }
    }
}
