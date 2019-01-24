package ga222gb_assign2.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

/*
    This test works for ArrayQueue and LinkedQueue.
    Just scroll down to the build-method and change from ArrayQueue to LinkedQueue
    to test both implementations.
 */
public class QueueTest {

    private static int test_count = 0;

    @BeforeEach
    public void setup(){
        test_count++;
        System.out.println("Test " + test_count);
    }

    @Test
    public void testSize(){
        Queue q = build(3);
        assertEquals(3, q.size());
        q.dequeue();
        q.dequeue();
        q.dequeue();
        assertEquals(0, q.size());
    }

    @Test
    public void testIsEmpty(){
        Queue q = build(3);
        assertEquals(false, q.isEmpty());
        q.dequeue();
        q.dequeue();
        q.dequeue();
        assertEquals(true, q.isEmpty());
    }

    @Test
    public void testEnqueueAndLast(){
        Queue q1 = build(5);
        assertEquals(5, q1.size());

        Queue q2 = build(15);
        assertEquals(15, q2.size());

        assertEquals(4, q1.last());
        assertEquals(14, q2.last());

        Queue q3 = build(0);
        assertThrows(EmptyStackException.class, () -> q3.last());
    }

    @Test
    public void testDequeue(){
        Queue q1 = build(5);
        assertEquals(0, q1.dequeue());

        Queue q2 = build(100);
        assertEquals(0, q2.dequeue());

        q2.dequeue();
        assertEquals(2, q2.dequeue());
        assertEquals(97, q2.size());

        Queue q3 = build(0);
        assertThrows(EmptyStackException.class, () -> q3.dequeue());
    }

    @Test
    public void testFirst() {
        Queue q1 = build(10);
        assertEquals(0, q1.first());

        q1.dequeue(); //Remove 0
        q1.dequeue(); //Remove 1
        q1.dequeue(); //Remove 2

        assertEquals(3, q1.first());
        assertEquals(7, q1.size());

        Queue q2 = build(0);
        assertThrows(EmptyStackException.class, () -> q2.first());
    }

    @Test
    public void testIterator(){
        Queue q = build(20);
        Iterator<Object> it = q.iterator();
        int counter = 0;
        while(it.hasNext()){
            Object val = it.next();
            assertEquals(counter, val);
            counter++;
        }
    }

    /*
    Private method to facilitate tests
     */
    private Queue build(int size) {
        Queue queue = new ArrayQueue();
        for (int i = 0; i < size; i++) {
            queue.enqueue(i);
        }
        return queue;
    }

}
