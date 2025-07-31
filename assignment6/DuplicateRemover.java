import java.util.*;
public class DuplicateRemover{
    public static void main(String[] args){
        List<Integer> list=Arrays.asList(1,34,35,34,65,87,1,23,32,23,34);
        Set<Integer> set=new LinkedHashSet<>(list);
        List<Integer>unique= new ArrayList<>(set);
        System.out.println("original list: "+list);
        System.out.println("list after removing duplicates: "+unique);

    }
}