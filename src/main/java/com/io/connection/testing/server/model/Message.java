package com.io.connection.testing.server.model;

public class Message {
    private int id;
    private String fromUserId;
    private String message;

    public Message(int id, String fromUserId, String message) {
        this.id = id;
        this.fromUserId = fromUserId;
        this.message = message;
    }

    public static Message createMessage(int id, String fromUserId, String message) {
        return new Message(id, fromUserId, message);
    }

    public int getId() {
        return id;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public String getMessage() {
        return message;
    }
}
