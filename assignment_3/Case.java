public class Case{
    public static void main(String[] args) {
        String s1="Hello";
        String s2="hello";
        System.out.println("using equals "+s1.equals(s2));
        System.out.println("using equalsIgnoreCase "+s1.equalsIgnoreCase(s2));
        System.out.println("using compareTo "+s1.compareTo(s2));
    }
}