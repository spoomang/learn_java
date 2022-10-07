package com.professional.certification.practice;

class Printer<Double> {
    private Double t;
    Printer(Double t) {
        this.t = t;
    }
}

public class Test {


    public static void main(String[] args) {
        Printer<Integer> i = new Printer<>(200);

        System.out.println(i);
    }
}
