package Persistance;

import Business.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ProductsJSONDAO implements ProductsDAO {
    private static final String path = "src/Persistance/products.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public ProductsJSONDAO() {
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<Product>();
        try{
            FileReader fr = new FileReader(path);
            Type type = new TypeToken<ArrayList<Product>>(){}.getType();
            products = gson.fromJson(fr, type);
        }
        catch (Exception e){
            return null;
        }
        return products;    //To do later
    }

    @Override
    public Product getProductById(String id){
        ArrayList<Product> products = new ArrayList<Product>();
        Product product = null;
        try{
            FileReader fr = new FileReader(path);
            Type type = new TypeToken<ArrayList<Product>>(){}.getType();
            products = gson.fromJson(fr, type);
            for(int i = 0; products.size() > i; i++ ){
                if(id.equals(products.get(i).getProduct_id())){
                    product = products.get(i);

                }
            }
        }
        catch (Exception e){
            return null;
        }
        return product;
    }

    @Override
    public ArrayList<Product> searchByBrandName(String brand){
        ArrayList<Product> products = new ArrayList<Product>();
        ArrayList<Product> newProduct = new ArrayList<Product>();
        try{
            FileReader fr = new FileReader(path);
            Type type = new TypeToken<ArrayList<Product>>(){}.getType();
            products = gson.fromJson(fr, type);
            for(int i = 0; products.size() > i; i++ ){
                if(brand.equals(products.get(i).getBrand())){
                    newProduct.add(products.get(i));
                }
            }
        }
        catch (Exception e){
            return null;
        }
        return newProduct;
    }

    @Override
    public Boolean check(){
        File file = new File(path);
        return file.exists();
    }


}
