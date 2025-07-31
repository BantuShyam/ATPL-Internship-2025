package Package_b;
import Package_a.*;

public class Class_B extends Class_A {
    public static void main(String[] args) {
        Class_B cls=new Class_B();
        System.out.println("protected string from another package "+cls.s1);
        // System.out.println("protected string from another package"+cls.s2);


    }
}
