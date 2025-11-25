package Persistance;

import Business.Sale;

import java.util.ArrayList;

public interface SalesDAO {

    public ArrayList<Sale> getAllSales();

    public void addSale(Sale sale);
}
