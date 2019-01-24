package ga222gb_assign4.binheap;

public class HeapMain {

    public static void main(String[] args){
        BinaryIntHeap heap = new BinaryIntHeap();
        System.out.println(heap.isEmpty());
        heap.insert(90);
        heap.insert(15);
        heap.insert(10);
        heap.insert(7);
        heap.insert(12);
        heap.insert(2);
        heap.pullHighest();
        heap.pullHighest();

        System.out.println(heap.size());

        System.out.println(heap.toString());

    }
}
