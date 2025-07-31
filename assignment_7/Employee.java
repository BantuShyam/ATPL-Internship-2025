import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Employee {
////used for Wrapper class
//	Integer id;
	int id;
	String name;
	String department;
	double salary;
	public Employee(int id,String name,String department,double salary) {
		this.id=id;
		this.name=name;
		this.department=department;
		//used for converting string salary to double
//		this.salary=Double.parseDouble(salary);
	}
	public String toString() {
		return "name: "+name;
	}

	public static void main(String[] args) {
		Comparator<Employee> comparator=new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				if(o1.salary>o2.salary) {
					return 1;
				}
				else {
					return -1;
				}
			}
			
		};
		List<Employee> empList=new ArrayList<>();
		empList.add(new Employee(101,"Shyam","IT",35000));
		empList.add(new Employee(102,"Balaram","HR",36000));
		empList.add(new Employee(103,"Sai","Analyst",34000));
		empList.add(new Employee(104,"Akbar","HR",37000));
		empList.add(new Employee(105,"Kalyan","Tester",31000));
		empList.add(new Employee(106,"Hemanth","HR",32000));
		empList.add(new Employee(107,"JayaSai","Developer",32000));
		empList.add(new Employee(108,"Hemanthrama","IT",33000));
		empList.add(new Employee(109,"Manoj","Business",31000));
		empList.add(new Employee(110,"Sreemanth","IT",36000));
		Collections.sort(empList,comparator);
		System.out.println(empList);
		Iterator<Employee> iterator=empList.iterator();
		while(iterator.hasNext()) {
			Employee emp=iterator.next();
			if(emp.department.equals("HR")) {
				iterator.remove();
			}
		}
		System.out.println(empList);
		
	}


}