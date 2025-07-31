import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommonElements {
    public static void main(String[] args) {
        Set<Integer> firstSet=new HashSet<>(Arrays.asList(15,36,37,21,20,19));
        Set<Integer> secondSet=new HashSet<>(Arrays.asList(37,21,20,19));
        Set<Integer> uniqueSet=new HashSet<>(firstSet);
        uniqueSet.retainAll(secondSet);
        System.out.println("Common elements are "+uniqueSet);
        Set<Integer> unionSet=new HashSet<>(firstSet);
        unionSet.addAll(secondSet);
        System.out.println("union of elements are "+unionSet);
        Set<Integer> differSet=new HashSet<>(firstSet);
        differSet.removeAll(secondSet);
        System.out.println("different elements are "+differSet);


    }
}
