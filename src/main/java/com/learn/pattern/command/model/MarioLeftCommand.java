package com.learn.pattern.command.model;

import com.learn.pattern.command.interfaces.Command;

public class MarioLeftCommand implements Command {
    private MarioCharacterReceiver receiver;

    public MarioLeftCommand(MarioCharacterReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.moveLeft();
    }
}
