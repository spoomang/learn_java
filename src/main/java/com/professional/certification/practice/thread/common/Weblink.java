package com.professional.certification.practice.thread.common;

public class Weblink {
    private String url;
    private volatile String htmlPage;

    public Weblink(String url) {
        this.url = url;
    }

    public String getHtmlPage() {
        return htmlPage;
    }

    public void setHtmlPage(String htmlPage) {
        this.htmlPage = htmlPage;
    }

    public String getUrl() {
        return url;
    }
}
