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

public class DeserializeStudents {
    public static void main(String[] args) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("students.ser"))) {
            Student[] students = (Student[]) in.readObject();
            System.out.println("-- Using String.format --");
            System.out.printf("%-6s %-12s %-4s %-15s %-5s%n", "ID", "Name", "Age", "Department", "GPA");
            System.out.println("------------------------------------------------------");
            for (Student s : students) {
                String formatted = String.format("%-6d %-12s %-4d %-15s %-5.2f",s.id, s.name, s.age, s.department, s.gpa);
                System.out.println(formatted);
            }
            System.out.println("\n== Using MessageFormat ==");
            String pattern = "ID={0}, Name={1}, Age={2}, Department={3}, GPA={4,number,#.##}";
            for (Student s : students) {
                String msg = MessageFormat.format(pattern, s.id, s.name, s.age, s.department, s.gpa);
                System.out.println(msg);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error during deserialization: " + e.getMessage());
        }
    }
}
