package controler;

import model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public abstract class UtilConsole {

    private static Scanner kbd = new Scanner(System.in);

    public static Boolean yesOrNo(String showMsg){

        String userOption = "";
        String yes = "S"; String no = "N";
        String yesOrNo = " ("+yes+"/"+no+"): ";
        String error = "Opción no válida";

        System.out.println(showMsg+yesOrNo);
        userOption = UtilConsole.inputString().trim().toUpperCase();

        if (userOption.equals(yes) || userOption.isEmpty()){
            return true;
        } else if (userOption.equals(no)) {
            return false;
        } else {
            System.err.println(error);
            yesOrNo(showMsg);
        }

        return null;

    }

    public static int inputInt() {

        int i = 0;
        boolean isInt = false;

        do {

            try {
                i = kbd.nextInt();
                isInt = true;
                kbd.nextLine();

            } catch (Exception e) {

                System.err.println("Introduce un valor numérico");
                System.out.print("Valor: ");
                kbd.nextLine();
            }

        } while (!isInt);

        return i;

    }

    public static float inputFloat() {

        float f = 0;
        boolean isFloat = false;

        do {

            try {

                f = kbd.nextFloat();
                isFloat = true;
                kbd.nextLine();

            } catch (Exception e) {

                System.err.println("Introduce un valor numérico");
                System.out.print("Valor: ");
                kbd.nextLine();
            }

        } while (isFloat == false);

        return f;

    }

    public static double inputDouble() {

        double d = 0;
        boolean isDouble = false;

        do {

            try {

                d = kbd.nextFloat();
                isDouble = true;
                kbd.nextLine();

            } catch (Exception e) {

                System.err.println("Introduce un valor numérico");
                System.out.print("Valor: ");
                kbd.nextLine();
            }

        } while (isDouble == false);

        return d;

    }

    public static String inputString() {

        String string = "";
        boolean isString = false;

        do {
            string = kbd.nextLine();

            if (!string.isBlank()) {
                isString = true;
            } else {
                System.err.println("No válido");
                System.out.print("Valor: ");
                kbd.nextLine();
            }
            return string;

        } while (!isString);

    }

    public static String inputDireccion() {

        String dir = "";
        boolean isDir = false;

        do {
            dir = kbd.nextLine();

            if (!dir.isBlank()) {
                isDir = true;
            } else {
                System.err.println("Domicilio no válido");
                System.out.print("Domicilio: ");
                kbd.nextLine();
            }
            return dir;

        } while (!isDir);

    }

    public static int inputCP() {

        boolean isCP = false;

        String cp = "";
        int intCP = 0;

        do {

            cp = UtilConsole.inputString();

            intCP = Integer.parseInt(cp);

            if (cp.matches("[0-9]{5}") && intCP > 1000 && intCP < 52999) {

                isCP = true;

            } else {

                System.err.println("CP no válido");

            }

        } while (!isCP);

        return intCP;

    }

    public static String inputDNI(String msg) {

        String dni = "";
        boolean dniOK = false;

        do {
            System.out.print(msg);
            dni = inputString().toUpperCase();

            if (comprobarDNI(dni)) {

                dniOK = true;

            } else {

                System.err.println("DNI no válido!");
                System.out.println();

            }

        } while (!dniOK);

        return dni;
    }

    private static boolean comprobarDNI(String dni) {

        String cadena = "TRWAGMYFPDXBNJZSQVHLCKE";

        if (dni.matches("[0-9]{7,8}[A-Za-z]")) {

            int num = Integer.parseInt(dni.substring(0, 8));

            int mod = num % 23;

            if (cadena.charAt(mod) == dni.charAt(dni.length() - 1)) {

                return true;

            }

        }

        return false;
    }

    public static Address inputCompleteDireccion() {

        System.out.print("Población: ");
        String poblacion = inputString();

        System.out.print("Provincia: ");
        String provincia = inputString();

        System.out.print("Código Postal: ");
        int cp = inputCP();

        System.out.print("Domicilio: ");
        String domicilio = inputDireccion();

        Address direccion = new Address(poblacion,provincia,domicilio,cp);

        return direccion;
    }

    public static String inputTlf(String msg) {

        String tlf = "";
        boolean isTlf = false;

        do {
            System.out.print(msg);
            tlf = kbd.nextLine();

            if (tlf.matches("[0-9]{9}")) {
                isTlf = true;
            } else {
                System.err.println("Formato del Telefono no válido");
                kbd.nextLine();
            }
            return tlf;

        } while (!isTlf);

    }

    public static String inputEmail(String msg){

        String email = "";

        while (true){

            System.out.print(msg);
            email = UtilConsole.inputString();

            if (comprobarEmail(email)) {
                return email;
            } else {
                System.err.println("Email no válido!");
            }

        }

    }

    private static Boolean comprobarEmail(String email){

        if (email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")){
            return true;
        }
        return false;

    }

    public static LocalDate inputDate(String msg){

        System.out.print(msg);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy");
        String dataString = "";
        LocalDate data = null;
        boolean isDate = false;

        do{
            if (kbd.hasNext()) {
                dataString = inputString();
                try {
                    data = LocalDate.parse(dataString, dtf);
                    isDate = true;
                } catch (DateTimeParseException e) {
                    System.out.println(msg);
                }
            } else {
                kbd.next();
            }
        } while (!isDate);

        return data;
    }

}
