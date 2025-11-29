package Business;

import java.util.ArrayList;

public class Client {
    private int client_id;
    private String full_name;
    private ArrayList<PhoneNumber> phone_numbers;

    public Client(int client_id, String full_name, ArrayList<PhoneNumber> phone_numbers) {
        this.client_id = client_id;
        this.full_name = full_name;
        this.phone_numbers = phone_numbers;

    }
    public int getClient_id() {
        return client_id;
    }
    public String getFull_name() {
        return full_name;
    }
    public ArrayList<PhoneNumber> getPhone_numbers() {
        return phone_numbers;
    }
    public Client (){}

}
