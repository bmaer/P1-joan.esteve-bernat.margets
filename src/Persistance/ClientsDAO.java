package Persistance;

import Business.Client;

import java.util.ArrayList;

/**
 * Interfaz que define las operaciones de acceso a datos para los clientes.
 */
public interface ClientsDAO {

    /**
     * Agrega un nuevo cliente al archivo JSON.
     * @param newClient Cliente a agregar.
     */
    public void addClient(Client newClient);

    /**
     * Obtiene todos los clientes registrados en el archivo JSON.
     * @return Lista de clientes, o null si ocurre un error al leer el archivo.
     */
    public ArrayList<Client> listAllClients();

    /**
     * Obtiene un cliente específico por su ID.
     * @param id ID del cliente a buscar.
     * @return Cliente con el ID dado, o null si no se encuentra o ocurre un error.
     */
    public Client getClientById(int id);

    /**
     * Verifica si existe un cliente con un nombre y ID específicos.
     * @param name Nombre completo del cliente.
     * @param id ID del cliente.
     * @return true si el cliente existe, false en caso contrario.
     */
    public boolean checkClient(String name, int id);

    /**
     * Obtiene un cliente específico por su nombre completo.
     * @param name Nombre completo del cliente a buscar.
     * @return Cliente con el nombre dado, o null si no se encuentra o ocurre un error.
     */
    public Client getClientByName(String name);
}
