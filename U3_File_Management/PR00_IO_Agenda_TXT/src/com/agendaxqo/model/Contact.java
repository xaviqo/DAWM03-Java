package com.agendaxqo.model;

public class Contact {

    private String name;
    private String phone;
    private String city;
    private boolean mobile;

    public Contact() {
        this("", "", "", false);
    }

    public Contact(String name, String phone, String city, boolean mobile) {
        this.name = name;
        this.phone = phone;
        this.city = city;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isMobile() {
        return mobile;
    }

    public void setMobile(boolean mobile) {
        this.mobile = mobile;
    }


    @Override
    public String toString() {
        return "NAME: '" + name + '\'' +
                ", PHONE: '" + phone + '\'' +
                ", CITY: '" + city + '\'' +
                ", MOBILE: " + mobile;
    }
}
