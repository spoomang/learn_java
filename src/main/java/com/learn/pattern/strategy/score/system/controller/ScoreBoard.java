package com.learn.pattern.strategy.score.system.controller;

public class ScoreBoard {

    public ScoreAlgoBase base;

    public void showScore(int taps, int multiply) {
        System.out.println("The score is : "+base.calculate(taps, multiply));
    }
}
