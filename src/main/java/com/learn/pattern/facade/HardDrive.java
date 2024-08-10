package com.learn.pattern.facade;

public class HardDrive {
    public byte[] read(long iba, int size) {
        return new byte[]{'f', '2'};
    }
}
