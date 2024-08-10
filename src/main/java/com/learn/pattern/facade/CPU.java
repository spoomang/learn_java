package com.learn.pattern.facade;

public class CPU {
    public void freeze() {
        System.out.println("Computer freezing");
    }

    public void jump(int pos) {
        System.out.println("Jumping to "+pos);
    }

    public void execute(){
        System.out.println("computer executing command");
    }
}
