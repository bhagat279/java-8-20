package java_8_20.productcategory;

public class Product {
    int id;
    int categoryId;
    String name;

    public Product(int id, int categoryId, String name) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                '}';
    }
}
