
import java.time.LocalDate;

public class DateManipulation {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Original Date: " + today);
        LocalDate addDays= today.plusDays(10);
        System.out.println("After adding 10 days: " + addDays);
        LocalDate minusMonths= addDays.minusMonths(2);
        System.out.println("After subtracting 2 months: " + minusMonths);
    }
}
