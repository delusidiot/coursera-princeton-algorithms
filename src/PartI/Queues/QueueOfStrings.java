package PartI.Queues;

import PartI.CustomCollection;

import java.util.Iterator;

public class QueueOfStrings implements Queue<String>{
    public QueueOfStrings() {
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

    }

    @Override
    public String dequeue() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
