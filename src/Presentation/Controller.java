package Presentation;

import Business.*;

import java.util.ArrayList;

public class Controller {
    UserInterface ui;
    ProductManager productsM;
    ClientManager clientsM;
    ProviderManager providerM;
    SaleManager saleM;

    public Controller() {
    }

    public Controller(UserInterface ui, ProductManager productsM, ProviderManager providerM, ClientManager clientM, SaleManager saleM) {
        this.ui = ui;
        this.productsM = productsM;
        this.providerM = providerM;
        this.clientsM = clientM;
        this.saleM = saleM;
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
                    ui.showMessage(" User profile");
                    break;

                case 2://Opcion de buscar productos por nombre
                ui.showMessage("Find products by name ");
                String ProductName = ui.requestString("Search criteria");

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
                    if (option < 1 || option > results.size()) {
                        ui.showMessage("Invalid option");
                        break;
                    }
                    //Esta sin acabar

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
