package Business;

import Persistance.ProductsDAO;

import java.util.ArrayList;

/**
 * Clase que gestiona las operaciones relacionadas con los productos.
 */
public class ProductManager {
    ProductsDAO productsDAO;
    public ProductManager(ProductsDAO productsDAO) {
        this.productsDAO = productsDAO;
    }

    /**
     * Obtiene todos los productos registrados.
     * @return Lista de productos.
     */
    public ArrayList<Product> getAllProducts() {
        return productsDAO.getAllProducts();
    }
    /**
     * Obtiene un producto por su ID.
     * @param id ID del producto.
     * @return Producto correspondiente, o null si no se encuentra.
     */
    public Product getProductById(String id) {
        return productsDAO.getProductById(id);
    }

    /**
     * Busca productos por nombre de marca.
     * @param category Nombre de la marca.
     * @return Lista de productos que coinciden con la marca, o null si ocurre un error.
     */
    public ArrayList<Product> searchByBrandName(String category) {
        return productsDAO.searchByBrandName(category);
    }

    /**
     * Comprueba si el archivo de productos existe.
     * @return true si el archivo existe, false en caso contrario.
     */
    public boolean checkFile() {
        return productsDAO.check();
    }

    /**
     * Busca productos por su nombre.
     * @param name Nombre del producto.
     * @return Lista de productos que coinciden con el nombre, o null si ocurre un error.
     */
    public ArrayList<Product> searchByName(String name) {
        return productsDAO.searchByName(name);
    }

    /**
     * Obtiene una lista de productos dado un conjunto de IDs.
     * @param productIds Lista de IDs de productos.
     * @return Lista de productos correspondientes.
     */
    public ArrayList<Product> getProductsByIds(ArrayList<String> productIds){
        return productsDAO.getProductsByIds(productIds);
    }


}
