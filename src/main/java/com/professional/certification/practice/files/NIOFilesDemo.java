package com.professional.certification.practice.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NIOFilesDemo {
    public static void main(String[] args) throws IOException {

//        Files.lines(Paths.get("/Users/sandeeppoomanglaath/learn/java/learn_java/build.gradle"))
//                .forEach(System.out::println);

        Files.readAllLines(Paths.get("/Users/sandeeppoomanglaath/learn/java/learn_java/build.gradle"))
                .stream()
                .forEach(System.out::println);


    }
}
