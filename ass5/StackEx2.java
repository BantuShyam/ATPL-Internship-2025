import java.util.*;
public class StackEx2 {
    public static  String reverse(String s){
        Stack<Character> st=new Stack<Character>();
        for(char c :s.toCharArray()){
            st.push(c);
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString();

    }
    public static void main(String[] args) {
        String r="shyam";
        System.out.println("Original string is "+r);
        System.out.println("Reversed String using stack is "+reverse(r));
    }
}
