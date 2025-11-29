package Business;

import java.util.ArrayList;


//Seria un arxiu json si no el podem tenir en ram.
public class ShoppingCart {
    private int clientId;
    private ArrayList<String> nameProducts;
    private ArrayList<double> prices;
    private ArrayList<String> idProducts;
    private ArrayList<String> nameProviders;
    private int quantity;
    public ShoppingCart() {
    }
}
