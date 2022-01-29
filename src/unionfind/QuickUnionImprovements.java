package unionfind;

/**
 * Balance by linking root of smaller tree to root of larger tree.
 * Maintain extra array sz[] to count number of objects in the tree rooted at i.
 * initialize O(N)
 * union O(lg N)
 * find O(lg N)
 */
public class QuickUnionImprovements implements UnionFind{
    private final int[] id;
    private final int[] sz;

    public QuickUnionImprovements(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    private int root(int i) {
        while (i != id [i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return (root(p) == root (q));
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j)
            return ;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        }
        else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}
