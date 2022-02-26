package agenda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UtilConsole {

    static Scanner kbd = new Scanner(System.in);

    public static int demanarInt() {

        int entero = 0;
        boolean isInteger = false;

        do {

            if (kbd.hasNextInt()) {
                entero = kbd.nextInt();
                isInteger = true;
                kbd.nextLine();
            } else {
                // para saltar el valor introducido que no es entero
                kbd.nextLine();
            }

            return entero;

        } while (!isInteger);

    }

    public static String demanarString() {

        String string = "";
        boolean isString = false;

        do {
            string = kbd.nextLine();

            if (!string.isBlank()) {
                isString = true;
            } else {
                System.out.println("No válido");
                kbd.nextLine();
            }
            return string;

        } while (!isString);
    }

    public static String demanarDNI(){

        String dni = "";
        boolean dniOK = false;

        do {

            dni = demanarString().toUpperCase();

            if (comprobarDNI(dni)){

                dniOK = true;

            } else {

                System.out.println("DNI no válido!");

            }

        } while (!dniOK);

        return dni;
    }

    private static boolean comprobarDNI(String dni) {

        String cadena = "TRWAGMYFPDXBNJZSQVHLCKE";

        if (dni.matches("[0-9]{7,8}[A-Za-z]")) {

            int num = Integer.parseInt(dni.substring(0, 8));

            int mod = num%23;

            if (cadena.charAt(mod) == dni.charAt(dni.length()-1)) {

                return true;

            }

        }

        return false;
    }

    public static String demanarEmail(){

        String email = "";

        do {

            email = demanarString().toUpperCase();

        } while (!comprobarEmail(email));

        return email;
    }

    private static Boolean comprobarEmail(String email){

        if (email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")){
            return true;
        }
        return false;
    }

    public static LocalDate demanarDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy");
        String dataString = "";
        LocalDate data = null;
        boolean isDate = false;

        do{
            if (kbd.hasNext()) {
                dataString = demanarString();
                try {
                    data = LocalDate.parse(dataString, dtf);
                    isDate = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Fecha incorrecta");
                }
            } else {
                kbd.next();
            }
        } while (!isDate);

        return data;
    }


}
