package view;

import model.*;
import model.DAO.*;
import controler.*;

import java.time.LocalDate;

public class IniciVistaControler {

    public static ProductDAO productMainMap = new ProductDAO();
    private static CustomerDAO customerMainMap = new CustomerDAO();
    private static SupplierDAO supplierMainMap = new SupplierDAO();


    public static void main(String[] args) {

        //TEST PRESETS

        Product testProd = new Product("test1", 1, 22);
        productMainMap.save(testProd);
        Product testProd2 = new Product("test2", 2.2f, 2);
        productMainMap.save(testProd2);

        Pack pack1 = new Pack("pack1", 12.3f, 2, 20);
        pack1.setPackageList(1);
        pack1.setPackageList(2);

        productMainMap.save(pack1);

        Address add = new Address("Barcelona", "Caldes de Montbui", "Figuera 48", 8140);

        Customer cus1 = new Customer("43565889W", "Xavi", "Quinones", LocalDate.parse("1990-02-14"), "938646492", "silent90s@gmail.com", add, false);
        Customer cus2 = new Customer("12345678Z", "Pedro", "Bar", LocalDate.parse("1999-09-29"), "123213232", "test@mail.net", add, true);

        customerMainMap.save(cus1);
        customerMainMap.save(cus2);


        mainSwitch(mainMenu());
    }

    /* // // // MAIN MENU // // // */

    public static int mainMenu() {

        System.out.println("1 - Gestionar productos");
        System.out.println("2 - Gestionar packs");
        System.out.println("3 - Gestionar clientes");
        System.out.println("4 - Gestionar proveedores");
        System.out.println("5 - Test Option");
        System.out.println("0 - Salir");
        System.out.println();
        System.out.print("Selecciona una opción: ");

        int option = UtilConsole.inputInt();

        return option;

    }

    public static void mainSwitch(int userOption) {

        switch (userOption) {
            case 1:
                productSwitch(productMenu());
                break;
            case 2:
                packSwitch(packMenu());
                break;
            case 3:
                customerSwitch(customerMenu());
                break;
            case 4:
                supplierSwitch(supplierMenu());
                break;
            case 0:
                System.exit(0);
                break;
            default:
                mainSwitch(mainMenu());
                break;
        }

    }

    /* // // // PRODUCTS - SWITCH & MENU // // // */

    private static int productMenu() {

        String palabra = "producto";

        System.out.println("1 - Añadir " + palabra);
        System.out.println("2 - Buscar " + palabra);
        System.out.println("3 - Modificar " + palabra);
        System.out.println("4 - Borrar " + palabra);
        System.out.println("5 - Mostrar " + palabra + "s");
        System.out.println("0 - Volver al menú principal");
        System.out.println();
        System.out.print("Selecciona una opción: ");

        int option = UtilConsole.inputInt();

        return option;

    }

    private static void productSwitch(int userOption) {

        Product product = new Product();

        switch (userOption) {
            case 1:
                addProduct(product);
                break;
            case 2:
                findProduct(product);
                break;
            case 3:
                modifyProduct();
                break;
            case 4:
                deleteProduct();
                break;
            case 5:
                showProductMapList();
                break;
            case 0:
                mainSwitch(mainMenu());
                break;
            default:
                productSwitch(productMenu());
                ;
        }

    }

    /* // // // PACKS - SWITCH & MENU // // // */

    private static int packMenu() {

        String palabra = "pack";

        System.out.println("1 - Añadir " + palabra);
        System.out.println("2 - Buscar " + palabra);
        System.out.println("3 - Modificar " + palabra);
        System.out.println("4 - Borrar " + palabra);
        System.out.println("5 - Mostrar " + palabra + "s");
        System.out.println("0 - Volver al menú principal");
        System.out.println();
        System.out.print("Selecciona una opción: ");

        int option = UtilConsole.inputInt();

        return option;

    }

