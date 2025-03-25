package java_8_20.region_sale;

import java.util.*;
import java.util.stream.Collectors;

class Sale {
    private String region;
    private double amount;

    public Sale(String region, double amount) {
        this.region = region;
        this.amount = amount;
    }

    public String getRegion() {
        return region;
    }

    public double getAmount() {
        return amount;
    }
}

public class SalesAnalysis {
    public static void main(String[] args) {
        // Sample Sales data
        Sale sale1 = new Sale("North", 500.0);
        Sale sale2 = new Sale("South", 700.0);
        Sale sale3 = new Sale("East", 400.0);
        Sale sale4 = new Sale("West", 300.0);
        Sale sale5 = new Sale("North", 800.0);
        Sale sale6 = new Sale("South", 600.0);
        Sale sale7 = new Sale("East", 900.0);
        Sale sale8 = new Sale("West", 200.0);

        // List of all sales
        List<Sale> saleList = Arrays.asList(sale1, sale2, sale3, sale4, sale5, sale6, sale7, sale8);

        Map<String, Double> map = saleList.stream().collect(Collectors.groupingBy(
                sale -> sale.getRegion(),
                Collectors.summingDouble(sale -> sale.getAmount())
        ));

      Map.Entry<String ,Double> entry=  map.entrySet().stream().sorted(
                Comparator.comparing((Map.Entry<String, Double> e) -> e.getValue())
                        .thenComparing(e -> e.getKey())
                        .reversed())
                .skip(1)
                .limit(1)
                .findFirst()
                .get();


        System.out.println(entry);




    }
}
