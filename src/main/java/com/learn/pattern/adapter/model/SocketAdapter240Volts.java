package com.learn.pattern.adapter.model;

import com.learn.pattern.adapter.interfaces.SocketAdapter;

public class SocketAdapter240Volts implements SocketAdapter {

    private Socket socket;

    public SocketAdapter240Volts() {
        this.socket = new Socket(240);
    }

    @Override
    public Volt get120Volt() {
        return null;
    }

    @Override
    public Volt get12Volt() {
        return null;
    }

    @Override
    public Volt get3Volt() {
        return null;
    }

    @Override
    public Volt get1Volt() {
        return null;
    }
}
