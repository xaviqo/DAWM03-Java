package model.DAO;

import model.Product;

import java.util.HashMap;

public class ProductDAO {

    private HashMap<Integer, Object> productMap = new HashMap<>();

    public boolean save(Object product){

        if (!productMap.containsValue(product) && !productMap.containsKey(((Product)product).getId())){

            productMap.put(((Product)product).getId(), product);

            return true;

        } else {

            return false;
        }
    }

    public Object returnProduct(int id){

        return productMap.get(id);

    }

    public boolean existsProduct(int id){

        return productMap.containsKey(id);

    }

    public boolean deleteProduct(int id){

        if (existsProduct(id)){

            productMap.remove(id);

            return true;
        } else {

            return false;
        }
    }

    public void showProducts(){

        for (Object product : this.productMap.values()) {

            System.out.println(product);

        }
    }

    public int totalProducts(){

        return  productMap.size();

    }

}
