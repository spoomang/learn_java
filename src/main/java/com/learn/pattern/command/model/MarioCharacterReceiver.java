package com.learn.pattern.command.model;

public class MarioCharacterReceiver {
    private String name;

    public void moveUp() {
        System.out.println("Mario Moving up ...");
    }

    public void moveDown() {
        System.out.println("Mario Moving down ...");
    }

    public void moveLeft() {
        System.out.println("Mario Moving left ...");
    }

    public void moveRight() {
        System.out.println("Mario Moving right ...");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
