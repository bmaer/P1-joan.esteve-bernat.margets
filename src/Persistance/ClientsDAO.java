package Persistance;

import Business.Client;

import java.util.ArrayList;

public interface ClientsDAO {

    public void addClient(Client newClient);
    public ArrayList<Client> listAllClients();
    public Client getClientById(int id);
    public boolean checkClient(String name, int id);
    public Client getClientByName(String name);
}
