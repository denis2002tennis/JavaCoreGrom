package lesson16_17;

import java.util.Arrays;

public class Exercises {
    public static void main(String[] args) {
        String test = "Valik kur lir kur kur kur kur l";
        System.out.println(deleteDuplicates(test));


        System.out.println(Arrays.toString(countDuplicates(test, new String[]{"kur", "or", "l"})));
    }


    //delete repeating words
    public static String deleteDuplicates(String input) {

        //найти повторения и удалить их
        String[] words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j]))
                    words[j] = "";
            }
        }
        String result = "";
        for (String word : words) {
            if (word != "")
                result += word + " ";
        }
        return result;
    }

    //count replaces
    public static int[] countDuplicates(String input, String[] words) {
        int[] result = new int[words.length];
        String[] line = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < line.length; j++) {
                if (words[i].equals(line[j]))
                    result[i]++;
            }
        }

        return result;
    }


    //    String replace(String input, String target, String replacement){
//
//    }
}



