package unionfind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class SuccessorWithDelete {

    private final int[] id;
    private final int[] sz;
    private final int[] actualList;
    private final int N;

    public SuccessorWithDelete(int N){
        this.N = N;
        id = new int[this.N];
        sz = new int[this.N];
        actualList = new int[this.N];
        for(int i=0; i<N; i++){
            id[i] = i;
            sz[i] = 1;
            actualList[i] = i;
        }
    }

    // returns the root of the component the integer is in
    private int root(int i){
        while(id[i]!=i){
            i = id[i];
        }
        return i;
    }

    // weighted quick union
    public void union(Integer p, Integer q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if (sz[pRoot] <= sz[qRoot]) {
            id[pRoot] =  qRoot;
            sz[qRoot] = sz[qRoot] + sz[pRoot];

        } else {
            id[qRoot] = pRoot;
            sz[pRoot] = sz[pRoot] + sz[qRoot];
            actualList[pRoot] = qRoot;              // this is the crucial step
        }
    }


    public void remove(int x){
        union(x, x+1);

    }

    public int successor(int x){
        return actualList[(root(x+1))];
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        SuccessorWithDelete uf = new SuccessorWithDelete(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            //int q = StdIn.readInt();
            uf.remove(p);
        }
        System.out.println(Arrays.toString(uf.id));
    }
}