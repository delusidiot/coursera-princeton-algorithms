package PartI.UnionFind;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @author : delusidiot
 * @fileName : UnionFindMain
 * @date : 2022-05-02
 */
public class UnionFindMain {
    public static void unions(UnionFind unionFind) {
        unionFind.union(0, 2);
        unionFind.union(2, 3);
        unionFind.union(4, 3);
        unionFind.union(5, 6);
        unionFind.union(9, 8);
        unionFind.union(8, 5);
        StdOut.println(unionFind.connected(0, 4));
        unionFind.printId();
    }
    public static void main(String[] args) {
        QuickFindUF quickFindUF = new QuickFindUF(10);
        QuickUnionUF quickUnionUF = new QuickUnionUF(10);
        WeightedQuickUnion weightedQuickUnion = new WeightedQuickUnion(10);
        PathCompressionWeightedQuickUnion pcwQuickUnion = new PathCompressionWeightedQuickUnion(10);

        unions(quickFindUF);
        unions(quickUnionUF);
        unions(weightedQuickUnion);
        unions(pcwQuickUnion);

    }
}
