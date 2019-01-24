package ga222gb_assign2.queue;

import java.util.Iterator;

public class QueueMain {

    public static void main(String[] args){

        System.out.println("Linked Queue:");
        Queue q = new LinkedQueue();
        System.out.println("Empty: " + q.isEmpty());
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(8);
        q.enqueue(7);
        q.dequeue();
        System.out.println("First: " + q.first());
        System.out.println("Last: " + q.last());

        Iterator<Object> iterator = q.iterator();

        System.out.println("Iterator: ");
        while(iterator.hasNext()){
            Object val = iterator.next();
            System.out.println(val);
        }

        System.out.println(q.toString());
        System.out.print("\n");

        System.out.println("Array Queue:");
        Queue arr = new ArrayQueue();
        arr.enqueue(1);
        arr.enqueue(2);
        arr.enqueue(3);
        arr.enqueue(4);
        arr.enqueue(5);
        arr.dequeue();
        arr.dequeue();
        arr.enqueue(9);
        arr.enqueue(8);
        arr.dequeue();

        System.out.println("First element: " + arr.first());
        System.out.println("Last element: " + arr.last());
        System.out.println("Number of elements in array: " + arr.size());

        Iterator<Object> oi = arr.iterator();
        System.out.println("Iterator: ");
        while(oi.hasNext()){
            Object val = oi.next();
            System.out.println(val);
        }

        System.out.println(arr.toString());

    }
}