    private static void packSwitch(int userOption) {

        Pack pack = new Pack();

        switch (userOption) {
            case 1:
                addProduct(pack);
                break;
            case 2:
                findProduct(pack);
                break;
            case 3:
                modifyProduct();
                break;
            case 4:
                deleteProduct();
                break;
            case 5:
                showProductMapList();
                break;
            case 0:
                mainSwitch(mainMenu());
                break;
            default:
                productSwitch(productMenu());
                ;
        }

    }

    // PRODUCT METHODS

    // CASE 1 - PRODUCTS AND PACKS

    public static void addProduct(Product product) {

        String typeOf = "";

        if (product instanceof Pack) {
            typeOf = "pack";
        } else if (product instanceof Product) {
            typeOf = "producto";
        }

        System.out.println("Id asignada: " + product.getId());
        System.out.println();

        System.out.print("Nombre del " + typeOf + ": ");
        product.setName(UtilConsole.inputString());

        System.out.print("Precio del " + typeOf + ": ");
        product.setPrice(UtilConsole.inputFloat());

        System.out.print("Stock inicial: ");
        product.setStock(UtilConsole.inputInt());

        if (typeOf.equals("pack")) {

            if (UtilConsole.yesOrNo("Mostrar lista de todos los productos disponibles?"))
                productMainMap.showProducts();

            product = PackDAO.addProductsToPack(((Pack) product));

            System.out.print("Porcentaje de descuento: ");
            ((Pack) product).setDiscountPercentage(UtilConsole.inputFloat());

        }

        if (productMainMap.save(product)) {
            System.out.println("El " + typeOf + " " + product.getName() + " con id " + product.getId() + " ha sido guardado");
        } else {
            System.err.println("Ha ocurrido un error creando el " + typeOf);
        }

        if (UtilConsole.yesOrNo("Desea añadir otro " + typeOf + "?")) {
            addProduct(product); //TODO => ARREGLAR! EL PACK ES EL MISMO
        } else {
            mainSwitch(mainMenu());
        }

    }

    // CASE 2 - PRODUCTS AND PACKS

    private static void findProduct(Product product) {

        String typeOf = "";
        int productId = 0;

        if (product instanceof Pack) {
            typeOf = "pack";
        } else if (product instanceof Product) {
            typeOf = "producto";
        }

        System.out.print("Id del " + typeOf + " a buscar:");
        productId = UtilConsole.inputInt();

        if (productMainMap.existsProduct(productId)) {

            product = (Product) productMainMap.returnProduct(productId);
            System.out.println(product);

            if (product instanceof Pack) {

                System.out.println("El pack " + product.getId() + " contiene un total de " + ((Pack) product).packageList.size() + " productos:");

                for (Integer eachProductId : ((Pack) product).packageList) {
                    System.out.println(((Product)productMainMap.returnProduct(eachProductId)).getName());
                }

            } else {

                System.out.println("El producto " + product.getName() + " no es un pack");

            }

        } else {
            System.err.println("No existe ningun producto con el id " + typeOf);
        }

        if (UtilConsole.yesOrNo("Buscar otro " + typeOf + "?")) {
            findProduct(product);
        } else {
            mainSwitch(mainMenu());
        }

    }

    // CASE 3 - PRODUCTS AND PACKS

