package Business;


import Persistance.SalesDAO;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Clase que gestiona las operaciones relacionadas con las ventas.
 */
public class SaleManager {
    SalesDAO salesDAO;
    public SaleManager(SalesDAO salesDAO) {
        this.salesDAO = salesDAO;
    }

    /**
     * Obtiene todas las ventas registradas.
     * @return Lista de todas las ventas, o null si ocurre un error.
     */
    public ArrayList<Sale> getAllSales() {
        return salesDAO.getAllSales();
    }

    /**
     * Registra una nueva venta en el sistema.
     * @param sale Venta a agregar.
     */
    public void AddSale(Sale sale){
        salesDAO.addSale(sale);
    }

    /**
     * Convierte la fecha de compra de una venta desde formato timestamp a una cadena legible.
     * @param sale Venta cuya fecha se desea convertir.
     * @return Fecha y hora de la venta en formato "dd/MM/yyyy - HH:mm".
     */
    public String convertSaleTimeStamp(Sale sale){
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");

    String timeStamp = Instant.ofEpochSecond(sale.getPurchase_date())
            .atZone(ZoneId.systemDefault())
            .format(fmt);

    return timeStamp;
    }


    /**
     * Obtiene todas las ventas realizadas por un cliente específico.
     * @param clientId ID del cliente.
     * @return Lista de ventas del cliente, o null si no tiene ventas o ocurre un error.
     */
    public ArrayList<Sale> getSalesByClientId(int clientId){
        return salesDAO.getSalesByClientId(clientId);
    }

}