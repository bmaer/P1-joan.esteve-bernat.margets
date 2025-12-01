package Business;


import Persistance.SalesDAO;

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


}