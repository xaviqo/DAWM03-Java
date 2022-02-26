package agenda;

public class Direccion {

    private String poblacion;
    private String provincia;
    private String cp;
    private String domicilio;

    public String getPoblacion() {
        return this.poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return this.provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCp() {
        return this.cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getDomicilio() {
        return this.domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Direccion(String poblacion, String provincia, String cp, String domicilio) {
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.cp = cp;
        this.domicilio = domicilio;
    }
    
    @Override
    public String toString() {
        return "{" +
                " poblacion='" + getPoblacion() + "'" +
                ", provincia='" + getProvincia() + "'" +
                ", cp='" + getCp() + "'" +
                ", domicilio='" + getDomicilio() + "'" +
                "}";
    }

}
