package com.algo.app.practice.graph;

import java.util.Arrays;

public class EarliestMomentBecomeFriends {

    static class UF {
        int[] roots;
        int[] ranks;

        public UF(int n) {
            this.roots = new int[n];
            this.ranks = new int[n];

            for (int i = 0; i < n; i++) {
                roots[i] = i;
                ranks[i] = 1;
            }
        }

        int find(int x) {
            if (roots[x] == x) {
                return x;
            }

            return roots[x] = find(roots[x]);
        }

        boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (ranks[rootX] < ranks[rootY]) {
                    roots[rootX] = rootY;
                } else if (ranks[rootX] > ranks[rootY]) {
                    roots[rootY] = rootX;
                } else {
                    roots[rootX] = rootY;
                    ranks[rootY] += 1;
                }
                return true;
            }

            return false;
        }
    }

    public int earliestAcq(int[][] logs, int n) {
        int earliestTime = -1;
        UF uf = new UF(n);
        Arrays.sort(logs, (l1, l2) -> l1[0] - l2[0]);

        int totalNumberOfGroups = n;

        for (int[] log : logs) {
            if(uf.union(log[1], log[2])) {
                totalNumberOfGroups -= 1;
                earliestTime = log[0];
            }
        }

        if (totalNumberOfGroups == 1) {
            return earliestTime;
        }

        return -1;
    }
}
