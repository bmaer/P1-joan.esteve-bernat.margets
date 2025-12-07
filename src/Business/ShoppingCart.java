package Business;

import java.util.ArrayList;


/**
 * Clase que representa un carrito de compras de un cliente, con sus productos y proveedores asociados.
 */
public class ShoppingCart {
    private int clientId;
    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<Provider> providers = new ArrayList<Provider>();

    /**
     * Constructor vacío de la clase ShoppingCart.
     * Sirve para inicializar ArrayList.
     */
    public ShoppingCart() {
    }

    /**
     * Obtiene el ID del cliente dueño del carrito de compras.
     * @return ID del cliente.
     */
    public int getClientId() {
        return clientId;
    }

    /**
     * Obtiene la lista de productos contenidos en el carrito de compras.
     * @return Lista de productos.
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * Obtiene la lista de proveedores asociados a los productos del carrito de compras.
     * @return Lista de proveedores.
     */
    public ArrayList<Provider> getProviders() {
        return providers;
    }

    /**
     * Constructor que crea un carrito de compras para un cliente con un producto y su proveedor.
     * @param clientId ID del cliente dueño del carrito.
     * @param products Producto a agregar al carrito.
     * @param providers Proveedor del producto.
     */
    public ShoppingCart(int clientId, Product products, Provider providers) {
        this.clientId = clientId;
        this.products.add(products);
        this.providers.add(providers);
    }
}
