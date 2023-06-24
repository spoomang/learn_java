package com.learn.pattern.adapter.model;

public class Socket {

    private Volt volt;

    public Socket(int volt) {
        this.volt = new Volt(volt);
    }

    public Volt getVolt() {
        return volt;
    }
}
