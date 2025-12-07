package Business;


import Persistance.SalesDAO;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class SaleManager {
    SalesDAO salesDAO;
    public SaleManager(SalesDAO salesDAO) {
        this.salesDAO = salesDAO;
    }


    public ArrayList<Sale> getAllSales() {
        return salesDAO.getAllSales();
    }

    public void AddSale(Sale sale){
        salesDAO.addSale(sale);
}

    public String convertSaleTimeStamp(Sale sale){
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");

    String timeStamp = Instant.ofEpochSecond(sale.getPurchase_date())
            .atZone(ZoneId.systemDefault())
            .format(fmt);

    return timeStamp;
    }



    public ArrayList<Sale> getSalesByClientId(int clientId){


        return salesDAO.getSalesByClientId(clientId);
    }

}