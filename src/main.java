import Business.Class1Manager;
import Persistance.Class1DAO;
import Persistance.Class1JSON;
import Presentation.Controller;
import Presentation.UserInterface;

public class main {
    public static void main(String[] args) {
        //Class1DAO dao = new Class1JSON();
        //UserInterface ui = new UserInterface();
        //Class1Manager manager = new Class1Manager(dao);
        //Controller controller = new Controller(ui, manager);
        //controller.run();
        UserInterface ui = new UserInterface();
        ui.startUp();
    }
}
