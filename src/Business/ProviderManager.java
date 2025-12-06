package Business;


import Persistance.ProvidersDAO;

import java.util.ArrayList;


public class ProviderManager {

    ProvidersDAO providersDAO;
    public ProviderManager(ProvidersDAO providersDAO) {
        this.providersDAO = providersDAO;
    }

    public ArrayList<Provider> getAllProviders(){
        return providersDAO.getAllProviders();
    }

    public Provider getProvidersById(int id){
        return providersDAO.getProviderById(id);
    }

    public ArrayList<ProviderProduct> getProductsForProvider(int providerId){
        return providersDAO.getProductsForProvider(providerId);
    }
    public boolean checkFile() {
        return providersDAO.check();
    }

    public ArrayList<Provider> getProvidersByProductId(String productId){
        ArrayList<Provider> providers = providersDAO.getAllProviders();
        int size = providers.size();
        for (int j = 0; j < size; j++) {
            for(int i = 0; i<providers.get(j).getProducts_for_sale().size(); i++) {
                if (productId.equals(providers.get(j).getProducts_for_sale().get(i).getProduct_id())) {

                }
                else{
                    providers.remove(providers.get(j));
                }
            }
        }

        return providers;
    }


}
