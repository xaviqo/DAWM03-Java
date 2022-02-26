import java.util.HashMap;

//no se si los id están bien configurados

public class Categoria {
    
    private static int idCategoria = 0;
    private String nombre = "";

    public static HashMap<String, Categoria> categorias= new HashMap<>(); //Hashmap con todas las categorias

    public Categoria() {
    }

    public Categoria(String nombre) {
        this.nombre = nombre;

        setIdCategoria(++idCategoria);
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    private void setIdCategoria(int idCategoria){
        Categoria.idCategoria = idCategoria;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static Categoria anadirCategoria(String nombre){

        Categoria cat;

        if (!categorias.containsKey(nombre)){

            cat = new Categoria(nombre);
            Categoria.categorias.put(cat.getNombre(), cat); //Guardar en Hashmap de categorías

            System.out.println("Nueva categoría añadida: "+cat.getNombre()+" con ID "+cat.getIdCategoria());

            return cat;

        } else {

            cat = categorias.get(nombre);
            System.out.println("La categoría "+cat.getNombre()+" ya existe");

            return cat;

        }

    }

    public static void buscarLibrosCategoria(String categoriaBuscada){

        System.out.println();

        for (Libro l: Inicio.biblioteca.values()) {

            Categoria categoriaActual = l.getCategoria();

            if (categoriaBuscada.equals(categoriaActual.getNombre())){

                System.out.println("El libro "+l.getTitulo()+" está en la categoría "+categoriaBuscada);

            }         
        }

        System.out.println();

    }
}