package lesson3;

public class FindOdd {
    public static void main(String[] args) {
        int res = 0;

        for (int i = 1; i <= 999; i++) {
            System.out.println("Found");
            res = res + i;
            i++;
        }
        if ((res * 5) > 5000) {
            System.out.println("Bigger");
        } else
            System.out.println("Smaller");
    }
}
