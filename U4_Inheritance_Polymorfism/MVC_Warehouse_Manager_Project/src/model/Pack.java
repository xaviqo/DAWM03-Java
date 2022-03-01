package model;

import java.util.ArrayList;

import view.IniciVistaControler;

public final class Pack extends Product {

    public ArrayList<Integer> packageList;
    private float discountPercentage;

    public Pack(){
        this("",0,0, 0);
    }
    public Pack(String name, float price, int stock, float discountPercentage) {
        super(name, price, stock);
        this.packageList = new ArrayList<Integer>();
        this.discountPercentage = discountPercentage;
    }

    public ArrayList<Integer> getPackageList() {
        return packageList;
    }

    public boolean setPackageList(Integer productId) {

        if (productId != this.getId()){

            if (!this.packageList.contains(productId)){

                if (IniciVistaControler.productMainMap.existsProduct(productId)){
                    return this.packageList.add(productId);
                } else {
                    return false;
                }

            }

            return false;

        }

        return false;

    }

    public boolean removeProduct(Integer productId){
        return this.packageList.remove(productId);
    }

    public float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public boolean equals(Object object) {

        if (object instanceof Pack) {

            Pack pack = (Pack) object;

            if (this.packageList.equals(pack.getPackageList())) {

                return true;

            } else {

                return false;
            }
        }

        return false;

    }

    @Override
    public String toString() {

        String toStr = "ID["+this.getId()+"] NAME["+this.getName()+"] $["+this.getPrice()+"] STCK["+this.getStock()+"] DISC["+this.getDiscountPercentage()+"] P.SIZE["+packageList.size()+"] PACK"+this.packageList.toString();

        return toStr;
    }
}
