package unionfind;

import edu.princeton.cs.algs4.StdOut;

/**
 * quick-find
 * initialize O(N)
 * union O(N)
 * find O(1)
 * union too expensive.
 * Takes N^2 array accesses to process sequence of N union commands on N objects.
 */
public class QuickFindUF implements UnionFind {
    private final int[] id;
    private int size;

    /**
     * set id of each object to itself
     * @param N array accesses
     */
    public QuickFindUF(int N) {
        this.id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
        this.size = N;
    }

    /**
     * check whether p and q are in the same component (2 array accesses)
     * @param p first component
     * @param q second component
     * @return check whether p and q
     */
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public int count() {
        return this.size;
    }

    /**
     * change all entries with id[p] to id[q]
     * (at most 2N + 2 array accesses)
     * @param p
     * @param q
     */
    public void union(int p, int q){
        int pid = id[p];
        int qid = id[q];
        if (pid != qid)
            size--;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid)
                id[i] = qid;
        }
    }

    public static void main(String[] args) {
        UnionFind quickFind = new QuickFindUF(10);
        StdOut.println(quickFind.count());
        StdOut.println(quickFind.connected(0, 1));
        quickFind.union(0, 1);
        StdOut.println(quickFind.connected(0, 1));
        StdOut.println(quickFind.find(0));
        StdOut.println(quickFind.find(1));
        StdOut.println(quickFind.count());
    }
}
