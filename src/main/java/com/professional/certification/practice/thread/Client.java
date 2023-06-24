package com.professional.certification.practice.thread;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(Proxy.NO_PROXY);
            socket.connect(new InetSocketAddress(10000));

            OutputStream out = socket.getOutputStream();

            BufferedWriter writer =  new BufferedWriter(new OutputStreamWriter(out));

            writer.write("bupp!!!");

            writer.flush();

            System.out.println("Done!");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
