package com.algo.app.impl.bfs;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    @Setter
    @Getter
    private String name;

    @Getter
    @Setter
    private boolean isVisited;

    @Getter
    private List<Vertex> adjacentVertices;

    public Vertex(String name) {
        this.name = name;
        adjacentVertices = new ArrayList<>();
    }

    public void addVertex(Vertex v) {
        adjacentVertices.add(v);
    }

    @Override
    public String toString() {
        return name;
    }
}
