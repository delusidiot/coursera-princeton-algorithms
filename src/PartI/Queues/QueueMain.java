package PartI.Queues;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author : delusidiot
 * @fileName : QueueMain
 * @date : 2022-05-03
 */
public class QueueMain {
    public static void main(String[] args) {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        queue.enqueue("test1");
        queue.printQueue();
        queue.enqueue("test2");
        queue.printQueue();
        queue.enqueue("test3");
        queue.printQueue();
        StdOut.println(queue.dequeue());
        queue.printQueue();
        StdOut.println(queue.dequeue());
        queue.printQueue();
        StdOut.println(queue.dequeue());
        queue.printQueue();
    }
}
