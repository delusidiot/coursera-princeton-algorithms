package PartI.Stacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityStackOfStrings implements Stack<String> {
    private String[] s;
    private int N = 0;

    public FixedCapacityStackOfStrings(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public String push(String item) {
        s[N++] = item;
        return item;
    }

    public String pop() {
        if (N <= 0)
            return null;
        String item = s[--N];
        s[N] = null;
        return item;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean insert(String element) {
        this.push(element);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<String> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current >= N;
        }

        @Override
        public String next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return s[current++];
        }
    }
}
