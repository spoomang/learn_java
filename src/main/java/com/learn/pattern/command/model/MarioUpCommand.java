package com.learn.pattern.command.model;

import com.learn.pattern.command.interfaces.Command;

public class MarioUpCommand implements Command {
    private MarioCharacterReceiver receiver;

    public MarioUpCommand(MarioCharacterReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.moveUp();
    }
}
