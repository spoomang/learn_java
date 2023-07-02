package com.professional.certification.practice.thread.naive.executordemo;

import com.professional.certification.practice.thread.common.HttpConnect;
import com.professional.certification.practice.thread.common.Weblink;

public class Downloader implements Runnable {
    private Weblink weblink;

    public Downloader(Weblink weblink) {
        this.weblink = weblink;
    }

    @Override
    public void run() {
        String htmlPage = HttpConnect.download(weblink.getUrl());
        weblink.setHtmlPage(htmlPage);
    }
}
