import java.util.Random;
import java.util.Scanner;

public class ArrayMinMax {
    public static void main(String[] args) {

        // utiles
        Random rnd = new Random();
        Scanner kdb = new Scanner(System.in);

        // vars
        int arrayLong = 0;
        int numMax = 0;
        int numMin = 0;
        int[] fullArray;

        do {
            // pedir al usuario
            System.out.print("Largo del array (Min 10): ");
            arrayLong = kdb.nextInt();
            //arrayLong = Integer.parseInt(args[0]);

        } while (arrayLong < 10);

        fullArray = new int[arrayLong];

        numMin = 1000;
        numMax = 0;

        for (int i = 0; i < fullArray.length; i++) {

            fullArray[i] = rnd.nextInt(1000)+1;

            if (fullArray[i] > numMax) {
                numMax = fullArray[i];
            } else if (fullArray[i] < numMin) {
                numMin = fullArray[i];
            }

        }

        System.out.println("El número mas grande ha sido: " + numMax + " el mas pequeño " + numMin);
        kdb.close();

    }
}
