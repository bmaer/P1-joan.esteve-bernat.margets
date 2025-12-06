package Presentation;

import Business.*;

import java.util.ArrayList;

public class Controller {
    UserInterface ui;
    ProductManager productsM;
    ClientManager clientsM;
    ProviderManager providerM;
    SaleManager saleM;
    ShoppingCartManager cartM;

    public Controller() {
    }

    public Controller(UserInterface ui, ProductManager productsM, ProviderManager providerM, ClientManager clientM, SaleManager saleM, ShoppingCartManager cartM) {
        this.ui = ui;
        this.productsM = productsM;
        this.providerM = providerM;
        this.clientsM = clientM;
        this.saleM = saleM;
        this.cartM = cartM;
    }

    public void run() {
        ui.showStartUp();
        ui.showVerify();
        boolean continuar = true;
        if (productsM.checkFile()) {
            if (providerM.checkFile()) {
                ui.showMessage("Files OK.\nStarting program...");
            }
            else{
                ui.showFileError("providers.json");
                continuar = false;
            }
        } else {
            ui.showFileError("products.json");
            continuar = false;
        }
        boolean mainMenu = true;
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
        runUserMenu(clientName);
    }

    private String handleLogin() {
        String name = ui.requestString("Enter full name: ");
        if(clientsM.checkClientName(name)){
            ui.showMessage("Verification complete.");
        }
        else{
            name = null;
            ui.showMessage("Client name not found\nTry again.");
        }
        return name;
    }

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
                    for(int i=0; i< saleM.getSalesByClientId(clientsM.getClientByName(clientName).getClient_id()).size(); i++){
                           ids.add(saleM.getSalesByClientId(clientsM.getClientByName(clientName).getClient_id()).get(i).getProduct_id());
                           times.add(saleM.convertSaleTimeStamp(saleM.getSalesByClientId(clientsM.getClientByName(clientName).getClient_id()).get(i)));
                           prices.add(Float.toString(saleM.getSalesByClientId(clientsM.getClientByName(clientName).getClient_id()).get(i).getPrice_paid()));
                    }
                    ArrayList<String> productNames = new ArrayList<String>();
                    ArrayList<String> brandNames = new ArrayList<String>();
                    ArrayList<String> modelNames = new ArrayList<String>();
                    for(int i =0; productsM.getProductsByIds(ids).size() >i; i++){
                        productNames.add(productsM.getProductsByIds(ids).get(i).getProduct_name());
                        brandNames.add(productsM.getProductsByIds(ids).get(i).getBrand());
                        modelNames.add(productsM.getProductsByIds(ids).get(i).getModel());
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
                        ArrayList<Provider> providers = providerM.getProvidersByProductId(results.get(option2).getProduct_id());
                        ui.showProduct(providers, results.get(option2));
                        String response = ui.requestString("Do you want to add this product to the shopping cart? ");
                        if(response.equals("Yes")) {
                            int selectedP = 0;
                            selectedP = ui.requestInt(2);
                            if (cartM.checkCartExists(clientsM.getClientByName(clientName).getClient_id())) {
                                cartM.updateShoppingCart(clientsM.getClientByName(clientName).getClient_id(),results.get(option2),providers.get(selectedP));
                            }
                            else{
                                ShoppingCart cart = new ShoppingCart(clientsM.getClientByName(clientName).getClient_id(), results.get(option2),providers.get(selectedP));
                                cartM.writeNewShoppingCart(cart);
                                ui.showMessage("\nProduct added to shopping cart");
                            }
                        }
                    }


                    break;

                case 3://Opcion de buscar productos por proveedor
                    ui.showMessage(" Find products by provider");
                    


                    break;

                case 4: //Opcion del carrito
                    ui.showMessage(" Shopping cart ");
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
        for(int i = 0; i < ui.requestInt(3); i++){
            PhoneNumber pn = new PhoneNumber();
            pn.setCountry_prefix(ui.requestString("Enter country prefix" + (i+1) + ": "));
            pn.setNumber(ui.requestString("Enter number" + (i+1) + ": "));
            phoneNumbers.add(pn);
        }
        newClient.setPhone_numbers(phoneNumbers);
        clientsM.addClient(newClient);
        return name;
    }
}
