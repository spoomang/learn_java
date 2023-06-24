package com.io.connection.testing.server.model;


import java.io.*;
import java.net.Socket;

public class Connection {
    private Socket socket;
    private Reader reader;
    private Writer writer;


    public static Connection createConnection(Socket socket) {
        return new Connection(socket);
    }

    private Connection(Socket socket) {
        this.socket = socket;
        try {
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (Exception e) {
            System.out.println("Unable to create Connection Object :: "+e);
        }
    }

    public Reader getReader() {
        return reader;
    }

    public Writer getWriter() {
        return writer;
    }

    public Socket getSocket() {
        return socket;
    }
}
