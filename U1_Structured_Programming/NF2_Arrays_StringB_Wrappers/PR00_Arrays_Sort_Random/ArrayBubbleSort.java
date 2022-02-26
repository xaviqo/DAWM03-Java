import java.util.Arrays;
import java.util.Random;

public class ArrayBubbleSort {
    public static void main(String[] args) {
        
        int temp = 0;
        int arrayLength = 10;
        int[] array = new int[arrayLength];

        Random rnd = new Random();

        for (int index = 0; index < array.length; index++) {
            array[index] = rnd.nextInt(500 + 1)-250;
        }

        for (int i = 0; i < array.length -1; i++) {

            for (int j = 0; j < array.length -i -1; j++) {

                if (array[j]>array[j+1]) {
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;

                }
            }
        }
        System.out.println(Arrays.toString(array));

    }
}
