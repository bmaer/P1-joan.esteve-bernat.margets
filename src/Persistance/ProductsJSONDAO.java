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

/**
 * Implementación de ProductsDAO que gestiona los productos usando un archivo JSON.
 */

public class ProductsJSONDAO implements ProductsDAO {
    private static final String path = "Resources/products.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();


    public ProductsJSONDAO() {
    }

    /**
     * Obtiene todos los productos registrados en el archivo JSON.
     * @return Lista de productos, o null si ocurre un error al leer el archivo.
     */

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

    /**
     * Obtiene un producto específico por su ID.
     * @param id ID del producto a buscar.
     * @return product con el ID dado, o null si no se encuentra o ocurre un error.
     */
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

    /**
     * Obtiene una lista de productos a partir de una lista de IDs.
     * @param id Lista de IDs de productos a buscar.
     * @return Lista de productos que coinciden con los IDs proporcionados.
     */
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

    /**
     * Busca productos cuyo nombre de marca coincida exactamente con el dado.
     * @param brand Nombre de la marca a buscar.
     * @return Lista de productos que coinciden con la marca, o null si ocurre un error.
     */
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

    /**
     * Busca productos cuyo nombre contenga la palabra indicada.
     * La búsqueda se realiza comparando la primera y segunda palabra del nombre del producto.
     * @param name Palabra a buscar en el nombre del producto.
     * @return Lista de productos que coinciden con la búsqueda, o null si ocurre un error.
     */

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

    /**
     * Verifica si el archivo JSON de productos existe.
     * @return true si el archivo existe, false en caso contrario.
     */

    @Override
    public Boolean check(){
        File file = new File(path);
        return file.exists();
    }



}
