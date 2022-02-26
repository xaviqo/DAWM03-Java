import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UtilConsole {

    static Scanner kbd = new Scanner(System.in);

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
                kbd.nextLine();
            }
            
        } while (isInt == false);

        return i;

    }

    public static int inputInt(String text) {

        int i = 0;
        boolean isInt = false;

        do {

            try {

                System.out.println(text+": ");
                i = kbd.nextInt();
                isInt = true;
                kbd.nextLine();
                
            } catch (Exception e) {
    
                System.err.println("Introduce un valor numérico");
                kbd.nextLine();
            }
            
        } while (isInt == false);

        return i;

    }

    public static double inputDouble() {

        double d = 0;
        boolean isDouble = false;

        do {

            try {

                d = kbd.nextDouble();
                isDouble = true;
                kbd.nextLine();
                
            } catch (Exception e) {
    
                System.err.println("Introduce un valor numérico");
                kbd.nextLine();
            }
            
        } while (isDouble == false);

        return d;

    }

    public static double inputDouble(String text) {

        double d = 0;
        boolean isDouble = false;

        do {

            try {

                System.out.println(text+": ");
                d = kbd.nextDouble();
                isDouble = true;
                kbd.nextLine();
                
            } catch (Exception e) {
    
                System.err.println("Introduce un valor numérico");
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
                System.out.println("No válido");
                kbd.nextLine();
            }
            return string;

        } while (!isString);
    }

    public static String inputString(String text) {

        String string = "";
        boolean isString = false;

        do {

            System.out.println(text+": ");
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

    public static String inputDNI(){

        String dni = "";
        boolean dniOK = false;

        do {

            System.out.print("DNI: ");
            dni = inputString().toUpperCase();

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

    public static String inputCP() {

        String cp = "";
        boolean isCP = false;

        do {
            cp = kbd.nextLine();

            if (cp.matches("[0-9]{5}")) {
                isCP = true;
            } else {
                System.out.println("Formato del CP no válido");
                kbd.nextLine();
            }
            return cp;

        } while (!isCP);

    }

    public static String inputTlf() {

        String tlf = "";
        boolean isTlf = false;

        do {
            tlf = kbd.nextLine();

            if (tlf.matches("[0-9]{9}")) {
                isTlf = true;
            } else {
                System.out.println("Formato del Telefono no válido");
                kbd.nextLine();
            }
            return tlf;

        } while (!isTlf);

    }

    public static String demanarEmail(){

        String email = "";

        do {

            email = inputString().toUpperCase();

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
                dataString = inputString();
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



    public static void clean(){

        System.out.print("\033[H\033[2J");

    }

    public static void continuar(){

        System.out.println();
        System.out.print("Volver al menú? (S) - Sí | (N) - Cerrar : ");
        String opcion = UtilConsole.inputString().toUpperCase();

        if (opcion.equals("S") || opcion.isEmpty()){
            return;
        } else if (opcion.equals("N")){
            System.out.println();
            System.out.println("Hasta pronto!");
            System.exit(0);
        } else {
            UtilConsole.clean();
            continuar();
        }
    }


}
