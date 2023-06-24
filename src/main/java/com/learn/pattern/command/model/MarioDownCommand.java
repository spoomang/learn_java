package com.learn.pattern.command.model;

import com.learn.pattern.command.interfaces.Command;

public class MarioDownCommand implements Command {
    private MarioCharacterReceiver receiver;

    public MarioDownCommand(MarioCharacterReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.moveDown();
    }
}
