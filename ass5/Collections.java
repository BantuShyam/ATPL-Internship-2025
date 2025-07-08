import java.util.*;
public class Collections{
    public static void main(String[] args) {
        List<String> ls=new ArrayList<>();
        ls.add("kohli");
        ls.add("dhoni");
        ls.add("rohit");
        ls.add("raina");
        ls.add("sehwag");
        System.out.println("Printing names using  for ");
        for(int i=0;i<ls.size();i++){
            System.out.println(ls.get(i));
        }
        System.out.println("Printing names using enhanced for ");
        for(String s:ls){
            System.out.println(s);
        }
        String remove =ls.remove(3);
        System.out.println("Removed Element "+remove);
        System.out.println("Remaining names: "+ls);
    }
}