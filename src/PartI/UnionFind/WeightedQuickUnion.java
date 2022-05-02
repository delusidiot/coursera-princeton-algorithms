package PartI.UnionFind;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Balance by linking root of smaller tree to root of larger tree.
 * Maintain extra array sz[] to count number of objects in the tree rooted at i.
 * initialize O(N)
 * union O(lg N)
 * find O(lg N)
 */
public class WeightedQuickUnion implements UnionFind{
    private final int[] id;
    private final int[] sz;
    private int size;

    /**
     * set id of each object to itself
     * set sz of zero
     * @param N array accesses
     */
    public WeightedQuickUnion(int N) {
        id = new int[N];
        sz = new int[N];
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

    @Override
    public int find(int p) {
        return root(p);
    }

    @Override
    public int count() {
        return this.size;
    }

    /**
     * change root of p to point to root of q.
     * Link root of smaller tree to root of larger tree.
     * Update the sz[] array.
     * @param p depth array accesses
     * @param q depth array accesses
     */
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j)
            return ;
        size--;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        }
        else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }

    @Override
    public void printId() {
        StdOut.println(Arrays.toString(id));
    }
}
