import java.lang.*;
public class StringMethods {
    public static void main(String[] args){
        String s="Java Programming";
        String trim=s.trim();
        System.out.println("Trimmed String: "+trim);
        String lower=s.toLowerCase();
        System.out.println("Lowercase String: "+lower);
        String upper=s.toUpperCase();
        System.out.println("Uppercase String: "+upper);
        String replace=s.replace('m','i');
        System.out.println("Replaced String: "+replace);
        String sub=s.substring(0,4);
        System.out.println("Substring: "+sub);
        int findIndex=s.indexOf('a');
        System.out.println("Index of 'a': "+findIndex);
    }

    }