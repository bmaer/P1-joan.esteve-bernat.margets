package Persistance;

import Business.Product;

import java.util.ArrayList;

public interface ProductsDAO {

    public ArrayList<Product> getAllProducts();

    public Product getProductById(String id);

    public ArrayList<Product> searchByBrandName(String category);

    public Boolean check();


}
