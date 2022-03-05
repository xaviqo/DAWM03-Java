package model;

public class Product {

    private static int counter = 1;
    
    private int id;
    private String name;
    private float price;
    private int stock;

    public Product(){
        this("",0,0);
    }

    public Product(String name, float price, int stock) {
        this.id = counter++;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object object) {

        // if (object.getClass() == this.getClass()) {

        if (object instanceof Product) {

            Product checkProduct = (Product) object;

            if (this.name.equalsIgnoreCase(checkProduct.getName())) {

                return true;

            } else {

                return false;

            }

        } else {

            return false;

        }

    }

    @Override
    public String toString() {

        String toStr = "ID["+this.getId()+"] NAME["+this.getName()+"] $["+this.getPrice()+"] STCK["+this.getStock()+"]";

        return toStr;
    }
}
