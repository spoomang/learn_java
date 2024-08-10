package com.learn.pattern.facade;

public class ComputerFacade {
    private CPU cpu;
    private HardDrive hardDrive;
    private Memory memory;

    public ComputerFacade(CPU cpu, HardDrive hardDrive, Memory memory) {
        this.cpu = cpu;
        this.hardDrive = hardDrive;
        this.memory = memory;
    }

    public void start() {
        cpu.freeze();
        memory.load(132 , hardDrive.read(3458, 89));
        cpu.jump(132);
        cpu.execute();
    }
}
