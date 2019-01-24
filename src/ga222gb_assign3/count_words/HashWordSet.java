package ga222gb_assign3.count_words;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashWordSet implements WordSet{

    private int size; //Current size
    private Node[] buckets = new Node[8];

    public void add(Word word){
        int pos = getBucketNumber(word);
        Node node = buckets[pos];
        while(node != null){
            if(node.value.equals(word)){
                return;
            }else{
                node = node.next;
            }
        }

        node = new Node(word);
        node.next = buckets[pos];
        buckets[pos] = node;
        size++;
        if(size == buckets.length){
            rehash();
        }
    }

    public String toString(){
        Node node;
        StringBuffer buf = new StringBuffer();
        for(int i = 0; i < buckets.length; i++){
            if(buckets[i] != null){
                node = buckets[i];
                buf.append(" " + node.value);
                while (node.next != null){
                    node = node.next;
                    buf.append(" "  + node.value);
                }
            }
        }
        return buf.toString();
    }

    public boolean contains(Word word){
        int pos = getBucketNumber(word);
        Node node = buckets[pos];
        while(node != null){
            if(node.value.equals(word)){
                return true;
            }else{
                node = node.next;
            }
        }
        return false;
    }

    public int size(){
        return size;
    }

    private void rehash(){
        Node[] temp = buckets;
        buckets = new Node[2*temp.length];
        size = 0;
        for(Node n : temp){
            if(n == null){
                continue;
            }
            while(n != null){
                add(n.value);
                n = n.next;
            }
        }
    }

    private int getBucketNumber(Word word){
        int hc = word.hashCode();
        if(hc < 0){
            hc = -hc;
        }
        return hc % buckets.length;
    }

    private class Node{
        Word value;
        Node next = null;

        public Node(Word w){
            value = w;
        }

        public String toString(){
            return value.toString();
        }
    }

    public Iterator<Word> iterator(){
        return new NodeIterator();
    }

    /*
        Same problem with this iterator. Tried to solve it but didn't find a working solution.
        Probably the hardest part of the assignment along with the iterator in TreeSet.
     */
    class NodeIterator implements Iterator<Word>{
        private int bucket = 0;
        private Node node = null;

        public Word next(){
            return null;
        }

        public boolean hasNext(){
            return false;
        }

        public void remove(){
            throw new RuntimeException("remove() is not implemented");
        }
    }
}
