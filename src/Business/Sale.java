package Business;

public class Sale {
    private int client_id;
    private float price_paid;
    private long purchase_date;
    private String product_id;

    public Sale() {}

    public Sale(int client_id, float price_paid, long purchase_date, String product_id) {
        this.client_id = client_id;
        this.price_paid = price_paid;
        this.purchase_date = purchase_date;
        this.product_id = product_id;
    }
    public int getClient_id() {
        return client_id;
    }
    public float getPrice_paid() {
        return price_paid;
    }
    public long getPurchase_date() {
        return purchase_date;
    }
    public String getProduct_id() {
        return product_id;
    }




}
