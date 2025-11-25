package Business;

import Persistance.ProductsDAO;

import java.util.ArrayList;


public class ProductManager {
    ProductsDAO productsDAO;
    public ProductManager(ProductsDAO productsDAO) {
        this.productsDAO = productsDAO;
    }


    public boolean checkFile() {
        return productsDAO.check();
    }


}
