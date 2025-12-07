package Persistance;

import Business.Product;
import Business.Provider;
import Business.ProviderProduct;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Implementación de ProvidersDAO que gestiona los proveedores usando un archivo JSON.
 */

public class ProvidersJSONDAO implements ProvidersDAO {
    private static String path = "Resources/providers.json";
    private Gson gson = new Gson();

    /**
     * Obtiene todos los proveedores registrados en el archivo JSON.
     * @return Lista de proveedores, o null si ocurre un error al leer el archivo.
     */

    @Override
    public ArrayList<Provider> getAllProviders() {
        ArrayList<Provider> providers = new ArrayList<Provider>();
        try{
            FileReader fr = new FileReader(path);
            Type type = new TypeToken<ArrayList<Provider>>(){}.getType();
            providers = gson.fromJson(fr, type);
        }
        catch (Exception e){
            return null;
        }
        return providers;
    }



    /**
     * Obtiene un proveedor específico por su ID.
     * @param id ID del proveedor a buscar.
     * @return Proveedor con el ID dado, o null si no se encuentra o ocurre un error.
     */

    @Override
    public Provider getProviderById(int id){
        ArrayList<Provider> providers = new ArrayList<Provider>();
        Provider provider = null;
        try{
            FileReader fr = new FileReader(path);
            Type type = new TypeToken<ArrayList<Provider>>(){}.getType();
            providers = gson.fromJson(fr, type);
            for(int i = 0; providers.size() > i; i++ ){
                if(id == providers.get(i).getProvider_id()){
                    provider = providers.get(i);

                }
            }
        }
        catch (Exception e){
            return null;
        }
        return provider;
    }


    /**
     * Obtiene todos los productos que ofrece un proveedor específico.
     * @param providerId ID del proveedor.
     * @return Lista de productos del proveedor, o null si ocurre un error.
     */

    @Override
    public ArrayList<ProviderProduct> getProductsForProvider(int providerId){
        ArrayList<Provider> providers = new ArrayList<Provider>();
        ArrayList<ProviderProduct> providerProducts = new ArrayList<ProviderProduct>();
        try{
            FileReader fr = new FileReader(path);
            Type type = new TypeToken<ArrayList<Provider>>(){}.getType();
            providers = gson.fromJson(fr, type);
            for(int i = 0; providers.size() > i; i++ ){
                if(providerId == providers.get(i).getProvider_id()){
                    providerProducts.addAll(providers.get(i).getProducts_for_sale());
                }
            }
        }
        catch (Exception e){
            return null;
        }
        return providerProducts;
    }

    /**
     * Verifica si el archivo JSON de proveedores existe.
     * @return true si el archivo existe, false en caso contrario.
     */
    @Override
    public Boolean check(){
        File file = new File(path);
        return file.exists();
    }

}
