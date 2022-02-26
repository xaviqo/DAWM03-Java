public class Libro {
    
    public static int idLibro = 0;
    private String titulo = "";
    private String descripcion = "";
    private double precio = 0;
    private Editor editor = null;
    private Categoria categoria = null;


    public Libro() {

        idLibro++;

    }


    public Libro(String titulo, String descripcion, double precio, Editor editor, Categoria categoria) {
        
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.editor = editor;
        this.categoria = categoria;

        idLibro++;
    }


    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Editor getEditor() {
        return this.editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public static void anadir(){

        Libro lib = new Libro();

        System.out.println("ID asignado: "+Libro.idLibro);
        System.out.println();

        System.out.print("Titulo: ");
        lib.setTitulo(UtilConsole.inputString());

        System.out.print("Descripción: ");
        lib.setDescripcion(UtilConsole.inputString());

        System.out.print("Precio: ");
        lib.setPrecio(UtilConsole.inputDouble());

        System.out.print("Nombre del editor: ");
        lib.setEditor(Editor.anadirEditor(UtilConsole.inputString()));

        System.out.print("Categoría: ");
        lib.setCategoria(Categoria.anadirCategoria(UtilConsole.inputString()));

        Inicio.biblioteca.put(Libro.idLibro, lib); //Hashmap con todos los libros (key = id, value = libro)

    }
}
