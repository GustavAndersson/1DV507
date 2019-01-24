package ga222gb_assign1.intCollection;

public class CollectionMain {

    public static void main(String[] args){

        System.out.println("Stack: ");
        IntStack stack = new ArrayIntStack();   //Create new stack
        stack.push(4);                       //Add some values
        stack.push(6);
        stack.push(1);
        System.out.println(stack.peek());       //return 1
        System.out.println(stack.size());       //size = 3
        System.out.println(stack.toString());   //[ 4 6 1 ]
        stack.pop();                            //delete 1
        System.out.println(stack.toString());   //[ 4 6 ]
        stack.pop();                            //delete remaining ---> empty
        stack.pop();
        System.out.println(stack.isEmpty());    //return true

        System.out.println("List: ");
        IntList list = new ArrayIntList();      //Create new list
        list.add(1);                            //Add some values
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(3);                     //remove n at pos 3
        System.out.println(list.indexOf(3));     //3 is at pos 2
        list.addAt(7, 1);                //[ 1 7 2 3 ]
        System.out.println(list.size());         //size = 4
        System.out.println(list.toString());
    }
}
