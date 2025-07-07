import java.lang.*;
public class Concate{
    public static void main(String[] args) {
        String ls[]={"hello","hii","everyone"};
        StringBuilder sb=new StringBuilder();
        StringBuffer sf=new StringBuffer();
        String fullString="";
        for(String s :ls){
            fullString+=s;
        }
        for(String s:ls){
            sb.append(s);
        }
        for(String s :ls){
            sf.append(s);
        }

    System.out.println("Concatenated String using + operator: " + fullString);
        System.out.println("Concatenated String using StringBuilder: " + sb.toString());
        System.out.println("Concatenated String using StringBuffer: " + sf.toString());
 }
 }