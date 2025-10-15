package Business;

import Persistance.Class1DAO;

import java.util.ArrayList;


public class Class1Manager {
    Class1DAO class1DAO;
    public Class1Manager(Class1DAO class1DAO) {
        this.class1DAO = class1DAO;
    }
    public ArrayList<Class1> getAllClass1(){
        ArrayList<Class1> classes1 = this.class1DAO.readAllClass1();

        return classes1;
    }
    public boolean checkFile() {
        return true; //To do
    }


}
