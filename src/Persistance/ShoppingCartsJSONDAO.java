package Persistance;

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

public class ShoppingCartsJSONDAO {
    private static String path = "Resources/providers.json";
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();


    public ShoppingCartsJSONDAO() {}

    public ShoppingCart getShoppingCartByClientId(int clientId){
        ArrayList<ShoppingCart> carts = new ArrayList<ShoppingCart>();
        ShoppingCart cart = null;
        try{
            FileReader fr = new FileReader(path);
            Type type = new TypeToken<ArrayList<ShoppingCart>>(){}.getType();
            carts = gson.fromJson(fr, type);
            for(int i = 0; carts.size() > i; i++ ){
                if(clientId == carts.get(i).getClientId()){
                    cart = carts.get(i);

                }
            }
        }
        catch (Exception e){
            return null;
        }
        return cart;
    }

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
            writerArray.add(cart);


            String json = gson.toJson(writerArray);


            FileWriter fw = new FileWriter(file);
            fw.write(json);
            fw.close();
        } catch (IOException f) {}
    }

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

    public void updateShoppingCartByClientId(int clientId, Product newProduct, Provider newProvider){
        ShoppingCart cart = getShoppingCartByClientId(clientId);

        cart.getProducts().add(newProduct);
        cart.getProviders().add(newProvider);
        deleteShoppingCartByClientId(clientId);
        writeNewShoppingCart(cart);
    }

}
