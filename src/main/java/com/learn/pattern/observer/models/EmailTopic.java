package com.learn.pattern.observer.models;

import com.learn.pattern.observer.interfaces.Observer;
import com.learn.pattern.observer.interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

public class EmailTopic implements Subject {
    private List<Observer> observers;
    private String message;

    public EmailTopic() {
        observers = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

    @Override
    public Object getUpdate(Observer observer) {
        return message;
    }

    public void postMessage(String msg) {
        System.out.println("Message posted to my topic "+msg);
        this.message = msg;
        this.notifyObservers();
    }
}
