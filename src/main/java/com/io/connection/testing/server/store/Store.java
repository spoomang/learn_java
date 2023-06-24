package com.io.connection.testing.server.store;

import com.io.connection.testing.server.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Store implements IStore {

    private static Store store;
    private Map<String, User> users;

    public static Store getInstance() {
        if (store == null) {
            store = new Store();
        }
        return store;
    }

    private Store() {
        users = new HashMap<>();
    }

    @Override
    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User retrieveUser(String id) {
        return users.get(id);
    }

    @Override
    public Set<User> retrieveAllUser() {
        return users
                .entrySet()
                .stream()
                .map(s -> s.getValue())
                .collect(Collectors.toSet());
    }
}
