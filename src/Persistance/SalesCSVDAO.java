package Persistance;

import Business.Sale;

import java.io.*;
import java.util.ArrayList;

/**
 * Implementación de SalesDAO que gestiona las ventas usando un archivo CSV.
 */

public class SalesCSVDAO implements SalesDAO {
    private static final String path = "Resources/Sales.csv";


    public SalesCSVDAO() {}

    /**
     * Obtiene todas las ventas registradas en el archivo CSV.
     * @return Lista de todas las ventas, o null si ocurre un error al leer el archivo.
     */
    @Override
    public ArrayList<Sale> getAllSales(){
        ArrayList<Sale> sales = new ArrayList<Sale>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            boolean firstLine = true;
            while ((line = br.readLine()) != null) {

                // Skip header line
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                // Skip empty lines
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");

                int clientId = Integer.parseInt(parts[0]);
                String productId = parts[1];
                float pricePaid = Float.parseFloat(parts[2]);
                long purchaseDate = Long.parseLong(parts[3]);

                Sale sale = new Sale(clientId, pricePaid, purchaseDate, productId);
                sales.add(sale);
            }

        } catch (Exception e) {
            return null;
        }
        return sales;
    }

    /**
     * Agrega una nueva venta al archivo CSV.
     * @param sale Venta a agregar al registro.
     */
    @Override
    public void addSale(Sale sale){

        try {
            File file = new File(path);
            boolean isFileCreated = file.isFile();
            if (!isFileCreated) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(path, true);
            writer.write(
                    sale.getClient_id() + "," +
                            sale.getProduct_id() + "," +
                            sale.getPrice_paid() + "," +
                            sale.getPurchase_date() + "\n"
            );


            writer.close();
        } catch (IOException e) {

        }

    }

    /**
     * Obtiene todas las ventas realizadas por un cliente específico.
     * @param clientId ID del cliente.
     * @return Lista de ventas del cliente, vacía si no tiene ventas.
     */
    @Override
    public ArrayList<Sale> getSalesByClientId(int clientId){
        ArrayList<Sale> sales = getAllSales();
        ArrayList<Sale> userSales = new ArrayList<Sale>();
        for(int i = 0; i < sales.size(); i++){
            if(sales.get(i).getClient_id() == clientId){
                userSales.add(sales.get(i));
            }
        }
        return userSales;
    }
}
