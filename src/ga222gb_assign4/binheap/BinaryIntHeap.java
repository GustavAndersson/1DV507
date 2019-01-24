package ga222gb_assign4.binheap;

import java.util.ArrayList;

/*
The exercise description referred me to the Horstmann book explanation
of Binary Heaps. Therefore I took inspiration from that. Also I made the highest numbers
the highest priority.
 */

public class BinaryIntHeap {
    private ArrayList<Integer> elements = new ArrayList<>();

    public BinaryIntHeap(){
        elements.add(null);
    }

    public void insert(int n){
        elements.add(null);
        int index = elements.size() - 1;

        while(index > 1 && getParent(index) < n){
            elements.set(index, getParent(index));
            index = getParentIndex(index);
        }
        elements.set(index, n);
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(int i = 1; i < elements.size(); i++){
            builder.append(elements.get(i) + " ");
        }
        return builder.toString();
    }

    public int pullHighest(){
        int highest = elements.get(1);
        int lastIndex = elements.size() - 1 ;
        int last = elements.remove(lastIndex);

        if(lastIndex > 1){
            elements.set(1, last);
            percolateDown();
        }
        return highest;
    }

    public int size(){
        return elements.size() - 1;
    }

    public boolean isEmpty(){
        if(elements.size() == 1){
            return true;
        }
        return false;
    }

    private void percolateDown(){
        int root = elements.get(1);
        int lastIndex = elements.size() - 1;
        int index = 1;
        boolean childBigger = true;

        while (childBigger){
            int childIndex = getLeftChildIndex(index);
            if(childIndex <= lastIndex){
                int child = getLeftChild(index);

                if(getRightChildIndex(index) <= lastIndex && getRightChild(index) > child){
                    childIndex = getRightChildIndex(index);
                    child = getRightChild(index);
                }

                if(child > root){
                    elements.set(index, child);
                    index = childIndex;
                }else{
                    childBigger = false;
                }
            }else{
                childBigger = false;
            }
        }
        elements.set(index, root);
    }

    private int getParent(int index){
        return elements.get(index / 2);
    }

    private int getParentIndex(int index){
        return index / 2;
    }

    private int getLeftChild(int index){
        return elements.get(2 * index);
    }

    private int getRightChild(int index){
        return elements.get(2 * index + 1);
    }

    private int getLeftChildIndex(int index){
        return 2 * index;
    }

    private int getRightChildIndex(int index){
        return 2 * index + 1;
    }

}