    private static void modifyProduct() {

        String typeOf = "";

        System.out.println("Id del producto a modificar: ");
        int productId = UtilConsole.inputInt();

        if (productMainMap.existsProduct(productId)) {

            Product product = (Product) productMainMap.returnProduct(productId);

            System.out.println("Datos actuales:");

            if (product instanceof Pack) {
                typeOf = "pack";
                System.out.println(((Pack) product).toString());
            } else if (product instanceof Product) {
                typeOf = "producto";
                System.out.println(product.toString());
            }

            System.out.print("Nombre: ");
            product.setName(UtilConsole.inputString());

            System.out.print("Precio: ");
            product.setPrice(UtilConsole.inputFloat());

            System.out.print("Stock: ");
            product.setStock(UtilConsole.inputInt());

            if (typeOf.equals("pack")) {

                if (UtilConsole.yesOrNo("Mostrar lista de productos añadidos actualmente en el pack?")) {

                    for (Integer eachProductId : ((Pack) product).getPackageList()) {
                        String name = ((Product)productMainMap.returnProduct(eachProductId)).getName();
                        System.out.println("Nombre: " + name + " Id: " + eachProductId);
                    }

                }

                if (UtilConsole.yesOrNo("Mostrar lista de todos los productos disponibles?")) {
                    productMainMap.showProducts();
                }

                product = PackDAO.addProductsToPack(((Pack) product));


                System.out.print("Porcentaje de descuento: ");
                ((Pack) product).setDiscountPercentage(UtilConsole.inputFloat());

            }

            if (productMainMap.deleteProduct(productId)) {

                if (productMainMap.save(product)) {
                    System.out.println("El " + typeOf + " " + product.getName() + " con id " + product.getId() + " ha sido modificado");
                } else {
                    System.err.println("Ha ocurrido un error modificando el " + typeOf);
                }

            } else {
                System.err.println("Ha ocurrido un error modificando el " + typeOf);
            }

        } else {
            System.err.println("No existe ningun producto con el id " + productId);
        }

        if (UtilConsole.yesOrNo("Desea modificar otro producto?")) {
            modifyProduct();
        } else {
            mainSwitch(mainMenu());
        }

    }

    // CASE 4 - PACKS & PRODUCTS

    private static void deleteProduct() {

        System.out.print("Id del producto a borrar: ");
        int productId = UtilConsole.inputInt();

        if (productMainMap.deleteProduct(productId)) {
            System.out.println("Producto eliminado satisfactoriamente");
        } else {
            System.err.println("No existe ningun producto con el id " + productId);
        }

        if (UtilConsole.yesOrNo("Deseas eliminar algun producto mas?")) {
            deleteProduct();
        } else {
            mainSwitch(mainMenu());
        }

    }

    // CASE 5 - PACKS & PRODUCTS

    private static void showProductMapList() {

        System.out.println("Total productos añadidos: (" + productMainMap.totalProducts() + ") ");

        System.out.println("-------------------------------------");

        for (int i = 1; i <= productMainMap.totalProducts(); i++) {

            System.out.println(productMainMap.returnProduct(i).toString());

            try {

                if (((Pack) productMainMap.returnProduct(i)) instanceof Pack) {

                    System.out.println(((Product)productMainMap.returnProduct(i)).getName() + " es tipo pack y contiene los siguentes productos:");

                    for (Integer eachProductId : ((Pack) productMainMap.returnProduct(i)).getPackageList()) {

                        System.out.println(productMainMap.returnProduct(eachProductId).toString());

                    }

                }

            } catch (Exception e) {

            }

            System.out.println("-------------------------------------");

        }

        if (UtilConsole.yesOrNo("Quieres volver a listar todos los productos?")) {
            showProductMapList();
        } else {
            mainSwitch(mainMenu());
        }

    }

    /* // // // CUSTOMER - SWITCH & MENU // // // */

    private static int customerMenu() {

        String palabra = "cliente";

        System.out.println("1 - Añadir " + palabra);
        System.out.println("2 - Buscar " + palabra);
        System.out.println("3 - Modificar " + palabra);
        System.out.println("4 - Borrar " + palabra);
        System.out.println("5 - Mostrar " + palabra + "s");
        System.out.println("0 - Volver al menú principal");
        System.out.println();
        System.out.print("Selecciona una opción: ");

        int option = UtilConsole.inputInt();

        return option;

    }

    private static void customerSwitch(int userOption) {

        Customer customer = new Customer();

        switch (userOption) {
            case 1:
                addPersona(customer);
                break;
            case 2:
                findPersona(customer);
                break;
            case 3:
                modifyPersona(customer);
                break;
            case 4:
                deletePersona(customer);
                break;
            case 5:
                break;
            case 0:
                break;
            default:
                productSwitch(productMenu());
                ;
        }

    }

    /* // // // CUSTOMER - SWITCH & MENU // // // */

