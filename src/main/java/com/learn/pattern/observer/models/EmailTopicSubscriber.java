package com.learn.pattern.observer.models;

import com.learn.pattern.observer.interfaces.Observer;
import com.learn.pattern.observer.interfaces.Subject;

public class EmailTopicSubscriber implements Observer {
    private String name;
    private Subject subject;

    public EmailTopicSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        String msg = (String) subject.getUpdate(this);
        if (msg == null) {
            System.out.println(name+" got no msg");
        } else {
            System.out.println(name+" got msg "+msg);
        }
    }

    @Override
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
