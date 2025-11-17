package Presentation;

public class UserInterface {
    public UserInterface() {

    }

    public void startUp(){
        System.out.println(
                " _  _         _       ___           ___          _        _\n" +
                "| \\| |_  _ __| |___  | __|  _ ___  | _ \\_ _ ___ (_)___ __| |_\n" +
                "| .` | || / _` / -_) | _| || / -_) |  _/ '_/ _ \\| / -_) _|  _|\n" +
                "|_|\\_|\\_,_\\__,_\\___| |___\\_, \\___| |_| |_| \\___// \\___\\__|\\__|\n" +
                "                         |__/                 |__/");
    }
    public void showError(){
        System.out.println("Error file not found");
    }
    public void closeUp(){
        System.out.println("Closing...");
    }
}
