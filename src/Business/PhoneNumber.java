package Business;

public class PhoneNumber {
    private String number;
    private String country_prefix;

    public PhoneNumber(String number, String country_prefix) {
        this.number = number;
        this.country_prefix = country_prefix;
    }
    public String getNumber() {
        return number;
    }
    public String getCountry_prefix() {
        return country_prefix;
    }
    public PhoneNumber(){}

    public void setNumber(String number) {
        this.number = number;
    }
    public void setCountry_prefix(String country_prefix) {
        this.country_prefix = country_prefix;
    }

}
