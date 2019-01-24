package ga222gb_assign1.intCollection;

public class ArrayIntList extends AbstractIntCollection implements IntList {

    public void add(int n){
        if(size == values.length){
            resize();
        }
        super.values[size++] = n;
    }

    public void addAt(int n, int index){
        int tmp = values[index];
        values[index] = n;
        for(int i = index + 1; i < size + 1; i++){
            int newTemp = values[i];
            values[i] = tmp;
            tmp = newTemp;
        }
        size++;
    }

    public void remove(int index){
        int[] copy = new int[values.length - 1];
        System.arraycopy(values, 0, copy, 0, index);
        System.arraycopy(values, index + 1, copy, index, values.length - index - 1);
        size--;
        values = copy;
    }

    public int get(int index){
        return values[index];
    }

    public int indexOf(int n){
        for(int i = 0; i < values.length; i++){
            if(values[i] == n){
                return i;
            }
        }
        return -1;
    }
}
