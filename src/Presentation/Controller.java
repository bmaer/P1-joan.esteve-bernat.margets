package Presentation;

import Business.Client;
import Business.ProductManager;

public class Controller {
    UserInterface ui;
    ProductManager class1M;

    public Controller() {
    }

    public Controller(UserInterface ui, ProductManager class1M) {
        this.ui = ui;
        this.class1M = class1M;
    }

    public void run() {
        ui.showStartUp();
        if (class1M.checkFile()) {
        } else {
            //ui.showError();
            ui.closeUp();
        }
    }

    public void handleLogin() {
    }

    public void runUserMenu(Client client) {
    }

    public void handleRegister() {
    }
}
