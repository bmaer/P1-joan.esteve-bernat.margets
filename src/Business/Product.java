package Business;

/**
 * Clase que representa un producto con su información básica.
 */
public class Product {
    String product_id;
    String product_name;
    String brand;
    String model;

    /**
     * Constructor que inicializa todos los campos del producto.
     * @param product_id ID del producto.
     * @param product_name Nombre del producto.
     * @param brand Marca del producto.
     * @param model Modelo del producto.
     */
    public Product(String product_id, String product_name, String brand, String model) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.brand = brand;
        this.model = model;
    }

    /**
     * Obtiene el ID del producto.
     * @return ID del producto.
     */
    public String  getProduct_id() {
        return product_id;
    }

    /**
     * Obtiene el nombre del producto.
     * @return Nombre del producto.
     */
    public String getProduct_name() {
        return product_name;
    }

    /**
     * Obtiene la marca del producto.
     * @return Marca del producto.
     */
    public String getBrand() {
        return brand;
    }
    /**
     * Obtiene el modelo del producto.
     * @return Modelo del producto.
     */
    public String getModel() {
        return model;
    }

    /**
     * Constructor vacío de la clase Product.
     * Sirve para inicializar ArrayList.
     */
    public Product(){}
}
