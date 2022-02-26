import java.util.HashMap;

//no se si los id están bien configurados

public class Editor {
    
    private static int idEditor = 0;
    private String nombre = "";
    private String dni = "";

    public static HashMap<String, Editor> editores = new HashMap<>();


    public Editor() {
    }

    public Editor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;

        setIdEditor(++idEditor);
    }

    public int getIdEditor(){
        return idEditor;
    }

    private void setIdEditor(int idEditor){
        Editor.idEditor = idEditor;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public static Editor anadirEditor(String nombre){

        Editor edi;

        if (!editores.containsKey(nombre)){

            String dniEditor = UtilConsole.inputDNI();

            edi = new Editor(nombre,dniEditor);
            editores.put(edi.getNombre(), edi); //Guardar en Hashmap de editores
    
            System.out.println("Nuevo editor añadido: "+edi.getNombre()+" con ID "+edi.getIdEditor());

            return edi;

        } else {

            edi = editores.get(nombre);
            System.out.println("El editor "+edi.getNombre()+" ya existe");

            return edi;

        }

    }

    public static String buscarDniEditor(String nombre){

        Editor editor = new Editor();

        if (editores.containsKey(nombre)) {

            editor = editores.get(nombre);

            return editor.getDni();

        } else {

            return "Editor no encontrado";

        }

    }

    public static void buscarLibrosEditor(String editorBuscado){

        System.out.println();

        for (Libro l: Inicio.biblioteca.values()) {

            Editor editorActual = l.getEditor();

            if (editorBuscado.equals(editorActual.getNombre())){

                System.out.println("El libro "+l.getTitulo()+" ha sido editado por "+editorBuscado);

            }         
        }

        System.out.println();

    }
}
