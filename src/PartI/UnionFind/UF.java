package PartI.UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
/**
 * union-find
 * initialize O(N)
 * union O(N)
 * find O(1)
 */
public class UF {

    private final int[] id;

    private int size;

    /**
     * @param N initialize union-find data structure with N objects(0 to N-1)
     */
    public UF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
        size = N;
    }

    /**
     * add connection between p and q
     * @param p node
     * @param q node
     */
    public void union(int p, int q){
        id[p] = id[q];
    }

    private int root(int i) {
        while (i != id[i])
            i = id[i];
        return i;
    }

    /**
     * are p and q in the same component?
     * @param p node
     * @param q node
     * @return same component
     */
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    /**
     * @param p component identifier for p (0 to N-1)
     * @return find node index
     */
    int find(int p) {
        return root(p);
    }

    /**
     * @return number of components
     */
    int count() {
       return 0;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                StdOut.print(p + " " + q);
            }
        }
    }
}
