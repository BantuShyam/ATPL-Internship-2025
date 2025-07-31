import java.io.IOException;
import java.io.PrintWriter;

class Student {
    String name;
    int age;
    String department;
    double gpa;

    Student(String name, int age, String department, double gpa) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.gpa = gpa;
    }

    // For file output
    @Override
    public String toString() {
        return String.format("Student[name=%s, age=%d, department=%s, gpa=%.2f]",
                             name, age, department, gpa);
    }
    // For console table
    String toTableRow() {
        return String.format("%-12s %-4d %-16s %-5.2f", name, age, department, gpa);
    }
}

public class StudentTable {
    public static void main(String[] args) {
        Student[] students = {
            new Student("Shyam",21,"CSE",8.45),
            new Student("Balaram",22,"ECE",9.12),
            new Student("Akash",20,"Mechanical",7.90),
            new Student("Kalyan",23,"Civil",8.02),
            new Student("Sai",21,"IT",8.60)
        };
        try (PrintWriter writer = new PrintWriter("students.txt")) {
            for (Student s : students) {
                writer.println(s);
            }
            System.out.println("Default student details saved.");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
        System.out.println("\n Student Summary");
        System.out.printf("%-12s %-4s %-16s %-5s%n", "Name", "Age", "Department", "GPA");
        System.out.println("============================================");
        for (Student s : students) {
            System.out.println(s.toTableRow());
        }
    }
}
