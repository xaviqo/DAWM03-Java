package agenda;

import java.time.LocalDate;
import java.util.HashMap;

public class Inicio {

    private static int id = 0;
    private static String dni = "";
    private static String nombre = "";
    private static String apellidos = "";
    private static LocalDate fechaNacimiento = null;
    private static String email = "";
    private static String telefono = "";
    private static String poblacion = "";
    private static String provincia = "";
    private static String cp = "";
    private static String domicilio = "";
    private static HashMap<Integer, Persona> agenda = new HashMap<>();
    private static Persona p1, p2;

    public static void main(String[] args) {

        Direccion direccion;

        Persona p;

        int opcion = -1;

        do {

            System.out.println("0 - Salir");
            System.out.println("1 - Añadir persona");
            System.out.println("2 - Imprimir persona");
            System.out.println("3 - Modificar persona");
            System.out.println("4 - Eliminar persona");
            System.out.println("5 - Mostrar toda la lista");
            System.out.println("6 - Diferencia de edad");
            System.out.println("7 - Cuantos registros hay en la agenda");
            System.out.print("Selecciona una opcion: ");

            opcion = UtilConsole.demanarInt();

            switch (opcion) {

                case 1:

                    id++;
                    System.out.print("DNI: ");
                    dni = UtilConsole.demanarDNI();
                    System.out.print("Nombre: ");
                    nombre = UtilConsole.demanarString();
                    System.out.print("Apellidos: ");
                    apellidos = UtilConsole.demanarString();
                    System.out.println("Fecha nacimiento (dd/MM/yyyy): ");
                    fechaNacimiento = UtilConsole.demanarDate();
                    System.out.print("Email: ");
                    email = nombre = UtilConsole.demanarString();
                    System.out.print("Telèfono: ");
                    telefono = UtilConsole.demanarString();
                    System.out.print("Población: ");
                    poblacion = UtilConsole.demanarString();
                    System.out.print("Provincia: ");
                    provincia = UtilConsole.demanarString();
                    System.out.print("CP: ");
                    cp = UtilConsole.demanarString();
                    System.out.println("Domicilio: ");
                    domicilio = UtilConsole.demanarString();


                    direccion = new Direccion(poblacion, provincia, cp, domicilio);

                    p = new Persona(id, dni, nombre, apellidos, fechaNacimiento, email, telefono, direccion);

                    agenda.put(p.getIdpersona(), p);
                    System.out.println("Persona añadida con el id "+id+".");

                    break;

                case 2:

                    System.out.println("ID: ");
                    id = UtilConsole.demanarInt();
                    if (agenda.containsKey(id)) {
                        System.out.println(agenda.get(id));
                    } else {
                        System.out.println("No existe");
                    }

                    break;

                case 3:

                    System.out.println("ID a modificar: ");
                    id = UtilConsole.demanarInt();

                    if (agenda.containsKey(id)) {

                        p = agenda.get(id);

                        System.out.print("Nombre actual: " + p.getNombre() + " | Nombre nuevo: ");
                        p.setNombre(UtilConsole.demanarString());

                        System.out.print("Apellido actual: " + p.getApellidos() + " | Apellido nuevo: ");
                        p.setApellidos(UtilConsole.demanarString());

                        System.out.print("Teléfono actual: " + p.getTelefono() + " | Teléfono nuevo: ");
                        p.setTelefono(UtilConsole.demanarString());

                        System.out.print("Email actual: " + p.getEmail() + " | Email nuevo: ");
                        p.setEmail(UtilConsole.demanarEmail());

                        System.out.print("Fecha actual: " + p.getFechaNacimiento() + " | Nueva fecha: ");
                        p.setFechaNacimiento(UtilConsole.demanarDate());

                        direccion = p.getDireccion();

                        System.out.print("Población actual: " + direccion.getPoblacion() + " | Nueva población: ");
                        direccion.setPoblacion(UtilConsole.demanarString());

                        System.out.print("Provincia actual: " + direccion.getProvincia() + " | Nueva provincia: ");
                        direccion.setProvincia(provincia);

                        System.out.print("CP actual: " + direccion.getCp() + " | CP Nuevo: ");
                        direccion.setCp(UtilConsole.demanarString());

                        System.out.print("Domicilio actual: " + direccion.getDomicilio() + " | Domicilio Nuevo: ");
                        direccion.setDomicilio(UtilConsole.demanarString());

                        p = new Persona(p.getIdpersona(), dni, nombre, apellidos, fechaNacimiento, email, telefono, direccion);

                        agenda.remove(p.getIdpersona());

                        agenda.put(p.getIdpersona(), p);

                        System.out.print("Se ha modificado con exito el usuario con ID: " + p.getIdpersona());

                        break;

                    } else {

                        System.out.println("El ID no existe!");
                        break;

                    }
                case 4:

                    System.out.println("ID a eliminar: ");
                    id = UtilConsole.demanarInt();

                    if (agenda.containsKey(id)) {

                        agenda.remove(id);
                        Persona.restarNumeroPersonas();

                    } else {

                        System.out.println("El ID no existe!");
                        break;
                    }
                    
                    Persona.restarNumeroPersonas();

                    break;

                case 5:

                    if (Persona.numeroPersonas < 1){

                        System.out.println("No hay personas registradas");
                        break;

                    } else {

                        System.out.println("Hay un total de "+ Persona.getNumeroPersonas() +" personas registradas.");

                        mostrarPersonas();

                    }

                    break;
                
                case 6:

                System.out.println("ID de la primera persona: ");
                id = UtilConsole.demanarInt();                
                
                if (agenda.containsKey(id)){

                    p1 = agenda.get(id);

                } else {
                    
                    System.out.println("Persona "+id+" no encontrada");
                }

                System.out.println("ID de la segunda persona: ");
                id = UtilConsole.demanarInt();

                if (agenda.containsKey(id)){
                    

                    p2 = agenda.get(id);

                } else {
                    
                    System.out.println("Persona "+id+" no encontrada");
                }

                if (p1 != null && p2 != null) {

                    long diferencia = Persona.getDiferencia(p1,p2);
                    System.out.println(p1.getNombre()+" y "+p2.getNombre()+" se llevan "+diferencia+" años.");

                }
                
                break;

                case 7:

                System.out.println("Hay "+Persona.numeroPersonas+" personas.");

                break;
                
                default:

                    System.out.println("Hasta pronto!");
                    System.exit(0);
            }

        } while (opcion != 0);
    }

    static private void mostrarPersonas() {

        for (Persona p : agenda.values()) {
            System.out.println(p);
            
        }
    }
}
