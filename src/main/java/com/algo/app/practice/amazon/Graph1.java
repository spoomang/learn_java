package com.algo.app.practice.amazon;

import java.util.*;

public class Graph1 {
    static class GNode {
        int inDegree = 0;
        List<Integer> neighbours = new ArrayList<>();
    }

    public static void main(String[] args) {

    }

    static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0)  return true;

        Map<Integer, GNode> graph =  new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            GNode prevCourse = getOrCreateGNode(graph, prerequisites[i][1]);
            GNode nextCourse = getOrCreateGNode(graph, prerequisites[i][0]);

            prevCourse.neighbours.add(prerequisites[i][0]);
            nextCourse.inDegree += 1;
        }

        int totalNumOfDep = prerequisites.length;

        LinkedList<Integer> list = new LinkedList<>();
        for (Integer e : graph.keySet()) {
            if (graph.get(e).inDegree == 0) {
                list.add(e);
            }
        }

        int removeEdges = 0;
        while (!list.isEmpty()) {

            int currCourse = list.poll();

            for (int neighbour : graph.get(currCourse).neighbours) {
                GNode n = graph.get(neighbour);
                n.inDegree -= 1;
                removeEdges += 1;
                if (n.inDegree == 0) {
                    list.add(neighbour);
                }
            }
        }

        if (totalNumOfDep != removeEdges) {
            return false;
        }

        return true;
    }

    static GNode getOrCreateGNode(Map<Integer, GNode> graph, int course) {
        GNode node = graph.getOrDefault(course, new GNode());
        return node;
    }
}
