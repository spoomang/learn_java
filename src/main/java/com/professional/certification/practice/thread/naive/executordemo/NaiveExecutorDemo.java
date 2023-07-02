package com.professional.certification.practice.thread.naive.executordemo;

import com.professional.certification.practice.thread.common.Weblink;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class NaiveExecutorDemo {
    private Deque<Weblink> queue = new ArrayDeque<>();

    // Executors
    Executor downloadExecutors = Executors.newFixedThreadPool(2);
    Executor indexExecutors = Executors.newFixedThreadPool(2);

    void add(Weblink weblink) {
        queue.add(weblink);
    }

    void go() {
        while (queue.size() > 0) {
            Weblink weblink = queue.remove();
            downloadExecutors.execute(new Downloader(weblink));
            indexExecutors.execute(new Indexer(weblink));
        }
    }

    public static void main(String[] args) {
        NaiveExecutorDemo n = new NaiveExecutorDemo();
        n.add(new Weblink("https://www.google.com"));
        n.add(new Weblink("https://www.gmail.com"));
        n.add(new Weblink("https://www.bing.com"));

        n.go();
    }
}
