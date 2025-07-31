import java.util.*;

public class LinkedListEx {
    public static void main(String[] args) {
        LinkedList<Integer>ll=new LinkedList<Integer>();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        ll.add(50);
        ll.addFirst(5);
        ll.addLast(60);
        int removed=ll.remove(2);
         System.out.println("removed element is: "+removed);

        System.out.println(ll);
        
        
    }
}
