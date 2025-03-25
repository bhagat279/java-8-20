package java_8_20.productcategory;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/*
Write a program that finds the category with the most products and prints the category name along with the product name.
 */

public class MaxCategoryFind {
    public static void main(String[] args) {
        // Sample data
        List<Product> products = Arrays.asList(
                new Product(1, 101, "Laptop"),
                new Product(2, 101, "Smartphone"),
                new Product(3, 102, "Shirt"),
                new Product(4, 102, "Trousers"),
                new Product(5, 103, "Shoes"),
                new Product(6, 103, "Slippers"),
                new Product(7, 103, "Boots")
        );

        List<Category> categories = Arrays.asList(
                new Category(101, "Electronics"),
                new Category(102, "Clothing"),
                new Category(103, "Footwear")
        );

    Map<Integer,List<Product>> map=  products.stream().collect(Collectors.groupingBy(
             product -> product.categoryId

     ));

     Map.Entry<Integer,List<Product>> entry= map.entrySet().stream().max(Comparator.comparingInt(
           e->e.getValue().size())).get();




        Category category1 = categories.stream().filter(category -> category.categoryId == entry.getKey())
                .findFirst().get();

        entry.getValue().forEach(p-> System.out.println(category1.categoryName+":"+p.name));

    }
}
