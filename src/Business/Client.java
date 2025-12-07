package Business;

import java.util.ArrayList;

/**
 * Clase que representa un cliente con su información básica.
 */
public class Client {
    private int client_id;
    private String full_name;
    private ArrayList<PhoneNumber> phone_numbers;


    /**
     * Obtiene el ID del cliente.
     * @return ID del cliente.
     */
    public int getClient_id() {
        return client_id;
    }

    /**
     * Obtiene el nombre completo del cliente.
     * @return Nombre completo del cliente.
     */
    public String getFull_name() {
        return full_name;
    }

    /**
     * Obtiene la lista de números de teléfono del cliente.
     * @return Lista de PhoneNumber.
     */
    public ArrayList<PhoneNumber> getPhone_numbers() {
        return phone_numbers;
    }

    /**
     * Constructor vacío de la clase Client.
     * Sirve para inicializar ArrayList.
     */
    public Client (){}

    /**
     * Establece el ID del cliente.
     * @param client_id ID del cliente.
     */
    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    /**
     * Establece el nombre completo del cliente.
     * @param full_name Nombre completo.
     */
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    /**
     * Establece la lista de números de teléfono del cliente.
     * @param phone_numbers Lista de PhoneNumber.
     */
    public void setPhone_numbers(ArrayList<PhoneNumber> phone_numbers) {
        this.phone_numbers = phone_numbers;
    }

}
