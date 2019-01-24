package ga222gb_assign2.queue;

import java.util.EmptyStackException;
import java.util.Iterator;

public class ArrayQueue implements Queue{
    private int size = 0;
    private int first = 0;
    private int last = 0;
    private Object[] arr = new Object[5];

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    public void enqueue(Object element){
        if(size == arr.length){
            if(last == first){
                resize();
                last = arr.length / 2;
                first = 0;
            }
        }
        arr[last] = element;
        size++;
        last = (last + 1) % arr.length;
    }

    public Object dequeue(){
        if(!isEmpty()){
            Object temp = arr[first];
            arr[first] = null;
            first = (first + 1) % arr.length;
            size--;
            if(first == last){
                first = 0;
                last = 0;
            }
            return temp;
        }
        throw new EmptyStackException();
    }

    public Object first(){
        for(int i = 0; i < arr.length; i++){
            if(arr[i]!= null){
                return arr[i];
            }
        }
        throw new EmptyStackException();
    }

    public Object last(){
        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i] != null){
                return arr[i];
            }
        }
        throw new EmptyStackException();
    }

    public String toString(){
        StringBuffer buf = new StringBuffer();
        buf.append("[");
        for (int i = 0; i < arr.length; i++) {
            buf.append(" " + arr[i]);
        }
        buf.append(" ]");
        return buf.toString();
    }

    public Iterator<Object> iterator(){
        return new ObjectIterator();
    }

    class ObjectIterator implements Iterator<Object>{
        private int count = 0;

        public Object next(){
            return arr[count++];
        }

        public boolean hasNext(){
            return count < arr.length;
        }

        public void remove() {
            throw new RuntimeException("remove() is not implemented");
        }
    }

    private void resize(){
        Object[] tmp = new Object[2*arr.length];
        System.arraycopy(arr,0,tmp,0,arr.length);
        arr = tmp;
    }
}
