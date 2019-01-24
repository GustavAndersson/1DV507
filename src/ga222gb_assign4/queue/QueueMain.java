package ga222gb_assign4.queue;

import java.util.Iterator;

public class QueueMain {
    public static void main(String[] args){

        System.out.println("Linked Queue:");
        Queue<Integer> q = new LinkedQueue();
        System.out.println("Empty: " + q.isEmpty());
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(8);
        q.enqueue(7);
        q.dequeue();
        System.out.println("First: " + q.first());
        System.out.println("Last: " + q.last());

        Iterator<Integer> iterator = q.iterator();

        System.out.println("Iterator: ");
        while(iterator.hasNext()){
            Object val = iterator.next();
            System.out.println(val);
        }

        System.out.println(q.toString());


        Queue<String> q1 = new LinkedQueue();
        System.out.println("Empty: " + q1.isEmpty());
        q1.enqueue("This");
        q1.enqueue("is");
        q1.enqueue("a");
        q1.enqueue("test");
        q1.dequeue();
        System.out.println("First: " + q1.first());
        System.out.println("Last: " + q1.last());

        Iterator<String> iterator1 = q1.iterator();

        System.out.println("Iterator: ");
        while(iterator1.hasNext()){
            Object val = iterator1.next();
            System.out.println(val);
        }

        System.out.println(q1.toString());
    }
}
