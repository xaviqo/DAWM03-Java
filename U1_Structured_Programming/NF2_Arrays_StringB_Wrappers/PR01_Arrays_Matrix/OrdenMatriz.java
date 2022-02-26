import java.util.Arrays;
import java.util.Random;

public class OrdenMatriz {
    public static void main(String[] args) {
        // utiles

        // Scanner kbd = new Scanner(System.in);
        Random rnd = new Random();

        // int[][] numbers {{1,2,3},{4,5,6},{7,8,9}};

        // vars
        int[][] numbers = new int[3][3];
        int min = 0;
        int max = 0;

        // input random numeros
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                numbers[i][j] = rnd.nextInt(20);
            }
        }

        // show arrays
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(Arrays.toString(numbers[i]));
        }

        // output min & max number
        for (int i = 0; i < numbers.length; i++) {

            min = 999;
            max = 0;

            for (int j = 0; j < numbers[i].length; j++) {

                if (numbers[i][j] > max) {
                    max = numbers[i][j];
                } else if (numbers[i][j] < min) {
                    min = numbers[i][j];
                }

            }
            // syso
            System.out.println("De numbers[" + i + "] el num max es: " + max);
            System.out.println("De numbers[" + i + "] el num min es: " + min);
        }

    }
}
