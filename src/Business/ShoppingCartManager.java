package Business;

import Persistance.ShoppingCartsJSONDAO;

public class ShoppingCartManager {
    ShoppingCartsJSONDAO cartJson;
    public ShoppingCartManager(ShoppingCartsJSONDAO cartJson) {
        this.cartJson = cartJson;
    }
    public ShoppingCart getShoppingCartByClientId(int clientId){
        return cartJson.getShoppingCartByClientId(clientId);
    }
    public void writeNewShoppingCart(ShoppingCart cart){
        cartJson.writeNewShoppingCart(cart);
    }
    public Boolean deleteShoppingCartByClientId(int clientId){
        return cartJson.deleteShoppingCartByClientId(clientId);
    }
    public void updateShoppingCart(int clientId, Product product, Provider provider){
        cartJson.updateShoppingCartByClientId(clientId, product, provider);
    }
    public boolean checkCartExists(int clientId){
        ShoppingCart cart = getShoppingCartByClientId(clientId);
        if(cart == null){
            return false;
        }
        else {
            return true;
        }
    }
}
