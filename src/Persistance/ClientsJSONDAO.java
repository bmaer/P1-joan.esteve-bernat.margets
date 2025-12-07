package Persistance;

import Business.Client;
import Business.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;


/**
 * Implementación de ClientsDAO que gestiona los clientes usando un archivo JSON.
 */

public class ClientsJSONDAO implements ClientsDAO {
    private static final String path = "Resources/clients.json";
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Agrega un nuevo cliente al archivo JSON.
     * @param newClient Cliente a agregar.
     */

    @Override
    public void addClient(Client newClient) {
        try {
            File file = new File(path);
            boolean isFileCreated = file.isFile();
            if (!isFileCreated) {
                file.createNewFile();
            }
            FileReader reader = new FileReader(path);
            Type type = new TypeToken<ArrayList<Client>>() {
            }.getType();
            ArrayList<Client> writerArray = gson.fromJson(reader, type);
            if(writerArray == null) {
                ArrayList<Client> newArray = new ArrayList<>();
                newArray.add(newClient);
                writerArray = newArray;
            }else{
                writerArray.add(newClient);
            }

            String json = gson.toJson(writerArray);


            FileWriter fw = new FileWriter(file);
            fw.write(json);
            fw.close();
        } catch (IOException f) {}
    }

    /**
     * Obtiene todos los clientes registrados en el archivo JSON.
     * @return Lista de clientes, o null si ocurre un error al leer el archivo.
     */
    @Override
    public ArrayList<Client> listAllClients() {
        ArrayList<Client> clients= new ArrayList<Client>();
        try{
            FileReader fr = new FileReader(path);
            Type type = new TypeToken<ArrayList<Client>>(){}.getType();
            clients = gson.fromJson(fr, type);
        }
        catch (Exception e){
            return null;
        }
        return clients;
    }


    /**
     * Obtiene un cliente específico por su ID.
     * @param id ID del cliente a buscar.
     * @return Cliente con el ID dado, o null si no se encuentra o ocurre un error.
     */
    @Override
    public Client getClientById(int id) {
        ArrayList<Client> clients = new ArrayList<Client>();
        Client client = null;
        try {
            FileReader fr = new FileReader(path);
            Type type = new TypeToken<ArrayList<Client>>() {
            }.getType();
            clients = gson.fromJson(fr, type);
            for (int i = 0; clients.size() > i; i++) {
                if (id == clients.get(i).getClient_id()) {
                    client = clients.get(i);

                }
            }
        } catch (Exception e) {
            return null;
        }

        return client;
    }

    /**
     * Obtiene un cliente específico por su nombre completo.
     * @param name Nombre completo del cliente a buscar.
     * @return Cliente con el nombre dado, o null si no se encuentra o ocurre un error.
     */
    @Override
    public Client getClientByName(String name) {
        ArrayList<Client> clients = new ArrayList<Client>();
        Client client = null;
        try {
            FileReader fr = new FileReader(path);
            Type type = new TypeToken<ArrayList<Client>>() {
            }.getType();
            clients = gson.fromJson(fr, type);
            for (int i = 0; clients.size() > i; i++) {
                if (name.equals(clients.get(i).getFull_name())) {
                    client = clients.get(i);
                }
            }
        } catch (Exception e) {
            return null;
        }

        return client;
    }

    /**
     * Verifica si existe un cliente con un nombre y ID específicos.
     * @param name Nombre completo del cliente.
     * @param id ID del cliente.
     * @return true si el cliente existe, false en caso contrario.
     */
    @Override
    public boolean checkClient(String name, int id) {
        ArrayList<Client> clients = listAllClients();


        if (clients == null || clients.isEmpty()) {
            return false;
        }

        for (Client c : clients) {
            if (c.getFull_name().equalsIgnoreCase(name) && c.getClient_id() == id) {
                return true;
            }
        }

        return false;
    }

}

