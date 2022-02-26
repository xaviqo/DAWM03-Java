import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Agenda {

    // utiles
    static Scanner kbd = new Scanner(System.in);

    // vars
    static int option = 0;
    static Integer aux = 0;
    static String auxStr = "";

    // list
    public static ArrayList<Integer> llistaTelefons = new ArrayList<>();

    // MENU
    public static void menu(boolean clear, String ultimaAccio) {

        if (clear)
            System.out.print("\033[H\033[2J"); // limpiar terminal

        System.out.println("   ## Selecciona una opció del menú ##");
        System.out.println();
        System.out.println("[1] - Inserir un nou telèfon a la llista.");
        System.out.println("[2] - Imprimir la llista ordenada.");
        System.out.println("[3] - Mostrar la posició de la llista.");
        System.out.println("[4] - Buscar el número a la llista.");
        System.out.println("[5] - Esborrar un número de la llista.");
        System.out.println("[0] - Sortir.");
        System.out.println();
        System.out.println(ultimaAccio);
        System.out.println();
        System.out.print("Opció: ");

        option = kbd.nextInt();
        if (option < Integer.MAX_VALUE) {
            System.out.print("\033[H\033[2J"); // limpia terminal
            opcioMenu(option);
        }
    }

    // COMPRUEBA OPCION
    public static void opcioMenu(int opc) {

        switch (opc) {
        case 1:
            afegirTelefon(false, 0);
            break;
        case 2:
            imprimirLlista();
            break;
        case 3:
            mostrarPosicio();
            break;
        case 4:
            buscarNumero();
            break;
        case 5:
            esborrarNumero();
            break;
        case 0:
            System.exit(0);
            break;
        default:
            option = 9;
            menu(true, "Opció no vàlida! Intenta-ho de nou...");
            break;
        }

    }

    public static void continuar(int repetir, String msg, String ultimaAccio) {

        //auxStr = "";

        System.out.print("Continuar? R: " + msg + " | M: Menú | S: Sortir ): ");

        auxStr = kbd.next();

        if (auxStr.toUpperCase().equals("R")) {
            opcioMenu(repetir);
        } else if (auxStr.toUpperCase().equals("M")) {
            menu(true, ultimaAccio);
        } else if (auxStr.toUpperCase().equals("S")) {
            opcioMenu(9);
        } else {
            continuar(repetir, msg, ultimaAccio);
        }
    }

    public static void afegirTelefon(boolean tenimTlf, int tlf) {

        if (tenimTlf == true) {
            llistaTelefons.add(tlf);
            menu(false, "");
        } else {

            System.out.println("Numero a afegir: ");
            aux = kbd.nextInt();
            llistaTelefons.add(aux);

            continuar(1, "Afegir un altre telèfon", "Telèfon afegit");
        }
    }

    public static void imprimirLlista() {

        Collections.sort(llistaTelefons);

        System.out.println("- Llistat de telèfons:");
        System.out.println();

        for (int tlf : llistaTelefons) {
            System.out.println(tlf);
            aux = llistaTelefons.size();
        }

        System.out.println();
        System.out.println("Hi ha un total de " + aux + " telèfons.");

        continuar(2, "Imprimir llistat", "Hi ha un total de " + aux + " telèfons.");

    }

    public static void mostrarPosicio() {

        if (llistaTelefons.size() > 0) {
            System.out.println("Quin telèfon vols comprovar? ");
            aux = kbd.nextInt();

            if (llistaTelefons.indexOf(aux) == -1) {
                System.out.println("Telèfon no trobat!");
                System.out.println();
                System.out.println("Vols afegir el telèfon a la llista? (S/N)");
                auxStr = kbd.next();

                if (auxStr.toUpperCase().equals("S")) {
                    afegirTelefon(true, aux);
                } else {
                    continuar(3, "Buscar posició", "Telèfon no trobat");
                }
                
            } else {
                System.out.println("Posició del telèfon: " + llistaTelefons.indexOf(aux));
                continuar(3, "Buscar posició", "Telèfon trobat a la posició " + llistaTelefons.indexOf(aux));
            }
        } else {
            System.out.println("No hi ha telèfons a la llista");
            continuar(3, "Buscar posició", "No hi ha telèfons a la llista");
        }

    }

    public static void buscarNumero() {

        if (llistaTelefons.size() > 0) {

            System.out.println("Quin telèfon estas buscant? ");
            aux = kbd.nextInt();
            if (llistaTelefons.contains(aux)) {
                System.out.println("El telèfon " + aux + " ja existeix");
                auxStr = "El telèfon " + aux + " ja existeix";
            } else {
                System.out.println("El telèfon " + aux + " no existeix");
                System.out.println("Vols afegir el telèfon a la llista? (S/N)");
                auxStr = kbd.nextLine();
                if (auxStr.toUpperCase().equals("S")) {
                    afegirTelefon(true, aux);
                } else {
                    continuar(4, "Buscar telèfon", "El telèfon " + aux + " no existeix");
                }
            }
        } else {
            System.out.println("No hi ha telèfons a la llista");
        }

        // TODO dar opcionn de añadir
        continuar(4, "Buscar telèfon", auxStr);

    }

    public static void esborrarNumero() {

        System.out.println("Quin telèfon vols borrar? ");
        aux = kbd.nextInt();

        if (llistaTelefons.remove(aux)) {
            auxStr = "S'ha esborrat el telèfon " + aux;
            System.out.println(auxStr);
            System.out.println();
        } else {
            System.out.println("El telèfon no existeix!");
            auxStr = "El telèfon " + aux + " no s'ha trobat";
            System.out.println(auxStr);
            System.out.println();
        }

        continuar(5, "Esborrar telèfon", auxStr);
    }

    public static void main(String[] args) {

        menu(true, "Benvingut al llistat telefònic de Xavier Quiñones");

    }
}