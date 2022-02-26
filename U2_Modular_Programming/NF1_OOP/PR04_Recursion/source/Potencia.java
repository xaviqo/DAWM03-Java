package recursividad;

public class Potencia {
        public static void main(String[] args) {

        if (args.length == 2){
            
            System.out.println(args[0]+" x "+args[1]+" = "+calcular(Double.parseDouble(args[0]), Double.parseDouble(args[1])));;

        } else {
            System.err.println("Son necesarios DOS argumentos!");
        }

    }

    private static double calcular(double base, double n){

        if (n == 1){
            return base;
        } else if (n == 0) {
            return 1;
        } else {
            return base * calcular(base, n-1);
        }


    }
}
