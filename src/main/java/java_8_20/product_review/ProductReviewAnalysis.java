package java_8_20.product_review;

import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String productName;
    private String category;

    public Product(String productName, String category) {
        this.productName = productName;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

class Review {
    private Product product;
    private double rating;

    public Review(Product product, double rating) {
        this.product = product;
        this.rating = rating;
    }

    public Product getProduct() {
        return product;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Review{" +
                "product=" + product +
                ", rating=" + rating +
                '}';
    }
}
public class ProductReviewAnalysis {
    public static void main(String[] args) {
        // Sample products
        Product product1 = new Product("Laptop", "Electronics");
        Product product2 = new Product("Phone", "Electronics");
        Product product3 = new Product("Shirt", "Clothing");
        Product product4 = new Product("Shoes", "Clothing");

        // Sample reviews
        Review review1 = new Review(product1, 4.5);
        Review review2 = new Review(product1, 5.0);
        Review review3 = new Review(product2, 3.8);
        Review review4 = new Review(product2, 4.2);
        Review review5 = new Review(product3, 4.7);
        Review review6 = new Review(product3, 4.9);
        Review review7 = new Review(product4, 3.9);
        Review review8 = new Review(product4, 4.0);

        List<Review> reviews = Arrays.asList(review1, review2, review3, review4, review5, review6, review7, review8);

    /*  Map<String,Double> categoryByRating = reviews.stream().collect(Collectors.toMap(
               review -> review.getProduct().getCategory(),
               review->review.getRating(),
               (r1,r2)->r1>r2?r1:r2,
              LinkedHashMap::new
       ));


      categoryByRating.forEach((cat,rat)->{
          System.out.println(cat+":"+rat);
      });*/

//==========================================Using maxBy()===============================================================
        Map<String, Optional<Review>> collect = reviews.stream().collect(Collectors.groupingBy(
                review -> review.getProduct().getCategory(),
                Collectors.maxBy(Comparator.comparingDouble(Review::getRating))

        ));

        collect.forEach((key,review)->{
           //System.out.println(key+":"+review.get().getProduct().getProductName()+":"+review.get().getRating());

         //   review.ifPresent(r-> System.out.println(r.getProduct().getCategory()+":"+r.getRating()));

        });
//======================================================================================================================
    }
}
