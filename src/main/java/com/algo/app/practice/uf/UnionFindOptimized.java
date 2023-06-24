package com.algo.app.practice.uf;

public class UnionFindOptimized {
    private int[] roots;
    private int[] ranks;

    public UnionFindOptimized(int n) {
        roots = new int[n];
        ranks = new int[n];

        for (int i = 0; i < n; i++) {
            roots[i] = i;
            ranks[i] = 1;
        }
    }

    public int find(int x) {
        if (x == roots[x]) {
            return x;
        }
        return roots[x] = find(roots[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (ranks[rootX] < ranks[rootY]) {
                roots[rootX] = rootY;
            } else if (ranks[rootX] > ranks[rootY]) {
                roots[rootY] = rootX;
            } else {
                roots[rootY] = rootX;
                ranks[rootX] += 1;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        // // 1-2-5-6-7 3-8-9 4
        UnionFindOptimized uf = new UnionFindOptimized(10);  uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true

    }
}
