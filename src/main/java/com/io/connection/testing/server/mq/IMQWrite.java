package com.io.connection.testing.server.mq;

import com.io.connection.testing.server.model.Message;

public interface IMQWrite {
    void write(Message message);
}
