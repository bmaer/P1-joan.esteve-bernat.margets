package Persistance;

import Business.Sale;

import java.io.*;
import java.util.ArrayList;

public class SalesCSVDAO implements SalesDAO {
    private static final String path = "src/Persistance/Sales.csv";


    public SalesCSVDAO() {}

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
                double pricePaid = Double.parseDouble(parts[2]);
                long purchaseDate = Long.parseLong(parts[3]);

                Sale sale = new Sale(clientId, pricePaid, purchaseDate, productId);
                sales.add(sale);
            }

        } catch (Exception e) {
            return null;
        }
        return sales;
    }

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
        } catch (IOException e) {

        }

    }
}
