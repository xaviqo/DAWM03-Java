import java.util.Random;
import java.util.Scanner;

public class ArrayRnd {
    public static void main(String[] args) {
        //Scanner y Random
        Scanner kbd = new Scanner(System.in);
        Random rnd = new Random();

        //vars
        int arrayLong = 0;

        //introducir numero
        do {
            System.out.println("Cuantos números aleatorios quieres?");
            arrayLong = kbd.nextInt();
            System.out.println(" ");
    
            if (arrayLong>0 && arrayLong<101) {
    
                int[] arrayNums = new int[arrayLong];
    
                for (int i = 0; i < arrayNums.length; i++) {
                    arrayNums[i] = rnd.nextInt(100+1);
                    System.out.print(arrayNums[i]+" ");
                }
                System.out.println();
                break;
            }
        } while (true);

        kbd.close();

        }
}