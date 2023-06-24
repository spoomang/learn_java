package com.io.connection.testing.server;

import com.io.connection.testing.server.listener.IListener;
import com.io.connection.testing.server.listener.ListenerImpl;
import com.io.connection.testing.server.processor.ProcessRegister;

public class App {
    public static void main(String[] args) {
        ProcessRegister processRegister = new ProcessRegister();
        IListener listener = new ListenerImpl(8080, processRegister);
        listener.listenSocket();
    }
}
