import java.util.LinkedList;
import java.util.Queue;

public class CustomerService {
	Queue<String> customer=new LinkedList<>();
	void add(String c) {
		customer.add(c);
	}
	void serve() {
		customer.poll();
		System.out.println("Customer is served");
		
	}
	void nextCustomer() {
		String person=customer.peek();
		System.out.println("Next Customer is "+person);
	}
public static void main(String[] args) {
	
	CustomerService customers=new CustomerService();
	customers.add("shyam");
	customers.add("balaram");
	customers.add("akbar");
	customers.add("jayasai");
	customers.serve();
	customers.nextCustomer();
	System.out.println("The remaining customers to be served are "+customers.customer);
	
}
}
