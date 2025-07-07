
import java.util.Arrays;
import java.util.Collections;

public class Sort{
    public static void main(String[] args) {
        String[] names={"shyam","balaram","akbar","sai","jaya"};
        Arrays.sort(names);
        System.out.println("ascending order");
         // Print the sorted names
        for(String name:names){
            System.out.println(name);
        }
        Arrays.sort(names,Collections.reverseOrder());
        System.out.println("descending order");
         // Print the sorted names
        for(String name:names){
            System.out.println(name);
        }
    }
}