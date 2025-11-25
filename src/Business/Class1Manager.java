package Business;

import Persistance.ProductsDAO;

import java.util.ArrayList;


public class Class1Manager {
    ProductsDAO productsDAO;
    public Class1Manager(ProductsDAO productsDAO) {
        this.productsDAO = productsDAO;
    }
    public ArrayList<Product> getAllClass1(){
        ArrayList<Product> classes1 = this.productsDAO.getAllProducts();

        return classes1;
    }
    public boolean checkFile() {
        return true; //To do
    }


}
