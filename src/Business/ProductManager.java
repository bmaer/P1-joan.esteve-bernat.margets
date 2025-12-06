package Business;

import Persistance.ProductsDAO;

import java.util.ArrayList;


public class ProductManager {
    ProductsDAO productsDAO;
    public ProductManager(ProductsDAO productsDAO) {
        this.productsDAO = productsDAO;
    }

    public ArrayList<Product> getAllProducts() {
        return productsDAO.getAllProducts();
    }

    public Product getProductById(String id) {
        return productsDAO.getProductById(id);
    }

    public ArrayList<Product> searchByBrandName(String category) {
        return productsDAO.searchByBrandName(category);
    }
    public boolean checkFile() {
        return productsDAO.check();
    }

    public ArrayList<Product> searchByName(String name) {
        return productsDAO.searchByName(name);
    }

    public ArrayList<Product> getProductsByIds(ArrayList<String> productIds){
        return productsDAO.getProductsByIds(productIds);
    }


}
