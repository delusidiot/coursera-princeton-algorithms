package PartI.UnionFind;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * quick-find
 * initialize O(N)
 * union O(N)
 * find O(N)
 */
public class QuickUnionUF implements UnionFind {
    private final int[] id;
    private int size;

    /**
     * set id of each object to itself
     * @param N array accesses
     */
    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
        size = N;
    }

    /**
     * chase parent pointers until reach root
     * @param i depth of i array accesses
     * @return root value
     */
    private int root(int i) {
        while (i != id [i])
            i = id [i];
        return i;
    }

    /**
     * check if p and q have same root
     * @param p depth array accesses
     * @param q depth array accesses
     * @return same root
     */
    public boolean connected(int p, int q) {
        return (root(p) == root (q));
    }

    /**
     * change root of p to point to root of q
     * @param p depth array accesses
     * @param q depth array accesses
     */
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i != j)
            size--;
        id[i] = j;
    }

    @Override
    public int find(int p) {
        return root(p);
    }

    @Override
    public int count() {
        return this.size;
    }

    @Override
    public void printId() {
        StdOut.println(Arrays.toString(id));
    }
}
