package ga222gb_assign1.intCollection;

import java.util.EmptyStackException;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {

    public void push(int n){
        if(size == values.length){
            resize();
        }
        super.values[size++] = n;
    }

    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int value = values[size - 1];
        values[size - 1] = 0;
        size--;
        return value;
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return values[size - 1];
    }
}
