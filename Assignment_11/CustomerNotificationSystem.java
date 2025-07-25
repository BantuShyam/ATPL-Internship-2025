
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class Customer{
    private String name;
    private boolean isSubscribed;
    public Customer(String name,boolean isSubscribed){
        this.name=name;
        this.isSubscribed=isSubscribed;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public boolean isSubscribed(){
        return isSubscribed;
    }
}
public class CustomerNotificationSystem {
    public static void main(String[] args) {
        List<Customer> customers = Arrays.asList(
            new Customer("Shyam", true),
            new Customer("Balaram", false),
            new Customer("Sai", true),
            new Customer("Manoj", true)
        );
        Consumer<Customer> notify=(c) -> System.out.println("Sending notification to : "+c.getName());
        customers.stream()
        .filter(Customer::isSubscribed)
        .forEach(notify);          
    }
}
