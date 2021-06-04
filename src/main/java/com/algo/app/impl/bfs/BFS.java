package com.algo.app.impl.bfs;

import com.algo.app.info.IAlgorithm;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS implements IAlgorithm {

    @Setter
    @Getter
    private Vertex root;

    @Getter
    private List<Vertex> result;

    public BFS() {
        result = new ArrayList<>();
    }

    public BFS(Vertex root) {
        this();
        this.root = root;
    }

    @Override
    public void getInput() {
    }

    @Override
    public void execute() {
        traverse(root);
    }

    @Override
    public void display() {
        for (Vertex v : result) {
            System.out.print(v + " -> ");
        }
    }

    private void traverse(Vertex root) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            result.add(v);

            for (Vertex neighbour : v.getAdjacentVertices()) {
                queue.add(neighbour);
            }
        }
    }
}
