package com.learn.pattern.observer.interfaces;

public interface Observer {
    public void update();
    public void setSubject(Subject subject);
}
