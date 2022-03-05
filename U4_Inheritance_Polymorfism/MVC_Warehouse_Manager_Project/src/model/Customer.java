package model;

import java.time.LocalDate;

public class Customer extends Persona {

    private boolean newsLetter;

    public Customer(){ //default constructor newsLetter is TRUE;
        this("","","",null,"", "",null,true);

    }

    public Customer(boolean newsLetter){
        this("","","",null,"","",null,newsLetter);
    }

    public Customer(String idCard, String name, String surname, LocalDate birthDate, String phone, String email, Address address, boolean newsLetter) {
        super(idCard, name, surname, birthDate, phone, email, address);
        this.newsLetter = newsLetter;
    }

    public boolean isNewsLetter() {
        return newsLetter;
    }

    public void setNewsLetter(boolean newsLetter) {
        this.newsLetter = newsLetter;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "newsLetter=" + newsLetter +
                "} " + super.toString();
    }
}
