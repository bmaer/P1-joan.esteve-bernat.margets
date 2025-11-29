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

    public Client getClientById(int client_id) {
        return clientsDAO.getClientById(client_id);
    }

    public void addClient(Client client) {
        clientsDAO.addClient(client);
    }

}
