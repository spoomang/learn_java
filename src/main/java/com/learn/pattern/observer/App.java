package com.learn.pattern.observer;

import com.learn.pattern.observer.interfaces.Observer;
import com.learn.pattern.observer.interfaces.Subject;
import com.learn.pattern.observer.models.EmailTopic;
import com.learn.pattern.observer.models.EmailTopicSubscriber;

public class App {
    public static void main(String[] args) {

        EmailTopic topic = new EmailTopic();

        Observer observer1 = new EmailTopicSubscriber("first_observer");
        Observer observer2 = new EmailTopicSubscriber("second_observer");
        Observer observer3 = new EmailTopicSubscriber("third_observer");

        observer1.setSubject(topic);
        observer2.setSubject(topic);
        observer3.setSubject(topic);

        topic.register(observer1);
        topic.register(observer2);
        topic.register(observer3);

        topic.postMessage("Hello subscribers");

        topic.unregister(observer2);

        topic.postMessage("Hello subscribers1");
    }
}
