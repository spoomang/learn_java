package com.learn.pattern.interpreter;

public class InterpreterContext {
    public String getBinaryFormat(int i) {
        return Integer.toBinaryString(i);
    }

    public String toHexFormat(int i) {
        return Integer.toHexString(i);
    }
}
