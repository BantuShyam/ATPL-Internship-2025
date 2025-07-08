import imported.*;

public class Access2 extends Access{
    public static void main(String[] args) {
        Access2 a=new Access2();
        System.out.println("public string outside package is "+a.name2);
        System.out.println("protected string outside package through object is "+a.name3);
    }
}
