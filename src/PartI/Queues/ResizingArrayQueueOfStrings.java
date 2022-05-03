package PartI.Queues;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author : delusidiot
 * @fileName : ResizingArrayQueueOfStrings
 * @date : 2022-05-03
 */
public class ResizingArrayQueueOfStrings implements Queue<String>{
    private int head, tail;
    private String[] q;

    private int N;

    public ResizingArrayQueueOfStrings() {
        this.head = 0;
        this.tail = 0;
        this.N = 0;
        q = new String[1];
    }

    @Override
    public boolean insert(Object element) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void enqueue(String item) {
        if (tail == q.length) {
            if (N == q.length)
                resize( 2 * q.length);
            else
                reinsert();
        }
        q[tail] = item;
        tail++;
        N++;
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = q[i + head];
        }
        q = copy;
    }

    private void reinsert() {
        String[] copy = new String[q.length];
        for (int i = head; i < tail; i++) {
            copy[i - head] = q[i];
        }
        tail -= head;
        head = 0;
        q = copy;
    }

    @Override
    public String dequeue() {
        String oldHead = q[head];
        q[head] = null;
        head++;
        N--;
        if (N > 0 && N == q.length/4) {
            reinsert();
            resize(q.length / 2);
        }
        return oldHead;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public int size() {
        return N;
    }

    public void printQueue() {
        StdOut.println(Arrays.toString(q));
    }
}
