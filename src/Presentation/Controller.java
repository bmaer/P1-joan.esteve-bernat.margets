package Presentation;

import Business.ProductManager;

public class Controller {
    UserInterface ui;
    ProductManager class1M;
    public Controller(UserInterface ui, ProductManager class1M) {
        this.ui = ui;
        this.class1M = class1M;
    }
    public void run(){
        ui.showStartUp();
        if(class1M.checkFile() == true){


        }
        else{
            ui.showError();
            ui.closeUp();
        }

    }
}
