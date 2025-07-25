import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;

public class ProductDiscount {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("enter price: ");
        String productPrice=scanner.nextLine();
        Optional<Double> price=productPrice.isEmpty() ? Optional.empty() :Optional.of(Double.parseDouble(productPrice));
        Function<Double,Double> discountFunction=p -> p*0.9;
        double finalPrice=price.map(discountFunction).orElse(0.0);
        System.out.println("Final price after discount :"+finalPrice);
        scanner.close();
    }
}
