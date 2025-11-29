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


    public boolean checkFile() {
        return providersDAO.check();
    }


}
