package Business;

import Persistance.ShoppingCartsJSONDAO;

/**
 * Clase que gestiona las operaciones de carritos de compras de los clientes.
 */
public class ShoppingCartManager {
    ShoppingCartsJSONDAO cartJson;

    /**
     * Constructor del gestor de carritos de compra.
     * @param cartJson DAO de acceso a datos de carritos de compra.
     */
    public ShoppingCartManager(ShoppingCartsJSONDAO cartJson) {
        this.cartJson = cartJson;
    }

    /**
     * Obtiene el carrito de compra de un cliente específico.
     * @param clientId ID del cliente.
     * @return Carrito de compra correspondiente, o null si no existe.
     */
    public ShoppingCart getShoppingCartByClientId(int clientId){
        return cartJson.getShoppingCartByClientId(clientId);
    }

    /**
     * Crea un nuevo carrito de compra o lo guarda en el sistema.
     * @param cart Carrito de compra a guardar.
     */
    public void writeNewShoppingCart(ShoppingCart cart){
        cartJson.writeNewShoppingCart(cart);
    }


    /**
     * Elimina el carrito de compras de un cliente específico.
     * @param clientId ID del cliente cuyo carrito se desea eliminar.
     * @return true si se eliminó correctamente, false en caso contrario.
     */
    public Boolean deleteShoppingCartByClientId(int clientId){
        return cartJson.deleteShoppingCartByClientId(clientId);
    }

    /**
     * Actualiza el carrito de compras de un cliente agregando un nuevo producto con su proveedor.
     * @param clientId ID del cliente.
     * @param product Producto a agregar al carrito.
     * @param provider Proveedor del producto.
     */
    public void updateShoppingCart(int clientId, Product product, Provider provider){
        cartJson.updateShoppingCartByClientId(clientId, product, provider);
    }

    /**
     * Verifica si existe un carrito de compras para un cliente específico.
     * @param clientId ID del cliente.
     * @return true si el carrito existe, false si no existe.
     */
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
