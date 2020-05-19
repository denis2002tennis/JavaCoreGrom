package lesson16;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String test = "m Valik kur lir 8  fggsfseadfghgjdsafDg    gg  gg gg gg gg   kur kur kur kur l     r";
        test = " sdfgsd42g  3452trgfgh ";
        test = "jkdf.fsihdf.dfj";

        //System.out.println(mostCountedWord(test));

        //System.out.println(maxWord(test));
        //System.out.println(minWord(test));
        // System.out.println(countWords(test));

    }

    public static String mostCountedWord(String input) {
        String[] line = input.split(" ");
        int[] result = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            if (lettersChecker(line[i]) == true)
                for (int j = 0; j < line.length; j++) {
                    if (line[i].equals(line[j]) && !line[i].equals(""))
                        result[i]++;
                }
        }

        //System.out.println(Arrays.toString(result));
        if (result.length == 0)
            return null;
        boolean checker = false;
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0)
                checker = true;
        }
        if (checker == false)
            return null;

        int maxer = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] > result[maxer])
                maxer = i;
        }
        return line[maxer];


    }

    public static int countWords(String input) {
        String[] line = input.split(" ");
        int counter = 0;
        for (int i = 0; i < line.length; i++) {
            if (!line[i].isEmpty()) {
                if (lettersChecker(line[i]) == true)
                    counter++;
            }
        }
        return counter;
    }

    public static String maxWord(String input) {
        if (input.isEmpty())
            return null;
        String[] lines = input.split(" ");
        String longestWord = "";
        for (String line : lines) {
            if (longestWord.length() < line.length()) {
                if (lettersChecker(line) == true)
                    longestWord = line;
            }
        }
        if (longestWord.equals(""))
            return null;
        return longestWord;
    }

    public static boolean lettersChecker(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetter(input.charAt(i)))
                return false;
        }
        return true;
    }

    public static String minWord(String input) {
        if (input.isEmpty())
            return null;
        String[] lines = input.split(" ");
        String shortestWord = maxWord(input);
        if (shortestWord == (null))
            return null;
        for (String line : lines) {
            if (shortestWord.length() > line.length())
                if (lettersChecker(line) == true && !line.equals(""))
                    shortestWord = line;
        }
        return shortestWord;
    }

}