    private static int supplierMenu() {

        String palabra = "proveedor";

        System.out.println("1 - Añadir " + palabra);
        System.out.println("2 - Buscar " + palabra);
        System.out.println("3 - Modificar " + palabra);
        System.out.println("4 - Borrar " + palabra);
        System.out.println("5 - Mostrar " + palabra + "es");
        System.out.println("0 - Volver al menú principal");
        System.out.println();
        System.out.print("Selecciona una opción: ");

        int option = UtilConsole.inputInt();

        return option;

    }

    private static void supplierSwitch(int userOption) {

        Supplier supplier = new Supplier();

        switch (userOption) {
            case 1:
                addPersona(supplier);
                break;
            case 2:
                findPersona(supplier);
                break;
            case 3:
                modifyPersona(supplier);
                break;
            case 4:
                deletePersona(supplier);
                break;
            case 5:
                showPersonaMapList(supplier);
                break;
            case 0:
                break;
            default:
                productSwitch(productMenu());
                ;
        }

    }

    // PERSONA METHODS

    // CASE 1 - CUSTOMER & SUPPLIER

    public static void addPersona(Persona persona) {

        String typeOf = "";
        boolean success = false;

        if (persona instanceof Customer) typeOf = "cliente";
        if (persona instanceof Supplier) typeOf = "proveedor";

        System.out.print("Nombre del " + typeOf + ": ");
        persona.setName(UtilConsole.inputString());

        System.out.print("Apellido del " + typeOf + ": ");
        persona.setSurname(UtilConsole.inputString());

        persona.setId(UtilConsole.inputDNI("DNI del " + typeOf + ": ").toUpperCase());

        persona.setBirthDate(UtilConsole.inputDate("Fecha de nacimiento del " + typeOf + ": "));

        persona.setPhone(UtilConsole.inputTlf("Teléfono del " + typeOf + ": "));

        persona.setEmail(UtilConsole.inputEmail("Email del " + typeOf + ": "));

        System.out.println("Dirección del " + typeOf + ": ");
        persona.setAddress(UtilConsole.inputCompleteDireccion());

        if (persona instanceof Customer) {

            ((Customer) persona).setNewsLetter(UtilConsole.yesOrNo("Suscripción al boletin"));

            if (customerMainMap.save(((Customer) persona))) success = true;

        }

        if (persona instanceof Supplier) {

            System.out.print("Porcentaje de descuento: ");
            ((Supplier) persona).setCashDiscount(UtilConsole.inputDouble());

            if (supplierMainMap.save(((Supplier) persona))) success = true;

        }

        if (success) {
            System.out.println("El " + typeOf + " ha sido añadido correctamente");
        } else {
            System.err.println("Ha ocurrido un error añadiendo el " + typeOf);
        }

        if (UtilConsole.yesOrNo("Quieres volver a añadir un " + typeOf)) {
            addPersona(persona);
        } else {
            mainSwitch(mainMenu());
        }

    }

    private static void findPersona(Persona persona) {

        System.out.println("Hay un total de (" + customerMainMap.totalCustomers() + ") clientes y (" + supplierMainMap.totalSuppliers() + ") proveedores");

        String personaId = UtilConsole.inputDNI("Indica el DNI: ").toUpperCase().trim();

        if (customerMainMap.existsCustomer(personaId)) {
            persona = (Customer) customerMainMap.returnCustomer(personaId);
        } else if (supplierMainMap.existsSupplier(personaId)) {
            persona = (Supplier) supplierMainMap.returnSupplier(personaId);
        } else {
            System.err.print("No existe este DNI en la base de datos");
        }

        System.out.println(persona.toString());

        if (UtilConsole.yesOrNo("Quieres volver a buscar a alguien mas?")) {
            findPersona(persona);
        } else {
            mainSwitch(mainMenu());
        }

    }

