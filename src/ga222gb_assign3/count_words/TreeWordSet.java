package ga222gb_assign3.count_words;

import java.util.Iterator;

public class TreeWordSet implements WordSet{
    private BST root = null;
    private int size = 0;
    private StringBuffer buf = new StringBuffer();

    public void add(Word w){
        if(root == null){
            root = new BST(w);
        }else{
            root.add(w);
        }
    }

    public String toString(){
        return root.print().toString();
    }

    public boolean contains(Word w){
        return root.contains(w);
    }

    public int size(){
        return size;
    }

    private class BST{
        Word value;
        BST left = null;
        BST right = null;

        BST(Word val){
            value = val;
            size++;
        }

        void add(Word w){
            if(w.compareTo(value) < 0){
                if(left == null){
                    left = new BST(w);
                }else{
                    left.add(w);
                }
            }else if(w.compareTo(value) > 0){
                if(right == null){
                    right = new BST(w);
                }else{
                    right.add(w);
                }
            }
        }

        boolean contains(Word w){
            if(w.compareTo(value) < 0){
                if(left == null){
                    return false;
                }else{
                    return left.contains(w);
                }
            }else if(w.compareTo(value) > 0){
                if(right == null){
                    return false;
                }else{
                    return right.contains(w);
                }
            }
            return true;
        }

        StringBuffer print(){
            if(left != null){
                left.print();
            }
            buf.append(value + " ");
            if(right != null){
                right.print();
            }
            return buf;
        }
    }

    /*
        Had a really hard time with the iterator and in the end it didn't work out.
        I tried to combine it with the print() method but I don't know if that's the
        correct way to solve it. Therefore unfortunately I leave this unsolved..
     */
    public Iterator<Word> iterator(){
        return new TreeIterator();
    }

    class TreeIterator implements Iterator<Word>{
        private BST node = root;

        public Word next(){
            return null;
        }

        public boolean hasNext(){
            return node != null;
        }
    }

}