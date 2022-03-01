package model.DAO;

import controler.UtilConsole;
import model.Pack;

import java.util.HashMap;

public class PackDAO {

    private HashMap<Integer, Object> packMap = new HashMap<>();

    public boolean save(Object pack){

        if (!packMap.containsValue(pack) && !packMap.containsKey(((Pack)pack).getId())){

            packMap.put(((Pack)pack).getId(), pack);

            return true;

        } else {

            return false;
        }
    }

    public Object returnPack(String id){

        return packMap.get(id);

    }

    public boolean existsPack(String id){

        return packMap.containsKey(id);

    }

    public boolean deletePack(String id){

        if (existsPack(id)){

            packMap.remove(id);

            return true;
        } else {

            return false;
        }
    }

    public void showPacks(){

        for (Object pack : this.packMap.values()) {

            System.out.println(pack);

        }
    }

    public int totalPacks(){

        return  packMap.size();

    }

    public static Pack addProductsToPack(Pack pack){

        int productId = -1;

        do {

            System.out.print("Introduce el id del producto (0 - Salir): ");
            productId = UtilConsole.inputInt();

            if (!pack.setPackageList(productId) & productId != 0){
                System.err.println("Error añadiendo producto");
                System.err.println("No existe, ya está añadido o es la id del Pack");
            } else {
                System.out.println("Producto añadido");
            }

            System.out.println("Total productos añadidos: "+pack.packageList.size());


        } while (productId != 0);

        return pack;

    }

}
