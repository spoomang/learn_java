package com.learn.pattern.strategy.score.system;

import com.learn.pattern.strategy.score.system.controller.ScoreBoard;
import com.learn.pattern.strategy.score.system.model.Balloon;
import com.learn.pattern.strategy.score.system.model.Clown;
import com.learn.pattern.strategy.score.system.model.SquareBalloon;

public class App {
    public static void main(String[] args) {
        ScoreBoard scoreBoard = new ScoreBoard();

        System.out.println("Balloon score");
        scoreBoard.base = new Balloon();
        scoreBoard.showScore(10, 4);

        System.out.println("Clown score");
        scoreBoard.base = new Clown();
        scoreBoard.showScore(10, 4);


        System.out.println("Square Balloon score");
        scoreBoard.base = new SquareBalloon();
        scoreBoard.showScore(10, 4);
    }
}
