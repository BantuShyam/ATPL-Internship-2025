import java.lang.*;
import java.util.*;

public class Reverse {
    public String reverseLoop(String s){
        String rev="";
       for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        if(ch==' '){
            rev=" "+rev;
        }else{
            rev=ch+rev;
        }
        }
        System.out.println("Reversed String using Loop: " + rev);
        return rev;
    }
    public String reverseByBuilder(String s){
        String rev;
        StringBuilder sb=new StringBuilder(s);
        rev=sb.reverse().toString();
        System.out.println("Reversed String using StringBuilder: " + rev);
        return rev;
    }
    public String reverseByBuffer(String s){
        String rev;
        StringBuffer sf=new StringBuffer(s);
        rev=sf.reverse().toString();
        System.out.println("Reversed String using StringBuffer: " + rev);
        return rev;
    }
   public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       Reverse r=new Reverse();
       String s=sc.nextLine();
       r.reverseLoop(s);
       r.reverseByBuilder(s);
         r.reverseByBuffer(s);
        
       }
}