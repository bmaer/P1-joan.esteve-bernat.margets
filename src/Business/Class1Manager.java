package Business;

import Persistance.Class1DAO;

import java.util.ArrayList;


public class Class1Manager {
    Class1DAO class1DAO;
    public Class1Manager(Class1DAO class1DAO) {
        this.class1DAO = class1DAO;
    }
    public getAllClass1(){
        ArrayList classes1 = this.class1DAO.readAllClass1();



        return classes1;
    }

}
