package Business;

/**
 * Clase que representa una venta realizada por un cliente, incluyendo el producto, precio y fecha.
 */
public class Sale {
    private int client_id;
    private float price_paid;
    private long purchase_date;
    private String product_id;

    /**
     * Constructor vacío de la clase Sale.
     * Sirve para inicializar ArrayList.
     */
    public Sale() {}

    /**
     * Constructor que inicializa todos los campos de la venta.
     * @param client_id ID del cliente que realizó la venta.
     * @param price_paid Precio pagado por el producto.
     * @param purchase_date Fecha de la compra en formato timestamp (segundos desde epoch).
     * @param product_id ID del producto vendido.
     */
    public Sale(int client_id, float price_paid, long purchase_date, String product_id) {
        this.client_id = client_id;
        this.price_paid = price_paid;
        this.purchase_date = purchase_date;
        this.product_id = product_id;
    }


    /**
     * Obtiene el ID del cliente que realizó la venta.
     * @return ID del cliente.
     */
    public int getClient_id() {
        return client_id;
    }

    /**
     * Obtiene el precio pagado por el producto en la venta.
     * @return Precio pagado.
     */
    public float getPrice_paid() {
        return price_paid;
    }

    /**
     * Obtiene la fecha de compra de la venta en formato timestamp.
     * @return Fecha de compra en segundos desde epoch.
     */
    public long getPurchase_date() {
        return purchase_date;
    }

    /**
     * Obtiene el ID del producto vendido en la venta.
     * @return ID del producto.
     */
    public String getProduct_id() {
        return product_id;
    }

    /**
     * Establece el ID del cliente que realizó la venta.
     * @param client_id ID del cliente.
     */
    public void setClientId(int client_id) {
        this.client_id = client_id;
    }

    /**
     * Establece el precio pagado por el producto en la venta.
     * @param price_paid Precio pagado.
     */
    public void setPricePaid(float price_paid) {
        this.price_paid = price_paid;
    }

    /**
     * Establece la fecha de compra de la venta en formato timestamp.
     * @param purchase_date Fecha de compra en segundos desde epoch.
     */
    public void setPurchaseDate(long purchase_date) {
        this.purchase_date = purchase_date;
    }

    /**
     * Establece el ID del producto vendido en la venta.
     * @param product_id ID del producto.
     */
    public void setProductId(String product_id) {
        this.product_id = product_id;
    }




}
