public class Immutable{
    public static void main(String[] args){
        String s1="hello";
        System.out.println("Original String is "+s1);
        String s2=s1;
        s1=s1.concat("World");
        System.out.println("Second String is "+s2);
        System.out.println("Updated String is "+s1);
    }
}