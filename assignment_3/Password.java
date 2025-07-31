
import java.util.*;
public class Password{
    public static String encrypt(String password){
        return new StringBuilder(password).reverse().substring(0,password.length()/2).toString();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your password:");
        String Original=sc.nextLine();
        String encrypted=encrypt(Original);
        System.out.println("Original Password " + Original);
        System.out.println("Encrypted Password: " + encrypted);
        if(Original.equals(encrypted)){
            System.out.println("Password is valid.");
        }
        else{
            System.out.println("Password is invalid.");
        }


    }
}