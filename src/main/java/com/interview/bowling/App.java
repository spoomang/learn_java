package com.interview.bowling;

import java.util.HashMap;
import java.util.Map;

public class App {

    static enum TYPE {
        NONE,STRIKE,SPARE;
    }

    static class Frame {
        int rollNum;
        int score;
        int[] rolls;

        TYPE type;

        public Frame() {
            type = TYPE.NONE;
            rollNum = 1;
            rolls = new int[2];
        }

        public void setScore(int i) {
            if (rollNum <= 2) {
                rolls[rollNum - 1] = i;
                score += i;
            }

            if (rolls[0] == 10) {
                type = TYPE.STRIKE;
            } else if (rolls[0] + rolls[1] == 10) {
                type = TYPE.SPARE;
            }

            rollNum++;
        }

        public void bonus (int s) {
            switch (type) {
                case STRIKE:
                    score += s;
                    break;
                case SPARE:
                    score += s + 1;
                    break;
                default:
            }
            score += s;
        }

        public boolean isCompleted() {
            return rollNum > 2;
        }
    }

    static class Player {
        int currentFrame;
        int totalScore;
        Frame[] frames;
        boolean isEligibleForExtraFrame;

        public Player() {
            currentFrame = 1;
            isEligibleForExtraFrame = false;
            frames = new Frame[11];
        }

        public void setScore(int numOfPins) {
           Frame frame = frames[currentFrame - 1];
           frame.setScore(numOfPins);

            if (frame.isCompleted()) {
                currentFrame++;
            }
        }
    }

    Map<Integer, Player> map = new HashMap<>();

    public void roll(int userId, int numOfPins) {
        Player player = map.get(userId);

        // Logic goes here

    }

    public static void main(String[] args) {

    }
}
