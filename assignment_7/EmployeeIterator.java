import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String toString() {
        return id + "-" + name + " Salary: " + salary;
    }
}

public class EmployeeIterator {
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<Employee>();
        empList.add(new Employee(101, "Shyam", 45000));
        empList.add(new Employee(102, "Balaram", 28000));
        empList.add(new Employee(103, "Akbar", 32000));
        empList.add(new Employee(104, "jayasai", 25000));
        empList.add(new Employee(105, "Manoj", 50000));

        System.out.println("Before removal:");
        printList(empList);
        Iterator<Employee> iterator = empList.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.getSalary() < 30000) {
                iterator.remove(); 
            }
        }

        System.out.println("\nAfter removal (salary < 30000 removed):");
        printList(empList);
    }

    static void printList(List<Employee> list) {
        for (Employee emp: list) {
            System.out.println(emp);
        }
    }
}
