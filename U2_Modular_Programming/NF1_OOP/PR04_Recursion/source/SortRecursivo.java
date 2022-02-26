package recursividad;

import java.util.Arrays;
import java.util.Random;

public class SortRecursivo {
    public static void main(String[] args) {

        int arrayLength = 9999;
        int[] array = new int[arrayLength];
    
        Random rnd = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(500 + 1)-250;
        }
    
        sort(array, array.length-1);
        System.out.println(Arrays.toString(array));

    }

    public static void sort(int[] array,int size){

        int aux;

        if (size == 1) return;

        for (int i = 0; i < size; i++) {

            if (array[i]>array[i+1]) {

                aux = array[i+1];
                array[i+1] = array[i];
                array[i] = aux;
            }
            
        }

        sort(array,size-1);

    }

}
