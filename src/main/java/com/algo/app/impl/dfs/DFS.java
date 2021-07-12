package com.algo.app.impl.dfs;

import com.algo.app.impl.node.Vertex;
import com.algo.app.info.IAlgorithm;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS implements IAlgorithm {

    @Setter
    @Getter
    private Vertex root;

    @Getter
    private List<Vertex> result;

    public DFS() {
    }

    public DFS(Vertex root) {
        this.root = root;
    }


    @Override
    public void getInput() {
        root = new Vertex("A");
        result = new ArrayList<>();
    }

    @Override
    public void execute() {
        recursion(root);
    }

    @Override
    public void display() {
        for (Vertex v : result) {
            System.out.print(v + " -> ");
        }
    }

    private void traverse() {
        Stack<Vertex> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            Vertex vertex = stack.pop();
            vertex.setVisited(true);
            result.add(vertex);
            for(Vertex neighbour : vertex.getAdjacentVertices()) {
                if(!neighbour.isVisited()) {
                    stack.push(neighbour);
                }
            }
        }
    }

    private void recursion(Vertex vertex) {
        if(vertex.isVisited()) {
            return;
        }
        vertex.setVisited(true);
        result.add(vertex);
        for(Vertex neighbour : vertex.getAdjacentVertices()) {
            recursion(neighbour);
        }
    }
}
