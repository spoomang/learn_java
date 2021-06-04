package com.algo.app.factory;

import com.algo.app.info.IAlgorithm;

public class AlgoFactory {

    public static IAlgorithm createAlgorithmInstance(String name) {
        IAlgorithm iAlgorithm = null;

        switch (name) {
            case "bfs":
                iAlgorithm = null;
                break;
            default:
                throw new RuntimeException("Unknown Algorithm "+ name);
        }

        return iAlgorithm;
    }
}
