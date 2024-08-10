package com.test.certification;


import java.io.*;
import java.net.Socket;
import java.util.HashMap;

public class App {


    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("raspberrypi.local", 8080);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        while (true) {
            System.out.println("Write some input:::");
            String line  = reader.readLine();

            if (line.equals("B")) {
                break;
            }

            writer.write(line);
            writer.newLine();
            writer.flush();
        }

        socket.close();
    }
}
