package com.professional.certification.practice.thread.futuredemo;

import com.professional.certification.practice.thread.common.HttpConnect;
import com.professional.certification.practice.thread.common.Weblink;

import java.util.concurrent.Callable;

public class Downloader<T extends Weblink> implements Callable {
    private T weblink;

    public Downloader(T weblink) {
        this.weblink = weblink;
    }

    @Override
    public T call() {
        String htmlPage = HttpConnect.download(weblink.getUrl());
        weblink.setHtmlPage(htmlPage);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return weblink;
    }
}
