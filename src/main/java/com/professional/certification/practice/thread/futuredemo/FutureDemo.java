package com.professional.certification.practice.thread.futuredemo;

import com.professional.certification.practice.thread.common.Weblink;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {

    private Deque<Weblink> queue = new ArrayDeque<>();

    // Executors
    ExecutorService downloadExecutors = Executors.newFixedThreadPool(2);
    ExecutorService indexExecutors = Executors.newFixedThreadPool(2);

    void add(Weblink weblink) {
        queue.add(weblink);
    }

    void go() {
        List<Future<Weblink>> futures = new ArrayList<>();

        while (queue.size() > 0) {
            Weblink weblink = queue.remove();
            Future f = downloadExecutors.submit(new Downloader(weblink));
            futures.add(f);
        }

        for (Future<Weblink> future: futures) {
            try {
                indexExecutors.execute(new Indexer(future));
            }catch (Exception e) {
                System.out.println(e);
            }
        }

        downloadExecutors.shutdown();
        indexExecutors.shutdown();

    }

    public static void main(String[] args) {
        FutureDemo n = new FutureDemo();
        n.add(new Weblink("https://www.google.com"));
        n.add(new Weblink("https://www.gmail.com"));
        n.add(new Weblink("https://www.bing.com"));

        n.go();
    }
}
