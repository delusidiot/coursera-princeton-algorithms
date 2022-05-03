package PartI.Queues;

import java.util.Iterator;

public class LinkedQueueOfString implements Queue<String>{
    private Node first, last;

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(String item) {
        Node oldLast  = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
    }

    public String dequeue() {
        String item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        return item;
    }

    @Override
    public int size() {
        return 0;
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
}
