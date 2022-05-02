package percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private static final boolean BLOCKED = false;
    private static final boolean OPEN = true;

    private final WeightedQuickUnionUF unionFind;
    private final int n;

    private final boolean[][] grid;
    private boolean flag = false;
    private int openedCount = 0;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        validate(n);
        this.n = n;
        unionFind = new WeightedQuickUnionUF(n * n + 2);
        grid = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = BLOCKED;
            }
        }
    }

    private void validate(int n) {
        if (n <= 0)
            throw new IllegalArgumentException();
    }

    private void validateIndex(int row, int col) {
        if (row <= 0 || col <= 0 || row > n || col > n)
            throw new IllegalArgumentException();
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validateIndex(row, col);
        if (grid[row - 1][col - 1] == OPEN)
            return;
        grid[row - 1][col - 1] = OPEN;
        openedCount++;

        if (n == 1) {
            unionFind.union(0, 1);
            unionFind.union(0, 2);
            flag = true;
            return;
        }

        if (row == 1)
            unionFind.union(n * n, col - 1);
        if (row == n)
            unionFind.union(n * n + 1, (n - 1) * n + col - 1);
        if (row > 1 && grid[row - 2][col - 1] == OPEN)
            unionFind.union((row - 2) * n + col - 1, (row - 1) * n + col - 1);
        if (row < n && grid[row][col - 1] == OPEN)
            unionFind.union(row * n + col - 1, (row - 1) * n + col - 1);
        if (col > 1 && grid[row - 1][col - 2] == OPEN)
            unionFind.union((row - 1) * n + col - 2, (row - 1) * n + col - 1);
        if (col < n && grid[row - 1][col] == OPEN)
            unionFind.union((row - 1) * n + col, (row - 1) * n + col - 1);
        if (!flag && openedCount >= n && unionFind.find(n * n) == unionFind.find(n * n + 1))
            flag = true;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validateIndex(row, col);
        return grid[row - 1][col - 1] == OPEN;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validateIndex(row, col);
        if (isOpen(row, col) && (unionFind.find(n * n) == unionFind.find((row - 1) * n + col -1)))
            return true;
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openedCount;
    }

    // does the system percolate?
    public boolean percolates() {
        return flag;
    }

    // test client (optional)
    public static void main(String[] args) {

    }
}