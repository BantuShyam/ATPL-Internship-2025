import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;
    private int marks;

    public Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public String getName(){ 
        return name;
      }
    public int getAge(){
         return age; 
         }
    public int getMarks(){ 
        return marks; 
        }

    public String toString() {
        return id + "-" + name + " (Age: " + age + ", Marks: " + marks + ")";
    }
}
class NameComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.getName().compareToIgnoreCase(s2.getName());
    }
}

class MarksComparatorDesc implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s2.getMarks() - s1.getMarks();
    }
}

class AgeComparatorAsc implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.getAge() - s2.getAge();
    }
}
class MarksThenNameComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        int cmp = s2.getMarks() - s1.getMarks();
        if (cmp == 0) {
            return s1.getName().compareToIgnoreCase(s2.getName());
        }
        return cmp;
    }
}

public class StudentComparator {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "Shyam", 21, 85));
        students.add(new Student(2, "Balaram", 22, 90));
        students.add(new Student(3, "jayasai", 23, 87));
        students.add(new Student(4, "Manoj", 22, 75));
        students.add(new Student(5, "Akbar", 20, 80));

        System.out.println("Original List:");
        printList(students);

        Collections.sort(students, new NameComparator());
        System.out.println("\nSorted by Name:");
        printList(students);

        Collections.sort(students, new MarksComparatorDesc());
        System.out.println("\nSorted by Marks (Descending):");
        printList(students);

        Collections.sort(students, new AgeComparatorAsc());
        System.out.println("\nSorted by Age (Ascending):");
        printList(students);

        Collections.sort(students, new MarksThenNameComparator());
        System.out.println("\nSorted by Marks Descending, then Name Ascending:");
        printList(students);

        // Java 8 Comparator chaining
        Comparator<Student> marksThenName =
            Comparator.comparingInt(Student::getMarks).reversed()
                      .thenComparing(Student::getName);

        students.sort(marksThenName);
        System.out.println("\nSorted using Comparator.comparing + thenComparing:");
        printList(students);

        // Anonymous Comparator for Integer sort (descending)
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(12);
        numbers.add(7);
        numbers.add(19);
        numbers.add(3);
        numbers.add(15);

        Collections.sort(numbers, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        System.out.println("\nSorted Integers Descending: " + numbers);

        // Iterator to remove students with marks < 80
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().getMarks() < 80) {
                it.remove(); // safe removal during iteration
            }
        }
        System.out.println("\nAfter removing students with marks < 80:");
        printList(students);
    }

    static void printList(List<Student> list) {
        for (Student s : list) {
            System.out.println(s);
        }
    }
}
