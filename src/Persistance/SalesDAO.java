package Persistance;

import Business.Sale;

import java.util.ArrayList;

/**
 * Interfaz que define las operaciones de acceso a datos para las ventas.
 */
public interface SalesDAO {

    /**
     * Obtiene todas las ventas registradas en el archivo CSV.
     * @return Lista de todas las ventas, o null si ocurre un error al leer el archivo.
     */
    public ArrayList<Sale> getAllSales();

    /**
     * Agrega una nueva venta al archivo CSV.
     * @param sale Venta a agregar al registro.
     */
    public void addSale(Sale sale);

    /**
     * Obtiene todas las ventas realizadas por un cliente específico.
     * @param clientId ID del cliente.
     * @return Lista de ventas del cliente, vacía si no tiene ventas.
     */
    public ArrayList<Sale> getSalesByClientId(int clientId);
}
