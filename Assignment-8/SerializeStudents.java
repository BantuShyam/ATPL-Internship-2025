import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
class Student implements Serializable {
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
    @Override
    public String toString() {
        return "Student[id=" + id + ", name=" + name +
               ", age=" + age + ", department=" + department +
               ", gpa=" + gpa + "]";
    }
}

public class SerializeStudents {
    public static void main(String[] args) {
        Student[] students = {
            new Student(1,"Shyam",21,"CSE",8.45),
            new Student(2,"Balaram",23,"ECE",9.12),
            new Student(3,"Akash",22,"Mechanical",7.90),
            new Student(4,"Kalyan",20,"Civil",8.02),
            new Student(5,"Sai",22,"IT",8.60)
        };
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students.ser"))) {
            out.writeObject(students);
            System.out.println("Successfully serialized 5 students to students.ser");
        } catch (IOException e) {
            System.err.println(" Serialization error: " + e.getMessage());
        }
    }
}
