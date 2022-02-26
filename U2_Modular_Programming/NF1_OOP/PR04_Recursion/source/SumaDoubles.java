package recursividad;

public class SumaDoubles {

    private static int limit = -1;
    
    public static void main(String[] args) {
        
        if (args.length > 30 || args.length <= 1) {
            System.out.println("Mínimo 1 número y máximo 30");
        } else {
           limit = args.length;
           System.out.println("El resultado es: " + suma(args, limit));
        }

    }

    private static double suma(String[] args, int limit){

        limit = limit-1;
        return Integer.parseInt(args[limit]) + suma(args, limit);
    }
}
