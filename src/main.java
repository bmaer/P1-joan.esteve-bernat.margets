import Business.*;
import Persistance.*;
import Presentation.Controller;
import Presentation.UserInterface;
import Business.Provider;

import java.util.ArrayList;

/**
 * Clase principal que inicializa los componentes del sistema y arranca el programa.
 */
public class main {

    /**
     * Método principal que se ejecuta al iniciar la aplicación.
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        ClientsDAO c = new ClientsJSONDAO();
        ProductsDAO p = new ProductsJSONDAO();
        ProvidersDAO p1 = new ProvidersJSONDAO();
        SalesDAO s = new SalesCSVDAO();
        ShoppingCartsJSONDAO sc = new ShoppingCartsJSONDAO();

        ClientManager cM = new ClientManager(c);
        ProductManager pM= new ProductManager(p);
        ProviderManager pM1 = new ProviderManager(p1);
        SaleManager sM = new SaleManager(s);
        ShoppingCartManager scM = new ShoppingCartManager(sc);
        UserInterface ui = new UserInterface();
        Controller con = new Controller(ui, pM,pM1,cM,sM,scM);
        con.run();

    }
}
