package Business;

/**
 * Clase que representa un producto ofrecido por un proveedor, incluyendo precio y stock disponible.
 */
public class ProviderProduct {
    String product_id;
    float selling_price;
    int units_in_stock;

    /**
     * Constructor que inicializa un producto ofrecido por un proveedor.
     * @param product_id ID del producto.
     * @param selling_price Precio de venta del producto.
     * @param units_in_stock Unidades disponibles en stock.
     */
    public ProviderProduct(String product_id, float selling_price, int units_in_stock) {
        this.product_id = product_id;
        this.selling_price = selling_price;
        this.units_in_stock = units_in_stock;
    }

    /**
     * Obtiene el ID del producto ofrecido por el proveedor.
     * @return ID del producto.
     */
    public String getProduct_id() {
        return product_id;
    }

    /**
     * Establece el ID del producto ofrecido por el proveedor.
     * @param product_id ID del producto.
     */
    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }


    /**
     * Obtiene el precio de venta del producto.
     * @return Precio de venta.
     */
    public float getSelling_price() {
        return selling_price;
    }


    /**
     * Establece el precio de venta del producto.
     * @param selling_price Precio de venta.
     */
    public void setSelling_price(float selling_price) {
        this.selling_price = selling_price;
    }

    /**
     * Obtiene las unidades disponibles en stock.
     * @return Unidades en stock.
     */
    public int getUnits_in_stock() {
        return units_in_stock;
    }

    /**
     * Establece las unidades disponibles en stock.
     * @param units_in_stock Unidades en stock.
     */
    public void setUnits_in_stock(int units_in_stock) {
        this.units_in_stock = units_in_stock;
    }
}
