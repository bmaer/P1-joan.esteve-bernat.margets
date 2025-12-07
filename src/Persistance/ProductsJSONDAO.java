package Persistance;

import Business.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Locale;

public class ProductsJSONDAO implements ProductsDAO {
    private static final String path = "Resources/products.json";
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
        return products;
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
    public ArrayList<Product> getProductsByIds(ArrayList<String> id){
        ArrayList<Product> products = getAllProducts();
        ArrayList<Product> filteredProducts = new ArrayList<Product>();
        for(int i = 0; id.size() > i; i++ ) {
            for (int j = 0; products.size() > j; j++) {
                if (id.get(i).equals(products.get(j).getProduct_id())) {
                    filteredProducts.add(products.get(j));

                }
            }
        }
        return filteredProducts;
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
    public ArrayList<Product> searchByName(String name){
        ArrayList<Product> products = new ArrayList<Product>();
        ArrayList<Product> newProduct = new ArrayList<Product>();
        String nName = name.toLowerCase(Locale.ROOT);
        try{
            FileReader fr = new FileReader(path);
            Type type = new TypeToken<ArrayList<Product>>(){}.getType();
            products = gson.fromJson(fr, type);
            for(int i = 0; products.size() > i; i++ ){
                String[] parts = products.get(i).getProduct_name().split(" ");
                if(name.equals(parts[0].toLowerCase(Locale.ROOT))){
                    newProduct.add(products.get(i));
                }
                if(name.equals(parts[1].toLowerCase(Locale.ROOT))){
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
