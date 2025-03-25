package java_8_20.product_store;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Sale {
    int storeId;
    String productName;

    // Constructor
    public Sale(int storeId, String productName) {
        this.storeId = storeId;
        this.productName = productName;
    }

    // Getters
    public int getStoreId() {
        return storeId;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return "(" + storeId + ", " + productName + ")";
    }
}
public class Main {
    public static void main(String[] args) {
        // Sample data
        List<Sale> sales = Arrays.asList(
                new Sale(1, "Apple"),
                new Sale(1, "Banana"),
                new Sale(1, "Apple"),
                new Sale(2, "Banana"),
                new Sale(2, "Banana"),
                new Sale(2, "Apple"),
                new Sale(3, "Orange")
        );

        Map<Integer, Map<String, Long>> map = sales.stream().collect(Collectors.groupingBy(
                sale -> sale.getStoreId(),
                Collectors.groupingBy(sale -> sale.productName, Collectors.counting())
        ));

      map.forEach((id,pmap)->{

          Map.Entry<String, Long> productHighestCount = pmap.entrySet().stream().max(Comparator.comparingLong(e -> e.getValue())).get();

          System.out.println(id+":"+productHighestCount.getKey());
      });




    }
}
//.Write a program that finds the most common Product name sold per storeId and prints the result as a tuple (storeId, ProductName)