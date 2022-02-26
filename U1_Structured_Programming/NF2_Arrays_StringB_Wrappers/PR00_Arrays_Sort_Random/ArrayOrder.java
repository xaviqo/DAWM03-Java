import java.util.Arrays;
import java.util.Random;

public class ArrayOrder {
    public static void main(String[] args) {

        // utiles
        Random rnd = new Random();
        // vars
        int temp = 0;

        int[] array = new int[5];

        for (int index = 0; index < array.length; index++) {
            array[index] = rnd.nextInt(500 + 1)-250;
            // System.out.println(array[index]);
        }

        for (int main = 0; main < array.length-1; main++) {
            for (int pos = main + 1; pos < array.length; pos++) {

                if (array[pos] < array[main]) {
                    temp = array[main];
                    array[main] = array[pos];
                    array[pos] = temp;
                }
            }
            // System.out.println(array[main] + " ");
        }
        System.out.println(Arrays.toString(array));
    }
}