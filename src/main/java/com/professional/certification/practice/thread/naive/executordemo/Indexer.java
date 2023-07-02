package com.professional.certification.practice.thread.naive.executordemo;

import com.professional.certification.practice.thread.common.Weblink;

public class Indexer implements Runnable {
    private Weblink weblink;

    public Indexer(Weblink weblink) {
        this.weblink = weblink;
    }

    @Override
    public void run() {
        while (true) {
            if (weblink.getHtmlPage() != null) {
                index();
                break;
            }
        }
    }

    private void index() {
        System.out.println("indexing contents of url :: "+weblink.getUrl());
    }
}
