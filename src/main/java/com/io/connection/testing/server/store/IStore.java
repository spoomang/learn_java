package com.io.connection.testing.server.store;

import com.io.connection.testing.server.model.User;

import java.util.List;
import java.util.Set;

public interface IStore {
    void addUser(User user);
    User retrieveUser(String id);
    Set<User> retrieveAllUser();
}
