package lesson16;

import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args) {

        String test = "Some string";

        System.out.println(test.isEmpty());
        System.out.println("".isEmpty());
        System.out.println(test.length());
        System.out.println(test.charAt(2));
        System.out.println();


        System.out.println(test.replace("me", "T"));
        test = "Some string";
        System.out.println(test.replaceAll("me", "T"));
        //String regex="{a-Z};

        System.out.println(test);
        System.out.println(test.contains("e"));

        System.out.println(Arrays.toString(test.split("e")));

        String phrase="Hello there guys";


        System.out.println(" test a ".trim());
        System.out.println(phrase.substring(5));
        System.out.println(phrase.substring(6,11));
        System.out.println(test.toUpperCase());
        System.out.println(test.toLowerCase());





    }
}
