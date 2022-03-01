package model.DAO;

import model.Customer;

import java.util.HashMap;

public class CustomerDAO {

    private HashMap<String, Object> customerMap= new HashMap<>();

    public boolean save(Object customer){

        if (!customerMap.containsValue(customer) && !customerMap.containsKey(((Customer)customer).getId())){

            customerMap.put(((Customer)customer).getId(), customer);

            return true;

        } else {

            return false;
        }

    }

    public Object returnCustomer(String id){

        return this.customerMap.get(id);

    }

    public boolean existsCustomer(String id){

        return customerMap.containsKey(id);

    }

    public boolean deleteCustomer(String id){

        if (existsCustomer(id)){

            customerMap.remove(id);

            return true;
        } else {

            return false;
        }
    }

    public void showCustomers(){

        for (Object customer : this.customerMap.values()) {

            System.out.println(customer);

        }
    }

    public int totalCustomers(){

        return customerMap.size();
    }
}
