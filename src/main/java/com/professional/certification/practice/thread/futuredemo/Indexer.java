package com.professional.certification.practice.thread.futuredemo;

import com.professional.certification.practice.thread.common.Weblink;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Indexer implements Runnable {
    private Future<Weblink> future;

    public Indexer(Future<Weblink> weblink) {
        this.future = weblink;
    }

    @Override
    public void run() {
        String htmlPage = null;
        try {
            Weblink weblink = future.get();
            index(weblink.getUrl(), weblink.getHtmlPage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private void index(String url, String text) {
        if (text != null) {
            System.out.println("indexing contents of url :: "+url);
        }
    }
}
