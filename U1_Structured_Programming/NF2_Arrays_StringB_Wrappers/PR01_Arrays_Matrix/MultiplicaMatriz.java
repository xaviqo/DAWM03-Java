import java.util.Arrays;
import java.util.Random;

public class MultiplicaMatriz {
    public static void main(String[] args) {

        // utiles
        // Scanner kbd = new Scanner(System.in);
        Random rnd = new Random();

        // vars
        int[][] matrix1 = new int[3][3];
        int[][] matrix2 = new int[3][3];
        int[][] matrix3 = new int[3][3];
        int pos = 0;

        // int[][] matrix1 = { { 3, 12, 4 }, { 5, 6, 8 }, { 1, 0, 2 } };
        // int[][] matrix2 = { { 7, 3, 8 }, { 11, 9, 5 }, { 6, 8, 4 } };

        // input random numeros

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1.length; j++) {
                matrix1[i][j] = rnd.nextInt(20);
                matrix2[i][j] = rnd.nextInt(20);
            }
        }

        // syso text
        System.out.println("First Matrix:");

        // show matrix
        for (int index = 0; index < 1; index++) {

            for (int i = 0; i < matrix1.length * 2; i++) {
                if (i < 3) {
                    System.out.println(Arrays.toString(matrix1[i]));
                } else {
                    // show matrix2
                    if (i == 3) {
                        System.out.println("");
                        System.out.println("Second Matrix:");
                    }
                    System.out.println(Arrays.toString(matrix2[pos]));
                    pos++;
                }

            }
        }

        // syso text
        System.out.println("");
        System.out.println("New Matrix:");

        // calc
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                for (int k = 0; k < matrix2[i].length; k++) {

                    matrix3[i][j] = matrix3[i][j] + matrix1[i][k] * matrix2[k][j];
                }
            }
            System.out.println(Arrays.toString(matrix3[i]));
        }
    }
}
