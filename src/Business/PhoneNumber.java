package Business;

/**
 * Clase que representa el número de teléfono del cliente con prefijo de país.
 */
public class PhoneNumber {
    private String number;
    private String country_prefix;

    /**
     * Obtiene el número de teléfono.
     * @return Número de teléfono.
     */
    public String getNumber() {
        return number;
    }

    /**
     * Obtiene el prefijo del país.
     * @return Prefijo del país.
     */
    public String getCountry_prefix() {
        return country_prefix;
    }

    /**
     * Constructor vacío de la clase PhoneNumber.
     * Sirve para inicializar ArrayList.
     */
    public PhoneNumber(){}

    /**
     * Establece el número de teléfono.
     * @param number Número de teléfono.
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Establece el prefijo del país.
     * @param country_prefix Prefijo del país.
     */
    public void setCountry_prefix(String country_prefix) {
        this.country_prefix = country_prefix;
    }

}
