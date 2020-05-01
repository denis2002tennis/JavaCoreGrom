package lesson4;

public class CompareSums {
    public static void main(String[] args) {
        System.out.println(compareSums(1, 20000000, 1, 9));
    }

    public static long sum(int from, int to) {
        long suma = 0;
        for (long i = from; i <= to; i++) {
            suma += i;
        }
        return suma;
    }

    public static boolean compareSums(int a, int b, int c, int d) {
        long sum1 = sum(a, b);
        long sum2 = sum(c, d);
        return sum1 > sum2;
    }
}
