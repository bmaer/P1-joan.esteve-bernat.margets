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

public class ClientsJSONDAO implements ClientsDAO {
    private static final String path = "Resources/clients.json";
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();


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
            writerArray.add(newClient);


            String json = gson.toJson(writerArray);


            FileWriter fw = new FileWriter(file);
            fw.write(json);
            fw.close();
        } catch (IOException f) {}
    }

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

    @Override
    public boolean checkClientName(String name) {
        ArrayList<Client> clients = listAllClients();


        if (clients == null || clients.isEmpty()) {
            return false;
        }

        for (Client c : clients) {
            if (c.getFull_name().equalsIgnoreCase(name)) {
                return true;
            }
        }

        return false;
    }

}

