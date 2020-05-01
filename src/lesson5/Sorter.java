package lesson5;

import java.util.Arrays;
import java.util.Collections;

public class Sorter {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
        System.out.println(Arrays.toString(sortAscending(array)));
        System.out.println(Arrays.toString(sortDescending(array)));

    }
    //public static int sortAscending(int[] array){

    //}

    public static int[] sortAscending(int[] array) {

        Arrays.sort(array);
        //for(int i = 0; i <  array.length; i++) {
        //  System.out.print(array[i] + " ");

        //}
        return array;

    }

    public static int[] sortDescending(int[] array) {

        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    return array;
    }


}
