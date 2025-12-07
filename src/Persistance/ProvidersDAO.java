package Persistance;
import java.util.ArrayList;
import Business.Provider;
import Business.ProviderProduct;

/**
 * Interfaz que define las operaciones de acceso a datos para los proveedores.
 */
public interface ProvidersDAO {

    /**
     * Obtiene todos los proveedores registrados en el archivo JSON.
     * @return Lista de proveedores, o null si ocurre un error al leer el archivo.
     */
    public ArrayList<Provider> getAllProviders();

    /**
     * Obtiene un proveedor específico por su ID.
     * @param id ID del proveedor a buscar.
     * @return Proveedor con el ID dado, o null si no se encuentra o ocurre un error.
     */
    public Provider getProviderById(int id);

    /**
     * Obtiene todos los productos que ofrece un proveedor específico.
     * @param providerId ID del proveedor.
     * @return Lista de productos del proveedor, o null si ocurre un error.
     */
    public ArrayList<ProviderProduct> getProductsForProvider(int providerId);

    /**
     * Verifica si el archivo JSON de proveedores existe.
     * @return true si el archivo existe, false en caso contrario.
     */
    public Boolean check();

}
