package PartI.Stacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStackOfStrings implements Stack<String>{
    private Node first;
    private int len;

    public LinkedStackOfStrings() {
        this.first = null;
        this.len = 0;
    }

    private class Node {
        String item;
        Node next;
    }

    public String push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        len++;
        return item;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        if (first == null)
            len = 0;
        else
            len--;
        return item;
    }

    @Override
    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean insert(String element) {
        this.push(element);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        try {
            String s = (String) o;
            Node current = first;
            if (current == null)
                return false;
            if (first.item.equals(s)) {
                first = first.next;
                return true;
            }
            if (first.next == null)
                return false;
            while (current.next != null && !current.next.item.equals(s)) {
                current = current.next;
            }
            if (current.next == null)
                return false;
            else
                current.next = current.next.next;
        } catch (ClassCastException e) {
            return false;
        }
        return true;
    }

    @Override
    public Iterator<String> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<String> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public String next() {
            if (!hasNext())
                throw new NoSuchElementException();
            String item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        LinkedStackOfStrings stack = new LinkedStackOfStrings();
        stack.push("test");
        System.out.println(stack.pop());
    }

}
