import java.util.*;

public class StackEx {
    public static void main(String[] args) {
        Stack<Integer> s=new Stack<Integer>();
        s.push(15);
        s.push(18);
        s.push(20);
        s.push(21);
        s.push(36);
        System.out.println("Stack before removal "+s);
        int r1=s.pop();
        System.out.println("removed element "+r1);
        int r2=s.pop();
        System.out.println("removed element "+r2);
        System.out.println("Stack elements are "+s);


        
    }
}
