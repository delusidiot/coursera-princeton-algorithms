package PartI.Stacks;

import java.util.Iterator;

/**
 * @author : delusidiot
 * @fileName : StringOfStack
 * @date : 2022-04-14
 */
public class StackOfString implements Stack<String>{

    private Node first;

    public StackOfString() {
        this.first = null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean insert(String element) {
        Node item = new Node();
        item.item = element;
        item.next = first;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        String item = (String)o;
        Node prev = null;
        Node curr = first;
        while (curr != null) {
            if (item.equals(curr)) {
                if (prev == null)
                    first = first.next;
                else {
                    prev.next = curr.next;
                }
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public String push(String item) {
        Node oldFirst = this.first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        return item;
    }

    @Override
    public String pop() {
        Node item = first;
        first = first.next;
        return item.item;
    }

    private class Node {
        String item;
        Node next;
    }

}
