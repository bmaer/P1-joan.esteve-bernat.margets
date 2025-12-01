package Business;

import Persistance.ClientsDAO;

import java.util.ArrayList;

public class ClientManager {
    ClientsDAO clientsDAO;

    public ClientManager(ClientsDAO clientsDAO) {
        this.clientsDAO = clientsDAO;
    }

    public ArrayList<Client> listAllClients() {
        return clientsDAO.listAllClients();
    }

    public Client getClientById(int id) {
        return clientsDAO.getClientById(id);
    }

    public void addClient(Client newClient) {
        clientsDAO.addClient(newClient);
    }

    public boolean checkClientName(String name) {
        return clientsDAO.checkClientName(name);
    }
    public int getNewClientId() {
        return clientsDAO.listAllClients().size() + 1;
    }

}
