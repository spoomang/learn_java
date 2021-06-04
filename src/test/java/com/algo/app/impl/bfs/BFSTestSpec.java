package com.algo.app.impl.bfs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BFSTestSpec {

    BFS bfs;

    @BeforeEach
    public void setup() {
        bfs = new BFS();
    }

    @Test
    public void testBFS() {
       Vertex root = new Vertex("A");
       Vertex B = new Vertex("B");
       Vertex C = new Vertex("C");
       Vertex D = new Vertex("D");
       Vertex E = new Vertex("E");

       root.addVertex(B);
       root.addVertex(C);

       B.addVertex(D);
       B.addVertex(E);

       bfs.setRoot(root);
       bfs.execute();
    }
}
