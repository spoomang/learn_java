package com.professional.certification.practice.thread.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class HttpConnect {
    public static String download(String sourceUrl) {

        try {
            URL uri = new URI(sourceUrl).toURL();

            HttpURLConnection con = (HttpURLConnection) uri.openConnection();
            int responseCode = con.getResponseCode();

            if (responseCode >= 200 && responseCode < 300) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                StringBuilder sb = new StringBuilder();

                String line;
                while((line = reader.readLine()) != null) {
                    sb.append(line);
                }

                return sb.toString();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return null;
    }
}
