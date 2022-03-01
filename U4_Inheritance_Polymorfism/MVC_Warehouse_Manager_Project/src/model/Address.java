package model;

public class Address {

    private String city;
    private String region;
    private String street;
    private int postal;

    public Address(){
        this("","","",0);
    }

    public Address(String city, String region, String street, int postal) {
        this.city = city;
        this.region = region;
        this.street = street;
        this.postal = postal;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostal() {
        return postal;
    }

    public void setPostal(int postal) {
        this.postal = postal;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", street='" + street + '\'' +
                ", postal=" + postal +
                '}';
    }
}
