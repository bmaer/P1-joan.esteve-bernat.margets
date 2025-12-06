package Presentation;

import Business.Product;
import Business.Provider;

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
    public int requestInt(int option) {
        if (option == 1) {
            System.out.print("Choose an option: ");
        }
        else if (option == 2) {
            System.out.print("Choose a provider: ");
        }
        else if (option == 3) {
            System.out.print("Enter how many phone numbers you have: ");
        }
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
    public void showProduct(ArrayList<Provider> providers, Product product){
        System.out.println("\nProduct id: " + product.getProduct_id());
        System.out.println("Name: " + product.getProduct_name());
        System.out.println("Brand: " + product.getBrand());
        System.out.println("Model: " + product.getModel());
        System.out.println("Providers: ");
        for (int i = 0; i < providers.size(); i++) {
            System.out.println("\t"+i+") "+providers.get(i).getCompany_name());
            System.out.println("\t\t- Sale price: "+ providers.get(i).getProductById(product.getProduct_id()).getSelling_price() + "€,");
            System.out.println("\t\t- Available stock: " + providers.get(i).getProductById(product.getProduct_id()).getUnits_in_stock());
        }
        System.out.println("\n");
    }

    public void closeUp(){
        System.out.println("Closing...");
    }

    public void showUserData(int clientId, String userName, ArrayList<String> phoneNumbers){
        System.out.println("--| User profile |--\n");
        System.out.println("Client ID: " + clientId);
        System.out.println("Full Name: " + userName);
        System.out.println("Phone Numbers:");
        for (String phoneNumber : phoneNumbers) {
            System.out.println("\t" + phoneNumber);
        }
    }
    public void showUserHistory(ArrayList<String> productName, ArrayList<String> brandName, ArrayList<String> modelName, ArrayList<String> time, ArrayList<String> price){
        System.out.println("\nShopping History:");
        for(int i = 0; i < productName.size();i++){
            System.out.println("\t" + productName.get(i) + " - " + brandName.get(i)
                    + " (" + modelName.get(i) + ") - € " + price.get(i) + " - "
                    + time.get(i));
        }

    }


}
