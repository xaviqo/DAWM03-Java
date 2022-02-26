package agenda;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Persona {

    private int idpersona;
    private String dni;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String email;
    private String telefono;
    public static int numeroPersonas;

    private Direccion direccion;

    public Persona(){
        this(0, "", "", "", null, "", "");
        numeroPersonas++;
    }

    public Persona(int idpersona, String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email, String telefono) {
        
        this(idpersona, dni, nombre, apellidos, fechaNacimiento, email, telefono, null);

        numeroPersonas++;
    }


    public Persona(int idpersona, String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email, String telefono, Direccion direccion) {
        this.idpersona = idpersona;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;

        numeroPersonas++;
    }
    
    
    public int getIdpersona() {
        return idpersona;
    }
    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public static int getNumeroPersonas() {
        return numeroPersonas;
    }

    public static void restarNumeroPersonas() {
        numeroPersonas--;
    }
    
    public void getAll() {
        System.out.println(getDni());
        System.out.println(getNombre());
        System.out.println(getApellidos());
        System.out.println(getFechaNacimiento());
        System.out.println(getEmail());
        System.out.println(getTelefono());
    }

    public long getEdad(){

        return ChronoUnit.YEARS.between(this.fechaNacimiento, LocalDate.now());

    }
    public static long getDiferencia(Persona persona1, Persona persona2){

        return ChronoUnit.YEARS.between(persona1.getFechaNacimiento(),persona2.getFechaNacimiento());
    }


    public Direccion getDireccion() {
        return this.direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public boolean isValid(Persona persona){

        if (persona.idpersona == 0) return false;

        if (persona.dni.isEmpty()) return false;

        if (persona.nombre.isEmpty()) return false;

        if (persona.apellidos.isEmpty()) return false;
        
        return true;

    }

    
    @Override
    public String toString() {
        return "Nombre: " + nombre + " Apellido: " + apellidos + " Email: " + email + " Fecha Nac: " + fechaNacimiento + " Tlf: " + telefono + " Edad: " + getEdad() + "Direccion: " + (direccion == null?"":direccion.toString()); //poner direccion haria una llamada al toString de la clase Objeto principal de java, por lo cual tambien funcionaría
    }

    
    
}