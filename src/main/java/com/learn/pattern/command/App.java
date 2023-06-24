package com.learn.pattern.command;

import com.learn.pattern.command.interfaces.Command;
import com.learn.pattern.command.model.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) {

        MarioCharacterReceiver marioCharacterReceiver = new MarioCharacterReceiver();
        marioCharacterReceiver.setName("jumbala");

        Command up = new MarioUpCommand(marioCharacterReceiver);
        Command down = new MarioDownCommand(marioCharacterReceiver);
        Command left = new MarioLeftCommand(marioCharacterReceiver);
        Command right = new MarioRightCommand(marioCharacterReceiver);

        GameBoy gameBoy = new GameBoy(up, down, left, right);


        InputStreamReader in = new InputStreamReader(System.in);

        System.out.println(in.getEncoding());




    }
}
