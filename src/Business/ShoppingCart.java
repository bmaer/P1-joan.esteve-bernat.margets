package Business;

import java.util.ArrayList;


//Seria un arxiu json si no el podem tenir en ram.
public class ShoppingCart {
    private int clientId;
    private ArrayList<Product> products;
    private ArrayList<Provider> providers;
    public ShoppingCart() {
    }

    public int getClientId() {
        return clientId;
    }
    public ArrayList<Product> getProducts() {
        return products;
    }
    public ArrayList<Provider> getProviders() {
        return providers;
    }
    public ShoppingCart(int clientId, Product products, Provider providers) {
        this.clientId = clientId;
        this.products.add(products);
        this.providers.add(providers);
    }
}
