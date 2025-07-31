import java.util.*;
public class ComparatorReuse {
    public static void main(String[] args) {
        List<Integer> descending=Arrays.asList(5,2,8,1,9);
        descending.sort((a,b) -> b-a);
        System.out.println("Descending order: "+descending);
    }
}
