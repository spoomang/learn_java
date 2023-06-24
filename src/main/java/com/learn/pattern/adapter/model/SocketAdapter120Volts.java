package com.learn.pattern.adapter.model;

import com.learn.pattern.adapter.interfaces.SocketAdapter;

public class SocketAdapter120Volts implements SocketAdapter {

    private Socket socket;

    public SocketAdapter120Volts() {
        this.socket = new Socket(120);
    }

    @Override
    public Volt get120Volt() {
        Volt v = socket.getVolt();
        return v;
    }

    @Override
    public Volt get12Volt() {
        Volt v = socket.getVolt();
        return convertVolt(v, 10);
    }

    @Override
    public Volt get3Volt() {
        Volt v = socket.getVolt();
        return convertVolt(v, 40);
    }

    @Override
    public Volt get1Volt() {
        Volt v = socket.getVolt();
        return convertVolt(v, 120);
    }

    private Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVolt() / i);
    }
}