    private static void modifyPersona(Persona persona) {

        boolean success = false;

        String personaId = UtilConsole.inputDNI("Introduce el DNI: ");

        if (persona instanceof Customer) persona = (Customer) customerMainMap.returnCustomer(personaId);
        if (persona instanceof Supplier) persona = (Supplier) supplierMainMap.returnSupplier(personaId);

        System.out.println("Datos actuales:");
        System.out.println(persona);
        System.out.println();

        System.out.print("[ACTUAL - " + persona.getName() + "] Nombre: ");
        persona.setName(UtilConsole.inputString());

        System.out.print("[ACTUAL - " + persona.getSurname() + "] Apellido: ");
        persona.setSurname(UtilConsole.inputString());

        persona.setId(UtilConsole.inputDNI("[ACTUAL - " + persona.getId() + "] DNI: ").toUpperCase());

        persona.setBirthDate(UtilConsole.inputDate("[ACTUAL - " + persona.getBirthDate() + "] FECHA NAC: "));

        persona.setPhone(UtilConsole.inputTlf("[ACTUAL - " + persona.getPhone() + "] TELF: "));

        persona.setEmail(UtilConsole.inputEmail("[ACTUAL - " + persona.getEmail() + "] MAIL: "));

        System.out.println("[DIRECCIÓN ACTUAL]");
        System.out.println(persona.getAddress().toString());
        System.out.println();

        System.out.println("Nueva direccón: ");
        persona.setAddress(UtilConsole.inputCompleteDireccion());

        if (persona instanceof Customer) {

            String isBoletin = "NO";

            if (((Customer) persona).isNewsLetter()) isBoletin = "SI";

            ((Customer) persona).setNewsLetter(UtilConsole.yesOrNo("[ ACTUAL - " + isBoletin + "] BOLETÍN: "));

            if (customerMainMap.deleteCustomer(personaId)) {
                if (customerMainMap.save(((Customer) persona))) success = true;
            }

        }

        if (persona instanceof Supplier) {

            System.out.print("[ ACTUAL - " + ((Supplier) persona).getCashDiscount() + "%] DESC.PP: ");
            ((Supplier) persona).setCashDiscount(UtilConsole.inputDouble());

            if (supplierMainMap.deleteSupplier(personaId)) {
                if (supplierMainMap.save(((Supplier) persona))) success = true;
            }

        }

        if (success) {
            System.out.println("Los datos se han modificado y guardado con éxito");
        } else {
            System.err.println("Ha ocurrido un error guardando la modificación");
        }

        if (UtilConsole.yesOrNo("Quieres volver a realizar una modificación?")) {
            modifyPersona(persona);
        } else {
            mainSwitch(mainMenu());
        }

    }

    private static void deletePersona(Persona persona) {

        String personaId = UtilConsole.inputDNI("Indica el DNI: ").toUpperCase().trim();
        String deletedName = "";
        boolean success = false;

        if (persona instanceof Customer) {

            if (customerMainMap.existsCustomer(personaId)) {

                deletedName = ((Customer)customerMainMap.returnCustomer(personaId)).getName();

                if (UtilConsole.yesOrNo("Quieres borrar a " + deletedName + "?")) {
                    if (customerMainMap.deleteCustomer(personaId)) success = true;
                }

            } else {
                System.out.println("No existe ningun cliente con el DNI " + personaId);
            }

        }

        if (persona instanceof Supplier) {

            if (supplierMainMap.existsSupplier(personaId)) {

                deletedName = ((Supplier)supplierMainMap.returnSupplier(personaId)).getName();

                if (UtilConsole.yesOrNo("Quieres borrar a " + deletedName + "?")) {
                    if (supplierMainMap.deleteSupplier(personaId)) success = true;
                }

            } else {
                System.out.println("No existe ningun proveedor con el DNI " + personaId);
            }

        }

        if (success) {
            System.out.println("La entrada de " + deletedName + " ha sido eliminada de la BBDD");
        }

        if (UtilConsole.yesOrNo("Quieres eliminar alguna entrada mas de la BBDD?")) {
            deletePersona(persona);
        } else {
            mainSwitch(mainMenu());
        }

    }

    private static void showPersonaMapList(Persona persona){

        if (persona instanceof Customer) customerMainMap.showCustomers();
        if (persona instanceof Supplier) supplierMainMap.showSuppliers();

        if (UtilConsole.yesOrNo("Quieres volver a listar?")) {
            showPersonaMapList(persona);
        } else {
            mainSwitch(mainMenu());
        }

    }


}
