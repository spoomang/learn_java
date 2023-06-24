package com.learn.pattern.command.model;

public class KittyCharacterReceiver {
    private String name;

    public void moveUp() {
        System.out.println("Kitty Moving up ...");
    }

    public void moveDown() {
        System.out.println("Kitty Moving down ...");
    }

    public void moveLeft() {
        System.out.println("Kitty Moving left ...");
    }

    public void moveRight() {
        System.out.println("Kitty Moving right ...");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
