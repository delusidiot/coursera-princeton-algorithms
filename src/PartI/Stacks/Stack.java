package PartI.Stacks;

import PartI.CustomCollection;

public interface Stack<E> extends CustomCollection<E> {
    E push(E item);
    E pop();
}
