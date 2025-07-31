
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingStrings {
    public static void main(String[] args) {
        List<String> fruits=Arrays.asList("banana","apple","mango","cherry");
        //alphabetical order
        List<String> alphabetical=new ArrayList<>(fruits);
        alphabetical.sort((s1, s2) -> s1.compareTo(s2));
        System.out.println("Fruits in alphabetical order: " + alphabetical);
        //reverse alphabetical order
        List<String> reverse=new ArrayList<>(fruits);
        reverse.sort((s1,s2)-> s2.compareTo(s1));
        System.out.println("Fruits in reverse alphabetical order: " + reverse);

        
    }
}
