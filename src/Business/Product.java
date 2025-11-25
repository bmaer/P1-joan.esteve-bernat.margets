package Business;

public class Product {
    String product_id;
    String product_name;
    String brand;
    String model;

    public Product(String product_id, String product_name, String brand, String model) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.brand = brand;
        this.model = model;
    }
    public String  getProduct_id() {
        return product_id;
    }
    public String getProduct_name() {
        return product_name;
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public Product(){}
}
