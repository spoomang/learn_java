package com.algo.app.impl.bfs;

import com.algo.app.info.IAlgorithm;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Queue;

public class BFS implements IAlgorithm {

    @Setter
    @Getter
    private Vertex root;

    public BFS() {
    }

    public BFS(Vertex root) {
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
    }

    private void traverse(Vertex root) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            System.out.print(v+" -> ");

            for (Vertex neighbour : v.getAdjacentVertices()) {
                queue.add(neighbour);
            }
        }
    }
}
