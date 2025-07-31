
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekDay {
    public static void main(String[] args) {
        LocalDate day=LocalDate.of(2025,12,25);
        DayOfWeek dayOfWeek=day.getDayOfWeek();
        System.out.println("Day of the week : "+dayOfWeek);
    }
}
