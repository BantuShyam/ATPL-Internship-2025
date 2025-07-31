import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.MessageFormat;

class Student implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    int id;
    String name;
    int age;
    String department;
    double gpa;

    public Student(int id, String name, int age, String department, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.gpa = gpa;
    }
}

public class StudentSummary {
    public static void main(String[] args) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("students.ser"))) {
            Student[] students = (Student[]) in.readObject();
            String summaryTemplate = "Student {0} from {1} department has a GPA of {2,number,#.##}.";

            System.out.println("== Student Summary ==");
            for (Student s : students) {
                String summary = MessageFormat.format(summaryTemplate, s.name, s.department, s.gpa);
                System.out.println(summary);
            }

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading students.ser: " + e.getMessage());
        }
    }
}
