import java.util.*;

public class ProductPrice {
    public static void main(String[] args) {
        Map<String, Integer> productPrices = new HashMap<String, Integer>();
        productPrices.put("Laptop", 55000);
        productPrices.put("Phone", 500);
        productPrices.put("Washing Machine", 1500);
        productPrices.put("Television", 12000);
        productPrices.put("Computer", 8000);

        Iterator<Map.Entry<String, Integer>> iterator = productPrices.entrySet().iterator();

        System.out.println("Product Prices:");
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String product = entry.getKey();
            Integer price = entry.getValue();
            System.out.println(product + " ->" + price);
        }
    }
}
