package com.io.connection.testing.server.model;

public class User {
    private String id;
    private String name;
    private Connection connection;

    public static User createConnection(String id, String name, Connection connection) {
        return new User(id, name, connection);
    }

    private User(String id, String name, Connection connection) {
        this.id = id;
        this.name = name;
        this.connection = connection;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Connection getConnection() {
        return connection;
    }
}
