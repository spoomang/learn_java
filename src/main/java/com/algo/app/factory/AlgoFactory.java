package com.algo.app.factory;

import com.algo.app.impl.bfs.BFS;
import com.algo.app.impl.dfs.DFS;
import com.algo.app.info.IAlgorithm;

public class AlgoFactory {

    public static IAlgorithm createAlgorithmInstance(String name) {
        IAlgorithm iAlgorithm = null;

        switch (name) {
            case "bfs":
                iAlgorithm = new BFS();
                break;
            case "dfs":
                iAlgorithm = new DFS();
                break;
            default:
                throw new RuntimeException("Unknown Algorithm "+ name);
        }

        return iAlgorithm;
    }
}
