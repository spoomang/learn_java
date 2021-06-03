package com.algo.app;

import com.algo.app.factory.AlgoFactory;
import com.algo.app.info.IAlgorithm;

public class App {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new RuntimeException("Specify an algorithm to run");
        }

        String name = args[0];

        IAlgorithm iAlgorithm = AlgoFactory.createAlgorithmInstance(name);

        iAlgorithm.getInput();
        iAlgorithm.execute();
        iAlgorithm.display();
    }
}
