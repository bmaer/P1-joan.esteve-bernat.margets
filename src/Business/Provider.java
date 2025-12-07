package Business;

import java.util.ArrayList;

/**
 * Clase que representa un proveedor, incluyendo información de contacto y los productos que ofrece.
 */
public class Provider {
    private int provider_id;
    private String company_name;
    private String cif;
    private String contact_name;
    private String phone;
    private String email;
    private ArrayList<ProviderProduct> products_for_sale;

    /**
     * Constructor vacío de la clase Provider.
     * Sirve para inicializar ArrayList.
     */
    public Provider() {}

    /**
     * Constructor que inicializa todos los campos del proveedor.
     * @param provider_id ID único del proveedor.
     * @param company_name Nombre de la empresa.
     * @param cif CIF de la empresa.
     * @param contact_name Nombre de la persona de contacto.
     * @param phone Teléfono de contacto.
     * @param email Correo electrónico de contacto.
     * @param products_for_sale Lista de productos ofrecidos por el proveedor.
     */
    public Provider(int provider_id, String company_name, String cif, String contact_name, String phone, String email, ArrayList<ProviderProduct> products_for_sale) {
        this.provider_id = provider_id;
        this.company_name = company_name;
        this.cif = cif;
        this.contact_name = contact_name;
        this.phone = phone;
        this.email = email;
        this.products_for_sale = products_for_sale;
    }

    /**
     * Obtiene el ID del proveedor.
     * @return ID del proveedor.
     */
    public int getProvider_id() {
        return provider_id;

    }

    /**
     * Obtiene el nombre de la empresa.
     * @return Nombre de la empresa.
     */
    public String getCompany_name() {
        return company_name;
    }

    /**
     * Obtiene el CIF del proveedor.
     * @return CIF del proveedor.
     */
    public String getCif() {
        return cif;
    }

    /**
     * Obtiene el nombre de la persona de contacto.
     * @return Nombre del contacto.
     */
    public String getContact_name() {
        return contact_name;
    }

    /**
     * Obtiene el teléfono de contacto.
     * @return Teléfono del proveedor.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Obtiene el correo electrónico de contacto.
     * @return Correo electrónico del proveedor.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Obtiene la lista de productos ofrecidos por el proveedor.
     * @return Lista de productos.
     */
    public ArrayList<ProviderProduct> getProducts_for_sale() {
        return products_for_sale;
    }

    /**
     * Obtiene un producto específico ofrecido por el proveedor mediante su ID.
     * @param id ID del producto.
     * @return Producto correspondiente, o null si no se encuentra.
     */
    public ProviderProduct getProductById(String id) {
        ProviderProduct p = null;
        for(int i = 0; i < products_for_sale.size(); i++) {
            if(id.equals(products_for_sale.get(i).getProduct_id())) {
                p = products_for_sale.get(i);
            }
        }
        return p;
    }
}
