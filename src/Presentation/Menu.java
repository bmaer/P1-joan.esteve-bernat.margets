package Presentation;

public class Menu {
    private static final String mainMenu = "\n\t1) User Profile\n\t2) Find products by name\n\t3) Find products by provider\n\t4) Shopping cart\n\n\t0) Exit\n";
    private static final String authentificationMenu = "\n\t1) Login\n\t2) Sign up\n\t0) Exit\n";
    void showAuthentificationMenu(){
        System.out.println(authentificationMenu);
    }
    void showMainMenu(){
        System.out.println(mainMenu);
    }
}
