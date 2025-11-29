package Persistance;
import java.util.ArrayList;
import Business.Provider;
import Business.ProviderProduct;

public interface ProvidersDAO {

    public ArrayList<Provider> getAllProviders();

    public Provider getProviderById(int id);

    public ArrayList<ProviderProduct> getProductsForProvider(int providerId);

    public Boolean check();

}
