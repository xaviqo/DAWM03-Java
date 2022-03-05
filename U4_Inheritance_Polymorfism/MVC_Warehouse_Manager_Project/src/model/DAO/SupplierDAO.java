package model.DAO;

import controler.Persistable;
import model.Supplier;

import java.util.HashMap;

public class SupplierDAO implements Persistable {

    private HashMap<String, Object> supplierMap = new HashMap<>();

    public boolean save(Object supplier){

        if (!supplierMap.containsValue(supplier) && !supplierMap.containsKey(((Supplier)supplier).getId())){

            supplierMap.put(((Supplier)supplier).getId(), supplier);

            return true;

        } else {

            return false;
        }
    }

    public Object returnSupplier(String id){

        return supplierMap.get(id);

    }

    public boolean existsSupplier(String id){

        return supplierMap.containsKey(id);

    }

    public boolean deleteSupplier(String id){

        if (existsSupplier(id)){

            supplierMap.remove(id);

            return true;
        } else {

            return false;
        }
    }

    public void showSuppliers(){

        for (Object supplier : this.supplierMap.values()) {

            System.out.println(supplier);

        }
    }

    public int totalSuppliers(){

        return  supplierMap.size();

    }

}
