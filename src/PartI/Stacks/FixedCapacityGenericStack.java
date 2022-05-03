package PartI.Stacks;

public class FixedCapacityGenericStack<Item> {
    private Item[] s;
    private int N = 0;

    public FixedCapacityGenericStack(int capacity) {
        s = (Item[])new Object[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        s[N++] = item;
    }

    public Item pop() {
        Item item = s[--N];
        s[N] = null;
        return item;
    }
}
