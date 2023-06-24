package com.io.connection.testing.server.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.io.connection.testing.server.model.Connection;
import com.io.connection.testing.server.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class StoreTest {

    IStore s;

    @BeforeEach
    public void setup() {
        s = Store.getInstance();
    }


    @Test
    public void test_addUser_RetrieveUser(){
        String id = "1";
        String name = "san";
        User user = User.createConnection(id, name, null);

        s.addUser(user);

        User actual = s.retrieveUser(id);

        assertEquals("1", actual.getId());
        assertEquals("san", actual.getName());
    }

    @Test
    public void test_retrieveAllUser(){
        String[] ids = {"1", "2", "3"};
        String[] names = {"san", "pan", "dan"};

        for (int i = 0; i < ids.length; i++) {
            s.addUser(User.createConnection(ids[i], names[i], null));
        }

        Set<User> actualUsers = s.retrieveAllUser();

        for (int i = 0; i < ids.length; i++) {
            assertTrue(actualUsers.contains(s.retrieveUser(ids[i])));
        }
    }
}
