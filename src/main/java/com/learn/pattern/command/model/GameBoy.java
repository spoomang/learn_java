package com.learn.pattern.command.model;

import com.learn.pattern.command.interfaces.Command;

public class GameBoy {

    private Command up, down, left, right;

    public GameBoy(Command up, Command down, Command left, Command right) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    public void moveUp() {
        up.execute();
    }

    public void moveDown() {
        down.execute();
    }

    public void moveLeft() {
        left.execute();
    }

    public void moveRight() {
        right.execute();
    }
}
