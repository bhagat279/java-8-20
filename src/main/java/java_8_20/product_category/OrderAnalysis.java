package java_8_20.product_category;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Product {
    private String productName;
    private String category;

    public Product(String productName, String category) {
        this.productName = productName;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}

class Order {
    private int orderId;
    private Product product;
    private int quantity;

    public Order(int orderId, Product product, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}

public class OrderAnalysis {
    public static void main(String[] args) {
        // Sample data
        Product product1 = new Product("Laptop", "Electronics");
        Product product2 = new Product("Phone", "Electronics");
        Product product3 = new Product("Shirt", "Clothing");
        Product product4 = new Product("Shoes", "Clothing");
        Product product5 = new Product("Table", "Furniture");
        Product product6 = new Product("Headphones", "Electronics");
        Product product7 = new Product("Jacket", "Clothing");
        Product product8 = new Product("Couch", "Furniture");

        Order order1 = new Order(1, product1, 1);
        Order order2 = new Order(2, product2, 2);
        Order order3 = new Order(3, product1, 3);
        Order order4 = new Order(4, product3, 1);
        Order order5 = new Order(5, product4, 1);
        Order order6 = new Order(6, product1, 1);
        Order order7 = new Order(7, product3, 2);
        Order order8 = new Order(8, product2, 1);
        Order order9 = new Order(9, product6, 10);
        Order order10 = new Order(10, product7, 1);
        Order order11 = new Order(11, product5, 2);
        Order order12 = new Order(12, product8, 1);

        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5, order6, order7, order8, order9, order10, order11, order12);

        Map<String, Integer> map = orders.stream().collect(Collectors.groupingBy(
                order -> order.getProduct().getCategory(),
                Collectors.summingInt(order -> order.getQuantity())
        ));

        Map.Entry<String, Integer> stringIntegerEntry = map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get();

        System.out.println(stringIntegerEntry);
    }
}
