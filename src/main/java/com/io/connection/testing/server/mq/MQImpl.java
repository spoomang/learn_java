package com.io.connection.testing.server.mq;

import com.io.connection.testing.server.model.Message;

import java.util.ArrayDeque;
import java.util.Queue;

public class MQImpl implements IMQRead, IMQWrite{

    private static MQImpl mq;
    private Queue<Message> queue;


    private MQImpl() {
        queue = new ArrayDeque<>();
    }

    public static MQImpl getInstance() {
        synchronized (MQImpl.class) {
            if (mq == null) {
                mq = new MQImpl();
            }
        }
        return mq;
    }

    @Override
    public Message read() {
        return queue.poll();
    }

    @Override
    public void  write(Message message) {
        queue.add(message);
    }
}
