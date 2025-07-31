
import java.util.Arrays;
import java.util.List;

public class FilteringNames {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Andrew", "Tom", "Angela", "Steve");
        for(String name:names){
            if(((NameCheck)(n->n.startsWith("A"))).check(name)){
                System.out.println("name starts with A: " + name);
            }
        }
    }

interface NameCheck{
    boolean check(String s);
 }
}
