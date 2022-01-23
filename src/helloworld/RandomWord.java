package helloworld;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        String champion = null;
        int i = 1;
        while (true){
            String s = StdIn.readString();
            if (StdRandom.bernoulli(1.0 / (double)i))
                champion = s;
            if (!StdIn.isEmpty())
                break;
            i++;
        }
        StdOut.println(champion);
    }
}
