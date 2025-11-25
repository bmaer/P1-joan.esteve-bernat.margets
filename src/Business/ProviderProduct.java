package Business;

public class ProviderProduct {
    String product_id;
    float selling_price;
    int units_in_stock;

    public ProviderProduct(String product_id, float selling_price, int units_in_stock) {
        this.product_id = product_id;
        this.selling_price = selling_price;
        this.units_in_stock = units_in_stock;
    }
    public String getProduct_id() {
        return product_id;
    }
    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }
    public float getSelling_price() {
        return selling_price;
    }
    public void setSelling_price(float selling_price) {
        this.selling_price = selling_price;
    }
    public int getUnits_in_stock() {
        return units_in_stock;
    }
    public void setUnits_in_stock(int units_in_stock) {
        this.units_in_stock = units_in_stock;
    }
}
