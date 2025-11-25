package Presentation;

import Business.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Scanner sc = new Scanner(System.in);
    Menu menu = new Menu();
    public UserInterface() {
    }
    public String requestString(String message) {
        System.out.print(message);
        return sc.nextLine();
    }
    public int requestInt(String message) {
        System.out.print(message);
        return sc.nextInt();
    }
    public void showList(ArrayList<String> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.println("\t" + i + ") " + items.get(i));
        }
    }
    public void showMessage(String message) {
        System.out.println(message);
    }
    public void showExitMessage(){
        System.out.println("Shutting down... ");
    }
    public void showFileError(String message){
        System.out.println("Error: The" + message + " file can't be accessed.\nShutting down...");
    }
    public void showStartUp(){
        System.out.println(
                " _  _         _       ___           ___          _        _\n" +
                "| \\| |_  _ __| |___  | __|  _ ___  | _ \\_ _ ___ (_)___ __| |_\n" +
                "| .` | || / _` / -_) | _| || / -_) |  _/ '_/ _ \\| / -_) _|  _|\n" +
                "|_|\\_|\\_,_\\__,_\\___| |___\\_, \\___| |_| |_| \\___// \\___\\__|\\__|\n" +
                "                         |__/                 |__/");
        System.out.println("\nWelcome to Nude Eye Project.\n“by glass wearers for glass wearers”\n");
    }
    public void showLogout() {
        System.out.println("We hope to see you again!");
    }
    public void showVerify(){
        System.out.println("Verifying local files...");
    }
    public void showProduct(ArrayList<> providers, Product product){

    }

    public void closeUp(){
        System.out.println("Closing...");
    }



}
