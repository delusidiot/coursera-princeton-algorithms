package percolation;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private final int trials;

    private final double mean;
    private final double stdDev;

    public PercolationStats(int n, int trials) {
        validate(n, trials);
        this.trials = trials;
        double[] fractions = new double[this.trials];
        for (int i = 0; i < this.trials; i++) {
            Percolation percolation = new Percolation(n);
            int openCount = 0;
            int[] rand = StdRandom.permutation(n * n);
            for (int pos : rand) {
                percolation.open(pos / n + 1, pos % n + 1);
                openCount++;
                if (openCount >= n && percolation.percolates())
                    break;
            }
            fractions[i] = (double) openCount / (n * n);
        }
        mean = StdStats.mean(fractions);
        stdDev = StdStats.stddev(fractions);
    }

    private void validate(int n, int trials) {
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException();
    }

    public double mean() {
        return mean;
    }

    public double stddev() {
        return stdDev;
    }

    public double confidenceLo() {
        return mean - (1.96 * stdDev / Math.sqrt(trials));
    }

    public double confidenceHi() {
        return mean + (1.96 * stdDev / Math.sqrt(trials));
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(n, t);
        StdOut.printf("%-23s %s %f \n", "means", "=", ps.mean());
        StdOut.printf("%-23s %s %f \n", "stddev", "=", ps.stddev());
        StdOut.printf("%-23s %s%f%s%f%s\n", "95% confidence interval", "= [", ps.confidenceLo(), ", ", ps.confidenceHi(), "]");
    }
}