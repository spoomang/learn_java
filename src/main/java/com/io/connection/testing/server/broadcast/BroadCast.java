package com.io.connection.testing.server.broadcast;

import com.io.connection.testing.server.model.Message;
import com.io.connection.testing.server.model.User;
import com.io.connection.testing.server.mq.IMQRead;
import com.io.connection.testing.server.mq.MQImpl;
import com.io.connection.testing.server.store.IStore;
import com.io.connection.testing.server.store.Store;

import java.io.BufferedWriter;
import java.util.Set;

public class BroadCast implements Runnable {

    IMQRead mq;
    IStore store;

    public BroadCast(IMQRead mq) {
        this.mq = mq;
        this.store = Store.getInstance();

        System.out.println("MQInstance in broad cast"+mq);
    }

    @Override
    public void run() {
        System.out.println("BroadCast Up and Running..");
        while (true) {
            Message message;
            message = mq.read();
            // System.out.println("mq.read()) "+message);
            if (message != null) {
                System.out.println("inside: "+ message);
                Set<User> users = store.retrieveAllUser();
                String line = message.getMessage();

                System.out.println("String line:: "+line);
                System.out.println("Users "+users.size());

                for (User user : users) {
                    BufferedWriter writer = (BufferedWriter) user.getConnection().getWriter();

                    try {
                        writer.write(line);
                        writer.newLine();
                        writer.flush();
                    } catch (Exception e) {
                        System.out.println("Broadcast write failed");
                    }
                }
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
