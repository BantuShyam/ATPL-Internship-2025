public class WrapperClass {
    public static void main(String[] args) {
        int i = 15;
        double d = 72.56;
        char c = 'S';
        boolean b = true;

        Integer intObj = Integer.valueOf(i);
        Double doubleObj = d;
        Character charObj = c;
        Boolean boolObj = Boolean.valueOf(b);
        System.out.println("Integer value   : " + intObj + " of Class: " + intObj.getClass().getName());
        System.out.println("Double value    : " + doubleObj + " of Class: " + doubleObj.getClass().getName());
        System.out.println("Character value : " + charObj + " of Class: " + charObj.getClass().getName());
        System.out.println("Boolean value   : " + boolObj + " of Class: " + boolObj.getClass().getName());
    }
}
