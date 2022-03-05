package model;

import java.time.LocalDate;

public class Supplier extends Persona{

    private double cashDiscount;

    public Supplier(){
        this("","","",null,"","",null,0);
    }

    public Supplier(double cashDiscount){
        this("","","",null,"","",null,cashDiscount);
    }

    public Supplier(String idCard, String name, String surname, LocalDate birthDate, String phone, String email, Address address, double cashDiscount) {
        super(idCard, name, surname, birthDate, phone, email, address);
        this.cashDiscount = cashDiscount;
    }

    public double getCashDiscount() {
        return cashDiscount;
    }

    public void setCashDiscount(double cashDiscount) {
        this.cashDiscount = cashDiscount;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "cashDiscount=" + cashDiscount +
                "} " + super.toString();
    }
}
