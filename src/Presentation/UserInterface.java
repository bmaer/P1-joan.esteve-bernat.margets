package Presentation;

import Business.Product;
import Business.Provider;

import Business.ProviderProduct;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Clase para poder mostrar los diferentes mensajes i recibir los inputs del usuario
 */
public class UserInterface {
    Scanner sc = new Scanner(System.in);
    Menu menu = new Menu();

    public UserInterface() {
    }
    public String requestString(String message) {
        System.out.print(message);

        return sc.nextLine();
    }

    /**
     * El método muestra un mensaje introducido para pedir un número.
     * @param option Número que indica el tipo de mensaje para pedir el int.
     * @return el input del usuario
     */
    public int requestInt(int option) {
        if (option == 1) {
            System.out.print("Choose an option: ");
        }
        else if (option == 2) {
            System.out.print("Choose a provider: ");
        }
        else if (option == 3) {
            System.out.print("Enter how many phone numbers you have: ");
        } else if (option == 4) {
            System.out.print("Enter your Id: ");
        }
        int input = sc.nextInt();
        sc.nextLine();
        return input;
    }

    /**
     * Muestra un mensaje por consola, usado para cosas muy especificas.
     * @param message Mensaje a mostrar.
     */

    public void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * Muestra un mensaje de error relacionado con un archivo e informa que el programa se cerrará.
     * @param message Nombre o descripción del archivo que no pudo accederse.
     */

    public void showFileError(String message){
        System.out.println("Error: The " + message + " file can't be accessed.\nShutting down...");
    }

    /**
     * Muestra el mensaje de inicio del programa con un banner ASCII.
     */
    public void showStartUp(){
        System.out.println(
                " _  _         _       ___           ___          _        _\n" +
                "| \\| |_  _ __| |___  | __|  _ ___  | _ \\_ _ ___ (_)___ __| |_\n" +
                "| .` | || / _` / -_) | _| || / -_) |  _/ '_/ _ \\| / -_) _|  _|\n" +
                "|_|\\_|\\_,_\\__,_\\___| |___\\_, \\___| |_| |_| \\___// \\___\\__|\\__|\n" +
                "                         |__/                 |__/");
        System.out.println("\nWelcome to Nude Eye Project.\n“by glass wearers for glass wearers”\n");
    }

    /**
     * Muestra un mensaje de cierre de sesión.
     */

    public void showLogout() {
        System.out.println("We hope to see you again!");
    }


    /**
     * Muestra un mensaje indicando que se están verificando los archivos locales.
     */

    public void showVerify(){
        System.out.println("Verifying local files...");
    }

    /**
     * Muestra la información de un producto junto con los detalles de sus proveedores.
     * @param providers Lista de proveedores que ofrecen el producto.
     * @param product Producto cuyos datos se van a mostrar.
     */

    public void showProduct(ArrayList<Provider> providers, Product product){
        System.out.println("\nProduct id: " + product.getProduct_id());
        System.out.println("Name: " + product.getProduct_name());
        System.out.println("Brand: " + product.getBrand());
        System.out.println("Model: " + product.getModel());
        System.out.println("Providers: ");

        for (int i = 0; i < providers.size(); i++) {
            System.out.println("\t"+(i+1)+") "+providers.get(i).getCompany_name());
            System.out.println("\t\t- Sale price: "+ providers.get(i).getProductById(product.getProduct_id()).getSelling_price() + "€,");
            System.out.println("\t\t- Available stock: " + providers.get(i).getProductById(product.getProduct_id()).getUnits_in_stock());
        }
        System.out.println("\n");
    }


    /**
     * Muestra la información de un usuario junto con sus números de teléfono.
     * @param clientId ID del cliente.
     * @param userName Nombre completo del usuario.
     * @param phoneNumbers Lista de números de teléfono asociados al usuario.
     */

    public void showUserData(int clientId, String userName, ArrayList<String> phoneNumbers){
        System.out.println("--| User profile |--\n");
        System.out.println("Client ID: " + clientId);
        System.out.println("Full Name: " + userName);
        System.out.println("Phone Numbers:");
        for (String phoneNumber : phoneNumbers) {
            System.out.println("\t" + phoneNumber);
        }
    }

    /**
     * Muestra el historial de compras de un usuario.
     * @param productName Lista de nombres de productos.
     * @param brandName Lista de marcas de los productos.
     * @param modelName Lista de modelos de los productos.
     * @param time Lista de fechas o tiempos de compra.
     * @param price Lista de precios de los productos.
     */

    public void showUserHistory(ArrayList<String> productName, ArrayList<String> brandName, ArrayList<String> modelName, ArrayList<String> time, ArrayList<String> price){
        System.out.println("\nShopping History:");
        if(productName.isEmpty()){
            System.out.println("\nNo History\n");
        }
        else {
            for (int i = 0; i < productName.size(); i++) {
                System.out.println("\t" + productName.get(i) + " - " + brandName.get(i)
                        + " (" + modelName.get(i) + ") - € " + price.get(i) + " - "
                        + time.get(i));
            }
        }

    }

    /**
     * Muestra los productos en el carrito de compras junto con el precio total.
     * @param ids Lista de IDs de los productos.
     * @param names Lista de nombres de los productos.
     * @param providers Lista de proveedores de los productos.
     * @param prices Lista de precios de los productos.
     */

    public void showCart(ArrayList<String> ids,ArrayList<String> names, ArrayList<String> providers, ArrayList<Float> prices){
        System.out.println("\nShopping cart:");
        float total = 0;
        for(int i = 0; i < ids.size(); i++){
            System.out.println("\t+ " +ids.get(i) +" - "+names.get(i)+"\t("+providers.get(i)+")\t\t"+prices.get(i)+"€");
            total= total + prices.get(i);
        }
        System.out.println("\t\t\t\t\t\t\t\t\tTotal price: " + total);

    }

    /**
     * Muestra la información de un proveedor y sus productos en venta.
     * @param provider Proveedor cuyos datos se mostrarán.
     * @param products Lista de productos que ofrece el proveedor.
     */

    public void showProvider(Provider provider, ArrayList<Product> products) {

        System.out.println("Provider: " + provider.getCompany_name() + ",\n"+
                "CIF: " + provider.getCif() + ",\n"+
                "Contact person: " + provider.getContact_name() + ",\n"+
                "Phone: " + provider.getPhone() + ",\n"+
                "Email: " + provider.getEmail() + ",");
        System.out.println("Provider products:");

        for (int i = 0; i < products.size(); i++) {

            System.out.println("\t"+(i + 1) + ") " + products.get(i).getProduct_id() + " - " + products.get(i).getProduct_name());
            System.out.println("\t\t- Sale price: " + provider.getProducts_for_sale().get(i).getSelling_price() + "€");
            System.out.println("\t\t- Available stock: " + provider.getProducts_for_sale().get(i).getUnits_in_stock());
        }
        System.out.println("\t0) Back");
    }

    /**
     * Muestra una lista numerada de proveedores.
     * @param providers Lista de nombres de proveedores.
     */

    public void listProviders(ArrayList<String> providers) {
        for (int i = 0; i < providers.size(); i++) {
            System.out.println("\t" + (i + 1) + ") " + providers.get(i));
        }
        System.out.println("\n\t0) Back\n");

    }

}
