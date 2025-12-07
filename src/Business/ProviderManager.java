package Business;


import Persistance.ProvidersDAO;

import java.util.ArrayList;

/**
 * Clase que gestiona las operaciones relacionadas con los proveedores.
 */
public class ProviderManager {

    ProvidersDAO providersDAO;
    public ProviderManager(ProvidersDAO providersDAO) {
        this.providersDAO = providersDAO;
    }

    /**
     * Obtiene todos los proveedores registrados.
     * @return Lista de proveedores.
     */
    public ArrayList<Provider> getAllProviders(){
        return providersDAO.getAllProviders();
    }

    /**
     * Obtiene un proveedor por su ID.
     * @param id ID del proveedor.
     * @return Proveedor correspondiente, o null si no se encuentra.
     */
    public Provider getProvidersById(int id){
        return providersDAO.getProviderById(id);
    }

    /**
     * Obtiene todos los productos de un proveedor específico.
     * @param providerId ID del proveedor.
     * @return Lista de productos del proveedor, o null si ocurre un error.
     */
    public ArrayList<ProviderProduct> getProductsForProvider(int providerId){
        return providersDAO.getProductsForProvider(providerId);
    }


    /**
     * Comprueba si el archivo de proveedores existe.
     * @return true si el archivo existe, false en caso contrario.
     */
    public boolean checkFile() {
        return providersDAO.check();
    }


    /**
     * Obtiene todos los proveedores que venden un producto específico.
     * @param productId ID del producto.
     * @return Lista de proveedores que venden el producto.
     */
    public ArrayList<Provider> getProvidersByProductId(String productId){
        ArrayList<Provider> providers = providersDAO.getAllProviders();
        int size = providers.size();
        ArrayList<Provider> filteredProviders = new ArrayList<Provider>();
        for (int j = 0; j < size; j++) {
            for(int i = 0; i<providers.get(j).getProducts_for_sale().size(); i++) {
                if (productId.equals(providers.get(j).getProducts_for_sale().get(i).getProduct_id())) {
                    filteredProviders.add(providers.get(j));
                }
            }
        }

        return filteredProviders;
    }

    /**
     * Obtiene los productos de un proveedor dado su ID.
     * @param providerId ID del proveedor.
     * @return Lista de productos del proveedor, o null si no se encuentra.
     */
    public ArrayList<ProviderProduct> getProductsByProviderId(int providerId) {
        ArrayList<Provider> providers = getAllProviders();
        if (providers == null) return null;

        for (Provider p : providers) {
            if (p.getProvider_id() == providerId) {
                return p.getProducts_for_sale(); // Devuelve los productos del proveedor
            }
        }
        return null;
    }

}
