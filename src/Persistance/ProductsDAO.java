package Persistance;

import Business.Product;

import java.util.ArrayList;

/**
 * Interfaz que define las operaciones de acceso a datos para los productos.
 */
public interface ProductsDAO {

    /**
     * Obtiene todos los productos registrados en el archivo JSON.
     * @return Lista de productos, o null si ocurre un error al leer el archivo.
     */
    public ArrayList<Product> getAllProducts();

    /**
     * Obtiene un producto específico por su ID.
     * @param id ID del producto a buscar.
     * @return product con el ID dado, o null si no se encuentra o ocurre un error.
     */
    public Product getProductById(String id);

    /**
     * Busca productos cuyo nombre de marca coincida exactamente con el dado.
     * @param brand Nombre de la marca a buscar.
     * @return Lista de productos que coinciden con la marca, o null si ocurre un error.
     */
    public ArrayList<Product> searchByBrandName(String brand);

    /**
     * Busca productos cuyo nombre contenga la palabra indicada.
     * La búsqueda se realiza comparando la primera y segunda palabra del nombre del producto.
     * @param name Palabra a buscar en el nombre del producto.
     * @return Lista de productos que coinciden con la búsqueda, o null si ocurre un error.
     */
    public ArrayList<Product> searchByName(String name);

    /**
     * Verifica si el archivo JSON de productos existe.
     * @return true si el archivo existe, false en caso contrario.
     */
    public Boolean check();

    /**
     * Obtiene una lista de productos a partir de una lista de IDs.
     * @param id Lista de IDs de productos a buscar.
     * @return Lista de productos que coinciden con los IDs proporcionados.
     */
    public ArrayList<Product> getProductsByIds(ArrayList<String> id);

}
