package lesson8.homework;

import java.util.Arrays;

public class Arithmetic {
    /*public static void main(String[] args) {
        int[] array1 = {15, 43, 35, 47, 69, 32, 24, 26, 88, 50};
        System.out.println(Arrays.toString(sortAscending(array1)));
        int[] array=((sortAscending(array1)));
        int length=array1.length;
        System.out.println(check(array,length));

    }

    public static int[] sortAscending(int[] array1) {
        Arrays.sort(array1);
        return array1;
    }*/

    public static boolean check(int[] array/*,int length*/) {
        Arrays.sort(array);
        int length= array.length;
        int max = array[length-1];
        int min = array[0];
        if(max+min>100)
        return true;
        else
            return false;

    }
}
