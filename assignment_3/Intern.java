public class Intern{
    public static void main(String[] args){
        String a = new String("hello");
        String b=a.intern();
        String c="hello";
        System.out.println("a==b: " + (a == b));
        System.out.println("b==c: " + (b == c)); 
        System.out.println("a==c: " + (a == c)); 

    }
}