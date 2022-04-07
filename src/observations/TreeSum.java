package observations;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class TreeSum {
    /**
     * brute-force algorithm
     * @param a numbers
     * @return count to zero
     */
    public static int count(int[] a) {
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                for (int k = j+1; k < a.length; k++) {
                    if (a[i] + a[j] + a[k] == 0)
                        count++;
                }
            }
        }
        return count;
    }

    /**
     * brute-force and binarySearch
     * @param a numbers
     * @return count to zero
     */
    public static int sortAndBinarySearchCount(int[] a) {
        int count = 0;
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int sum = a[i] + a[j];
                if (BinarySearch.recursiveBinarySearch(a, j + 1, a.length - 1, -sum) > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = { 30, -40, -20, -10, 40, 0, 10, 5};
//        Stopwatch stopwatch = new Stopwatch();
        StdOut.println(count(a));
//        double time = stopwatch.elapsedTime();
//        StdOut.println("brute-force algorithm empirical analysis time = "+time); //실증적 분석
        StdOut.println(sortAndBinarySearchCount(a));
    }
}
