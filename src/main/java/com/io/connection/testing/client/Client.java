package com.io.connection.testing.client;


import java.io.*;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    private static BufferedReader reader;
    private static BufferedReader userReader;
    private static BufferedWriter writer;

    public static void main(String[] args) {
        Socket socket;
        ExecutorService service = Executors.newFixedThreadPool(3);
        try {
            socket = new Socket("localhost", 8080);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            userReader = new BufferedReader(new InputStreamReader(System.in));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }catch (Exception e) {
            System.out.println("Could not connect !!"+e);
        }

        Runnable readTask = () -> {
            while (true) {
                System.out.println("Read task started...");
                try {
                    String line;
                    if ((line = reader.readLine()) != null) {
                        System.out.println("From Server: "+line);
                    }
                } catch (Exception e) {
                    System.out.println("Read Task stopped "+e);
                    try {
                        reader.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        };


        Runnable writeTask = () -> {
            System.out.println("Write task started...");
            String line;

            while (true) {
                try {
                    System.out.print("Enter Message: ");
                    if ((line = userReader.readLine()) != null) {
                        writer.write(line);
                        writer.newLine();
                        writer.flush();
                    }
                } catch (Exception e) {
                    System.out.println("Write Task stopped "+e);
                }
            }
        };

        service.submit(readTask);
        service.submit(writeTask);
    }
}
