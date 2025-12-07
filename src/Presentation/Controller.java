package Presentation;

import Business.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase controlador que coordina la interacción entre la UI y los managers del sistema.
 */

public class Controller {
    UserInterface ui;
    ProductManager productsM;
    ClientManager clientsM;
    ProviderManager providerM;
    SaleManager saleM;
    ShoppingCartManager cartM;

    /**
     * Constructor del controlador que permite recibir instancias externas de la interfaz y los managers
     * Permite pasar instancias ya creadas de la UI y los managers.
     *
     * @param ui Interfaz de usuario.
     * @param productsM Manager de productos.
     * @param providerM Manager de proveedores.
     * @param clientM Manager de clientes.
     * @param saleM Manager de ventas.
     * @param cartM Manager del carrito de compras.
     */

    public Controller(UserInterface ui, ProductManager productsM, ProviderManager providerM, ClientManager clientM, SaleManager saleM, ShoppingCartManager cartM) {
        this.ui = ui;
        this.productsM = productsM;
        this.providerM = providerM;
        this.clientsM = clientM;
        this.saleM = saleM;
        this.cartM = cartM;
    }

    /**
     * Muestra los mensajes de inicio, verifica archivos, maneja autenticación y luego ejecuta el menú de usuario.
     */

    public void run() {
        ui.showStartUp();
        ui.showVerify();
        boolean mainMenu = true;
        boolean continuar = true;
        if (productsM.checkFile()) {
            if (providerM.checkFile()) {
                ui.showMessage("Files OK.\nStarting program...");
            }
            else{
                ui.showFileError("providers.json");
                continuar = false;
                mainMenu = false;
            }
        } else {
            ui.showFileError("products.json");
            continuar = false;
            mainMenu = false;
        }

        String clientName = null;
        while (continuar) {
            ui.menu.showAuthentificationMenu();
            int option = ui.requestInt(1);

            switch (option) {
                case 1:
                    clientName = handleLogin();
                    if (clientName != null) {
                        continuar = false;
                    }
                    break;

                case 2:
                    clientName = handleRegister();
                    continuar = false;
                    break;

                case 0:
                    continuar = false;
                    ui.showLogout();
                    mainMenu = false;
                    break;

            }
        }
        if(mainMenu) {
            runUserMenu(clientName);
        }
    }

    /**
     * Maneja el proceso de inicio de sesión de un cliente.
     * Solicita nombre y ID, y verifica si el cliente existe.
     * @return El nombre del cliente si la verificación fue exitosa, o null si falla.
     */

    private String handleLogin() {
        String name = ui.requestString("Enter full name: ");
        int id = ui.requestInt(4);
        if(clientsM.checkClient(name, id)){
            ui.showMessage("Verification complete.");
        }
        else{
            name = null;
            ui.showMessage("Client name not found\nTry again.");
        }
        return name;
    }

    /**
     * Ejecuta el menú principal de un usuario autenticado.
     * Permite acceder a perfil, búsqueda de productos, proveedores y carrito.
     *
     * @param clientName Nombre completo del cliente autenticado.
     */

