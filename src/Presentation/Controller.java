package Presentation;

import Business.Class1Manager;

public class Controller {
    UserInterface ui;
    Class1Manager class1M;
    public Controller(UserInterface ui, Class1Manager class1M) {
        this.ui = ui;
        this.class1M = class1M;
    }
    public void run(){
        ui.startUp();
        if(class1M.checkFile() == true){


        }
        else{
            ui.showError();
            ui.closeUp();
        }

    }
}
