package Persistance;

import Business.Client;
import Business.Product;
import Business.Provider;
import Business.ShoppingCart;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Clase DAO para manejar los carritos de compra usando un archivo JSON.
 */

public class ShoppingCartsJSONDAO {
    private static String path = "Resources/ShoppingCarts.json";
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();


    public ShoppingCartsJSONDAO() {}

    /**
     * Obtiene el carrito de un cliente por su ID.
     * @param clientId ID del cliente.
     * @return Carrito del cliente, o null si no existe.
     */

    public ShoppingCart getShoppingCartByClientId(int clientId){
        ArrayList<ShoppingCart> carts = new ArrayList<ShoppingCart>();
        ShoppingCart cart = null;
        try {
            File file = new File(path);

            if (!file.isFile()) {
                file.createNewFile();
            }

            FileReader fr = new FileReader(path);
            Type type = new TypeToken<ArrayList<ShoppingCart>>() {
            }.getType();
            carts = gson.fromJson(fr, type);
            if (carts != null){
                for (int i = 0; carts.size() > i; i++) {
                    if (clientId == carts.get(i).getClientId()) {
                        cart = carts.get(i);

                    }
                }
            }
        }
        catch (Exception e){
            return null;
        }
        return cart;
    }

    /**
     * Agrega un nuevo carrito de compra al archivo JSON.
     * @param cart Carrito a agregar.
     */

    public void writeNewShoppingCart(ShoppingCart cart){
        try {
            File file = new File(path);

            if (!file.isFile()) {
                file.createNewFile();
            }
            FileReader reader = new FileReader(path);
            Type type = new TypeToken<ArrayList<ShoppingCart>>() {
            }.getType();
            ArrayList<ShoppingCart> writerArray = gson.fromJson(reader, type);
            if(writerArray == null){
                ArrayList<ShoppingCart> list2 = new ArrayList<ShoppingCart>();
                list2.add(cart);
                writerArray = list2;
            }
            else{
                writerArray.add(cart);
            }
            String json = gson.toJson(writerArray);
            FileWriter fw = new FileWriter(file);
            fw.write(json);
            fw.close();

        } catch (IOException f) {}
    }

    /**
     * Elimina el carrito de un cliente por su ID.
     * @param clientId ID del cliente cuyo carrito se eliminará.
     * @return true si se eliminó el carrito, false si no se encontró o hubo error.
     */

    public Boolean deleteShoppingCartByClientId(int clientId){
        ArrayList<ShoppingCart> carts = new ArrayList<ShoppingCart>();
        try{
            File file = new File(path);

            if (file.isFile()) {
                FileReader fr = new FileReader(path);
                Type type = new TypeToken<ArrayList<ShoppingCart>>(){}.getType();
                carts = gson.fromJson(fr, type);
                for(int i = 0; carts.size() > i; i++ ){
                    if(clientId == carts.get(i).getClientId()){
                        carts.remove(i);

                    }
                }
                String json = gson.toJson(carts);
                FileWriter fw = new FileWriter(file);
                fw.write(json);
                fw.close();
                return true;
            }
        }
        catch (Exception e){
            return false;
        }
        return false;
    }

    /**
     * Actualiza el carrito de un cliente agregando un nuevo producto y proveedor.
     * @param clientId    ID del cliente.
     * @param newProduct  Producto a agregar.
     * @param newProvider Proveedor correspondiente al producto.
     */

    public void updateShoppingCartByClientId(int clientId, Product newProduct, Provider newProvider){
        ShoppingCart cart = getShoppingCartByClientId(clientId);

        cart.getProducts().add(newProduct);
        cart.getProviders().add(newProvider);
        deleteShoppingCartByClientId(clientId);
        writeNewShoppingCart(cart);
    }



}
