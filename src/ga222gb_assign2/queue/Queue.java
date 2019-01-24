package ga222gb_assign2.queue;

import java.util.Iterator;

/**
 * An interface representing a simple linked queue. This interface defines the required
 * functionality for all <code>Queue</code> implementations.
 *
 * @author Gustav Andersson
 * @since 2018-02-11
 */
public interface Queue {

    /** Number of elements currently stored in the queue. */
    public int size();                     // current queue size

    /** Check if the queue is empty. */
    public boolean isEmpty();              // true if queue is empty

    /**
     * Inserts object <code>element</code> at the last position in the queue.
     *
     * @param element to be added
     */
    public void enqueue(Object element);   // add element at end of queue

    /**
     * Removes and returns the current element at the first position in the queue.
     */
    public Object dequeue();               // return and remove first element.

    /**
     * Returns the first element in the queue.
     */
    public Object first();                 // return (without removing) first element

    /**
     * Returns the last element in the queue.
     */
    public Object last();                  // return (without removing) last element

    /**
     * Returns a string representation of the current queue content.
     * For example, "[ 1 4 84 12 7 99 ... ]".
     *
     * @return      string representation of the content.
     */
    public String toString();              // return a string representation of the queue content

    /**
     * Returns an iterator that can iterate through all the elements.
     */
    public Iterator<Object> iterator();    // element iterator
}
