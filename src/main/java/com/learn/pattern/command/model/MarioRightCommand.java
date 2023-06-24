package com.learn.pattern.command.model;

import com.learn.pattern.command.interfaces.Command;

public class MarioRightCommand implements Command {
    private MarioCharacterReceiver receiver;

    public MarioRightCommand(MarioCharacterReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.moveRight();
    }
}
