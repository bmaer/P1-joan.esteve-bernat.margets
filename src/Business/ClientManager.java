package Business;

import Persistance.ClientsDAO;

import java.util.ArrayList;

/**
 * Clase que gestiona las operaciones relacionadas con los clientes.
 */
public class ClientManager {
    ClientsDAO clientsDAO;

    /**
     * Constructor del manager con inyección de dependencias.
     * @param clientsDAO DAO de clientes.
     */
    public ClientManager(ClientsDAO clientsDAO) {
        this.clientsDAO = clientsDAO;
    }

    /**
     * Agrega un nuevo cliente al sistema.
     * @param newClient Cliente a agregar.
     */
    public void addClient(Client newClient) {
        clientsDAO.addClient(newClient);
    }

    /**
     * Verifica si un cliente existe dado su nombre y ID.
     * @param name Nombre completo del cliente.
     * @param id ID del cliente.
     * @return true si el cliente existe, false en caso contrario.
     */
    public boolean checkClient(String name, int id) {
        return clientsDAO.checkClient(name, id);
    }

    /**
     * Obtiene un nuevo ID para un cliente.
     * @return Nuevo ID basado en la cantidad de clientes existentes.
     */
    public int getNewClientId() {
        return clientsDAO.listAllClients().size() + 1;
    }

    /**
     * Obtiene un cliente por su nombre completo.
     * @param name Nombre del cliente.
     * @return Cliente correspondiente, o null si no existe.
     */
    public Client getClientByName(String name) {
        return clientsDAO.getClientByName(name);
    }

    /**
     * Convierte la lista de objetos PhoneNumber de un cliente a una lista de cadenas formateadas.
     * Formato: "(prefijo) número".
     * @param client Cliente cuyos números de teléfono se van a convertir.
     * @return Lista de números de teléfono formateados como strings.
     */
    public ArrayList<String> convertPhoneNumbersToStrings(Client client) {
        ArrayList<String> formatedNumbers = new ArrayList<String>();
        for (int i = 0; i < client.getPhone_numbers().size(); i++ ){
            formatedNumbers.add(i, "(" + client.getPhone_numbers().get(i).getCountry_prefix() + ") " + client.getPhone_numbers().get(i).getNumber());
        }
        return formatedNumbers;
    }


}
