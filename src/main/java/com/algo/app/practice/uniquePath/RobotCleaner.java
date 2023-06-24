package com.algo.app.practice.uniquePath;


import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

interface Robot {
    boolean move();
    void turnLeft();
    void turnRight();
    void clean();
}

public class RobotCleaner {
    int[][] directions = {{-1,  0}, {0, 1}, {1,0}, {0, -1}};
    Set<Pair<Integer, Integer>> visited = new HashSet<>();
    Robot robot;

    public void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    public void cleanRoom(Robot robot) {

    }



    // d = 0- up, 1- right, 2-down, 3-left
    void backtrack(int r, int c, int d) {
        
    }
}
