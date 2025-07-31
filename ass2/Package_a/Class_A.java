package Package_a;
public class Class_A{
    protected String s1="shyam";
    String s2="balaram";
    public static void main(String[] args){
        Class_A cl=new Class_A();
        System.out.println("protected string inside class "+cl.s1);
        System.out.println("default string value is "+cl.s2);
    }
}