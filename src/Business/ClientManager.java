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

    public boolean checkClient(String name, int id) {
        return clientsDAO.checkClient(name, id);
    }
    public int getNewClientId() {
        return clientsDAO.listAllClients().size() + 1;
    }

    public Client getClientByName(String name) {
        return clientsDAO.getClientByName(name);
    }

    public ArrayList<String> convertPhoneNumbersToStrings(Client client) {
        ArrayList<String> formatedNumbers = new ArrayList<String>();
        for (int i = 0; i < client.getPhone_numbers().size(); i++ ){
            formatedNumbers.add(i, "(" + client.getPhone_numbers().get(i).getCountry_prefix() + ") " + client.getPhone_numbers().get(i).getNumber());
        }
        return formatedNumbers;
    }


}
