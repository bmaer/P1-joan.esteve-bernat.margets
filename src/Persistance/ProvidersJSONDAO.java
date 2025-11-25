package Persistance;

import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ProvidersJSONDAO implements ProvidersDAO {

    public void delate(){
        try {
            File file = new File(filePath);
            ArrayList<Team> teams = new ArrayList<Team>();
            Type type = new TypeToken<ArrayList<Team>>() {
            }.getType();
            teams = gson.fromJson(new FileReader(file), type);
            teams.removeIf(x -> x.getName().equals(deletingTeam));

            FileWriter writer = new FileWriter(file);
            gson.toJson(teams, writer);
            writer.close();
            deleted = true;
        } catch (IOException e) {}
    }



    public void write(){
        try {
            File file = new File(path);
            boolean isFileCreated = file.isFile();
            if (!isFileCreated) {
                file.createNewFile();
            }
            FileReader reader = new FileReader(path);
            Type type = new TypeToken<ArrayList<Team>>() {
            }.getType();
            ArrayList<Team> jsonArray = gson.fromJson(reader, type);
            jsonArray.add(createdTeam);

            // Pasamos el array de teams a un string formato Json
            String json = gson.toJson(jsonArray);
            // Escribimos el string al fichero

            FileWriter fw = new FileWriter(file);
            fw.write(json);
            fw.close();
        } catch (IOException f) {}
    }
}
