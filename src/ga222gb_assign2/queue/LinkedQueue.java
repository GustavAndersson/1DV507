package ga222gb_assign2.queue;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * A class that implements the interface <code>Queue</code>.
 * All functions required are implemented in this class.
 *
 * @author Gustav Andersson
 * @since 2018-02-11
 */
public class LinkedQueue implements Queue{
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    /**
     * Gets the size of the Queue.
     *
     * @return An integer representing the size of the queue.
     */
    public int size(){
        return size;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return A boolean representing if the queue is empty.
     */
    public boolean isEmpty(){
        if(head == null){
            return true;
        }
        return false;
    }

    /**
     * Inserts object <code>element</code> at the last position in the queue.
     *
     * @param element to be added
     */
    public void enqueue(Object element){
        if(head == null){
            head = new Node(element);
            tail = head;
        }else{
            tail.next = new Node(element);
            tail = tail.next;
        }
        size++;
    }

    /**
     * Removes and returns the current element at the first position in the queue.
     *
     * @return Object that was removed.
     */
    public Object dequeue(){
        if(!isEmpty()){
            Node first = head;
            Node peke = head.next;
            head = null;
            head = peke;
            size--;
            return first.value;
        }
        throw new EmptyStackException();
    }

    /**
     * Gets the element at the first position in the queue.
     *
     * @return First object in the queue.
     */
    public Object first(){
        if(!isEmpty()){
            return head.value;
        }
        throw new EmptyStackException();
    }

    /**
     * Gets the last element in the queue.
     *
     * @return Last object in the queue.
     */
    public Object last(){
        if(!isEmpty()){
            return tail.value;
        }
        throw new EmptyStackException();
    }

    /**
     * Gets a string representation of the current queue content.
     * For example, "[ 1 4 84 12 7 99 ... ]".
     *
     * @return String representation of the content.
     */
    public String toString(){
        StringBuffer buf = new StringBuffer();
        buf.append("[");
        Node node = head;
        while(node != null){
            buf.append(" " + node.value);
            node = node.next;
        }
        buf.append(" ]");
        return buf.toString();
    }

    /**
     * Gets an iterator that can iterate through all the elements.
     *
     * @return An iterator
     */
    public Iterator<Object> iterator(){
        return new NodeIterator();
    }

    class NodeIterator implements Iterator<Object>{
        private Node node = head;
        public Object next(){
            Object val = node.value;
            node = node.next;
            return val;
        }

        public boolean hasNext(){
            return node != null;
        }

        public void remove(){
            throw new RuntimeException("remove() is not implemented");
        }
    }

    private class Node{
        Object value;
        Node next = null;

        Node(Object v){
            value = v;
        }
    }
}
