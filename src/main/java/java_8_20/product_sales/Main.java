package java_8_20.product_sales;

import java.util.*;
import java.util.stream.Collectors;

class Sales {
    String store;
    String product;
    double salesAmount;

    public Sales(String store, String product, double salesAmount) {
        this.store = store;
        this.product = product;
        this.salesAmount = salesAmount;
    }

    public String getStore() {
        return store;
    }

    public String getProduct() {
        return product;
    }

    public double getSalesAmount() {
        return salesAmount;
    }
}
public class Main {
    public static void main(String[] args) {

        List<Sales> salesList = Arrays.asList(
                new Sales("Store1", "ProductA", 100.0),
                new Sales("Store1", "ProductB", 150.0),
                new Sales("Store1", "ProductA", 500.0),
                new Sales("Store2", "ProductC", 300.0),
                new Sales("Store2", "ProductD", 400.0),
                new Sales("Store2", "ProductC", 150.0),
                new Sales("Store3", "ProductE", 50.0),
                new Sales("Store3", "ProductE", 120.0)
        );

    Map<String,Map<String,Double>> storeByProduct= salesList.stream().collect(Collectors.groupingBy(
             sales -> sales.getStore(),
             LinkedHashMap::new,
             Collectors.groupingBy(
                     sale->sale.getProduct(),
                     Collectors.summingDouble(sale->sale.getSalesAmount())
             )
     ));

    storeByProduct.forEach((store,map)->{
      Map.Entry<String,Double> entry=  map.entrySet().stream().max(Comparator.comparingDouble(
                (Map.Entry<String,Double>e)->e.getValue())).get();

        System.out.println(store+":"+entry.getKey()+":"+entry.getValue());

    });

    }
}
// Write a program to find the top-selling product by total sales in each Store from a list of Sales objects, and print the product name and its total sales amount