import java.util.HashMap;

public class Inicio {

    public static HashMap<Integer, Libro> biblioteca = new HashMap<>(); //Hashmap de libros

    public static void main(String[] args) {

        while (true) {

        UtilConsole.clean();

        ///// M E N Ú /////////////////////////////////
        
        System.out.println();
        System.out.println("##################");
        System.out.println(" GESTOR DE LIBROS");
        System.out.println("##################");
        System.out.println();
        System.out.println("1 - Añadir libros");
        System.out.println("2 - Añadir editor");
        System.out.println("3 - Añadir categoría");
        System.out.println("4 - Buscar DNI de editor");
        System.out.println("5 - Buscar libros por editor");
        System.out.println("6 - Buscar libros por categoría");
        System.out.println("0 - Salir");
        System.out.println();
        System.out.print("SELECCIONA UNA OPCION ");

        ///////////////////////////////////////////////

            switch (UtilConsole.inputInt()) {

                case 1:
                    UtilConsole.clean();
                    Libro.anadir();
                    UtilConsole.continuar();
                    break;
                case 2:
                    UtilConsole.clean();
                    Editor.anadirEditor(
                        UtilConsole.inputString("Nombre del editor")
                        );
                    UtilConsole.continuar();
                    break;
                case 3:
                    UtilConsole.clean();
                    Categoria.anadirCategoria(
                        UtilConsole.inputString("Nombre de la categoría")
                        );
                    UtilConsole.continuar();
                    break;
                case 4:
                    UtilConsole.clean();
                    System.out.print("Nombre del editor: ");
                    System.out.println(
                        "DNI: "+Editor.buscarDniEditor(
                            UtilConsole.inputString()
                            ));
                    UtilConsole.continuar();
                    break;
                case 5:
                    UtilConsole.clean();
                    Editor.buscarLibrosEditor(
                        UtilConsole.inputString("Nombre del editor")
                        );
                    UtilConsole.continuar();
                    break;
                case 6:
                    UtilConsole.clean();
                    Categoria.buscarLibrosCategoria(
                        UtilConsole.inputString("Categoría")
                        );
                    UtilConsole.continuar();
                    break;
                default:
                    UtilConsole.clean();
                    UtilConsole.continuar();
                    break;

            }

        }

    }
    
}
