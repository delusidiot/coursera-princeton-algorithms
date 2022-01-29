package unionfind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SocialNetwork {
    private final int[] members;
    private final int[] sz;

    public SocialNetwork(int N) {
        this.members = new int[N];
        this.sz = new int[N];
        for (int i = 0; i < N; i++) {
            members[i] = i;
        }
    }

    private int root(int i) {
        while (i != members[i]) {
            members[i] = members[members[i]];
            i = members[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return (root(p) == root(q));
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j)
            return ;
        if (sz[i] < sz[j]) {
            members[i] = j;
            sz[j] += sz[i];
        }
        else {
            members[j] = i;
            sz[i] += sz[j];
        }
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        SocialNetwork sn = new SocialNetwork(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!sn.connected(p, q)) {
                sn.union(p, q);
                StdOut.print(p + " " + q);
            }
        }
    }
}