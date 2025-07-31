import java.util.Arrays;
import java.util.List;

public class EvenNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        for (Integer num : numbers) {
            if (((NumberCheck) (n -> n % 2 == 0)).check(num)) {
                System.out.print(num + " ");
            }
        }
    }
    interface NumberCheck {
        boolean check(int n);
    }
}
