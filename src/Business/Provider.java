package Business;

import java.util.ArrayList;

public class Provider {
    private int provider_id;
    private String company_name;
    private String cif;
    private String contact_name;
    private String phone;
    private String email;
    private ArrayList<ProviderProduct> products_for_sale;

    public Provider() {}

    public Provider(int provider_id, String company_name, String cif, String contact_name, String phone, String email, ArrayList<ProviderProduct> products_for_sale) {
        this.provider_id = provider_id;
        this.company_name = company_name;
        this.cif = cif;
        this.contact_name = contact_name;
        this.phone = phone;
        this.email = email;
        this.products_for_sale = products_for_sale;
    }
    public int getProvider_id() {
        return provider_id;

    }
    public String getCompany_name() {
        return company_name;
    }
    public String getCif() {
        return cif;
    }
    public String getContact_name() {
        return contact_name;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
    public ArrayList<ProviderProduct> getProducts_for_sale() {
        return products_for_sale;
    }
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
