package com.learn.pattern.strategy.score.system.model;

import com.learn.pattern.strategy.score.system.controller.ScoreAlgoBase;

public class Balloon implements ScoreAlgoBase {

    @Override
    public int calculate(int taps, int multiply) {
        return taps * multiply + 20;
    }
}
