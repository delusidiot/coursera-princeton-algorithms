package PartI.Queues;

import PartI.CustomCollection;

/**
 * @author : delusidiot
 * @fileName : Queue
 * @date : 2022-05-03
 */
public interface Queue<E> extends CustomCollection {
    void enqueue(E item);
    E dequeue();
    boolean isEmpty();
    int size();
}
