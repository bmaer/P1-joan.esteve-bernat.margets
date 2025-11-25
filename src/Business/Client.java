package Business;

public class Client {
    private int client_id;
    private String full_name;

    public Client(int client_id, String full_name) {
        this.client_id = client_id;
        this.full_name = full_name;
    }
    public int getClient_id() {
        return client_id;
    }
    public String getFull_name() {
        return full_name;
    }
    public Client (){}

}