    private void runUserMenu(String clientName) {
        boolean continuar = true;
        while(continuar) {
            ui.showMessage("Welcome " + clientName + "!");
            ui.menu.showMainMenu();
            int option = ui.requestInt(1);
            switch (option) {
                case 1://Opcion del User profile

                    ui.showUserData(clientsM.getClientByName(clientName).getClient_id(),clientName,
                            clientsM.convertPhoneNumbersToStrings(clientsM.getClientByName(clientName)));
                    ArrayList<String> ids = new ArrayList<String>();
                    ArrayList<String> times = new ArrayList<String>();
                    ArrayList<String> prices = new ArrayList<String>();
                    ArrayList<Sale> sales = saleM.getSalesByClientId(clientsM.getClientByName(clientName).getClient_id());
                    for(int i=0; i< sales.size(); i++){
                           ids.add(sales.get(i).getProduct_id());
                           times.add(saleM.convertSaleTimeStamp(sales.get(i)));
                           prices.add(Float.toString(sales.get(i).getPrice_paid()));
                    }
                    ArrayList<String> productNames = new ArrayList<String>();
                    ArrayList<String> brandNames = new ArrayList<String>();
                    ArrayList<String> modelNames = new ArrayList<String>();
                    ArrayList<Product> products =productsM.getProductsByIds(ids);
                    for(int i =0; products.size() >i; i++){
                        productNames.add(products.get(i).getProduct_name());
                        brandNames.add(products.get(i).getBrand());
                        modelNames.add(products.get(i).getModel());
                    }
                    ui.showUserHistory(productNames,brandNames,modelNames,times,prices);
                    break;

                case 2://Opcion de buscar productos por nombre
                    String ProductName = ui.requestString("Search criteria:");
                    productsM.searchByName(ProductName);
                    ArrayList<Product> results = productsM.searchByName(ProductName);

                    if (results == null || results.isEmpty()) {
                        ui.showMessage("No products found with: " + ProductName);
                    } else {
                        for (int i = 0; i < results.size(); i++) {
                            Product p = results.get(i);
                            ui.showMessage("\t" + (i + 1) + ") " + p.getProduct_id() + " - " + p.getProduct_name());
                        }
                        ui.showMessage("\n\t0) Back");
                    }

                    int option2 = ui.requestInt(1);
                    if (option2 == 0) {
                        break;
                    }
                    if (option2 < 1 || option2 > results.size()) {
                        ui.showMessage("Invalid option");
                        break;
                    }
                    else{
                        ArrayList<Provider> providers = providerM.getProvidersByProductId(results.get(option2-1).getProduct_id());
                        ui.showProduct(providers, results.get(option2-1));
                        String response = ui.requestString("Do you want to add this product to the shopping cart? ");
                        if(response.equals("yes")) {
                            int selectedP = 0;
                            selectedP = ui.requestInt(2);
                            if (cartM.checkCartExists(clientsM.getClientByName(clientName).getClient_id())) {
                                cartM.updateShoppingCart(clientsM.getClientByName(clientName).getClient_id(),results.get(option2-1),providers.get(selectedP-1));
                            }
                            else{

                                ShoppingCart cart = new ShoppingCart(clientsM.getClientByName(clientName).getClient_id(), results.get(option2-1),providers.get(selectedP-1));
                                cartM.writeNewShoppingCart(cart);
                                ui.showMessage("\nProduct added to shopping cart");
                            }
                        }
                    }


                    break;

                case 3://Opcion de buscar productos por proveedor

                    ui.showMessage(" Find products by provider");
                    ArrayList<Provider> resultsProvider = providerM.getAllProviders();

                    ArrayList<String> companyNames = new ArrayList<String>();
                    for (int i = 0; i < resultsProvider.size(); i++) {
                        companyNames.add(resultsProvider.get(i).getCompany_name());
                    }
                    ui.listProviders(companyNames);

                    int option3 = ui.requestInt(1);
                    if (option3 == 0) {
                        break;
                    }
                    if (option3 < 1 || option3 > resultsProvider.size()) {
                        ui.showMessage("Invalid option");
                        break;
                    }

                    Provider selectedProvider = resultsProvider.get(option3-1);
                    ArrayList<String> productIds = new ArrayList<String>();
                    for(int i = 0; i < selectedProvider.getProducts_for_sale().size(); i++){
                        productIds.add(selectedProvider.getProducts_for_sale().get(i).getProduct_id());
                    }
                    ui.showProvider(selectedProvider, productsM.getProductsByIds(productIds));
                    option2 = ui.requestInt(1);
                    if(option2 != 0) {
                        ArrayList<Provider> providers = providerM.getProvidersByProductId(selectedProvider.getProducts_for_sale().get(option2-1).getProduct_id());

                        ui.showProduct(providers, productsM.getProductById(selectedProvider.getProducts_for_sale().get(option2-1).getProduct_id()));
                        String response = ui.requestString("Do you want to add this product to the shopping cart? ");
                        if (response.equals("Yes")) {
                            int selectedP = 0;
                            selectedP = ui.requestInt(2);
                            if (cartM.checkCartExists(clientsM.getClientByName(clientName).getClient_id())) {
                                cartM.updateShoppingCart(clientsM.getClientByName(clientName).getClient_id(), productsM.getProductById(selectedProvider.getProducts_for_sale().get(option2-1).getProduct_id()), providers.get(selectedP));
                            } else {
                                ShoppingCart cart = new ShoppingCart(clientsM.getClientByName(clientName).getClient_id(), productsM.getProductById(selectedProvider.getProducts_for_sale().get(option2-1).getProduct_id()), providers.get(selectedP));
                                cartM.writeNewShoppingCart(cart);
                                ui.showMessage("\nProduct added to shopping cart");
                            }
                        }
                    }

                    break;

                case 4: //Opcion del carrito
                    ShoppingCart cart = cartM.getShoppingCartByClientId(clientsM.getClientByName(clientName).getClient_id());
                    if(cart == null){
                        ui.showMessage("No shopping cart found");
                    }
                    else{
                        ArrayList<String> productsIds = new ArrayList<String>();
                        ArrayList<String> productsNames = new ArrayList<String>();
                        ArrayList<String> providerNames = new ArrayList<String>();
                        ArrayList<Float> productPrices = new ArrayList<Float>();
                        for(int i = 0; i < cart.getProducts().size(); i++){
                            productsNames.add(cart.getProducts().get(i).getProduct_name());
                            productsIds.add(cart.getProducts().get(i).getProduct_id());
                            providerNames.add(cart.getProviders().get(i).getCompany_name());
                            for(int j = 0; j < cart.getProviders().get(i).getProducts_for_sale().size(); j++){
                                if(cart.getProducts().get(i).getProduct_id().equals(cart.getProviders().get(i).getProducts_for_sale().get(j).getProduct_id())){
                                    productPrices.add(cart.getProviders().get(i).getProducts_for_sale().get(j).getSelling_price());
                                }
                            }
                        }
                        ui.showCart(productsIds,productsNames,providerNames,productPrices);
                        if("yes".equals(ui.requestString("Do you want to proceed with the purchase? "))){

                            cartM.deleteShoppingCartByClientId(clientsM.getClientByName(clientName).getClient_id());
                            ui.showMessage("\nThank you for your purchase!");
                            Sale s = new Sale();
                            for(int i = 0; i < cart.getProducts().size(); i++){
                                s.setClientId(cart.getClientId());
                                s.setPricePaid(cart.getProviders().get(i).getProductById(cart.getProducts().get(i).getProduct_id()).getSelling_price());
                                s.setProductId(cart.getProducts().get(i).getProduct_id());
                                s.setPurchaseDate(java.time.Instant.now().getEpochSecond());
                                saleM.AddSale(s);
                            }
                        }
                    }

                    break;

                case 0:
                    continuar = false;
                    ui.showLogout();
                    break;
            }
        }
    }

    private String handleRegister() {
        Client newClient = new Client();
        String name = ui.requestString("Enter full name: ");
        newClient.setFull_name(name);
        newClient.setClient_id(clientsM.getNewClientId());
        ArrayList<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
        int numberOfPhones = ui.requestInt(3);
        for(int i = 1; i <= numberOfPhones; i++) {
            PhoneNumber pn = new PhoneNumber();
            if (numberOfPhones > 1) {
                pn.setCountry_prefix(ui.requestString("Enter country prefix " + (i) + ": "));
            pn.setNumber(ui.requestString("Enter number " + (i) + ": "));
            phoneNumbers.add(pn);
            }
            else{
                pn.setCountry_prefix(ui.requestString("Enter country prefix: "));
                pn.setNumber(ui.requestString("Enter number: "));
                phoneNumbers.add(pn);
            }

        }
        newClient.setPhone_numbers(phoneNumbers);
        clientsM.addClient(newClient);
        return name;
    }
}
