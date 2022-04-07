package observations;

import edu.princeton.cs.algs4.StdOut;

import java.security.MessageDigest;
import java.util.*;

public class BinarySearch {

    public static int binarySearch(int[] a, int key) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi -lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static int recursiveBinarySearch(int[] a, int lo, int hi, int key) {
        if (lo > hi)
            return -1;
        int mid = lo + (hi -lo) / 2;
        if (key < a[mid])
            return recursiveBinarySearch(a, lo, mid - 1, key);
        else if (key > a[mid])
            return recursiveBinarySearch(a, mid + 1, hi, key);
        else
            return mid;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 6, 7, 10, 11};
        StdOut.println(binarySearch(a, 1));
        StdOut.println(binarySearch(a, 2));
        StdOut.println(recursiveBinarySearch(a, 0, a.length - 1, 1));
        StdOut.println(recursiveBinarySearch(a, 0, a.length - 1, 2));
    }
}
