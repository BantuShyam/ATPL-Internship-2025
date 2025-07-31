
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

class Employee{
    private String name;
    private double salary;
    private String email;
    public Employee(String name, double salary, String email){
        this.name=name;
        this.salary=salary;
        this.email=email;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
    public double getSalary(){
        return salary;
    }
    public Optional<String> getEmail(){
        return Optional.ofNullable(email);
    }
}

public class EmployeeFilter{
    public static void main(String[] args) {
        List<Employee> employee=Arrays.asList(
            new Employee("Shyam",50000,"shyam18@gmail.com"),
            new Employee("Balaram",55000,null),
            new Employee("Sai",52000,null),
            new Employee("Manoj",45000,"manoj43@gmail.com"));
            Predicate<Employee> highSalary=(e)->e.getSalary()>=50000;
            employee.stream()
            .filter(highSalary)
            .forEach(e-> {System.out.println(e.getName() +" has salary: "+e.getSalary());
            e.getEmail().ifPresentOrElse(email-> System.out.println("Email: " + email),
            () -> System.out.println("Email not available"));
        });

    }
    
}