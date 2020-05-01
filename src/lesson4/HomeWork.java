package lesson4;

public class HomeWork {
    public static void main(String[] args) {

        System.out.println(findDivCount((short)1,(short)20,2));
    }


    public static int findDivCount(short a, short b, int n) {
        int res = 0;
        for (int i = a; i <= b; i++) {
            if (i % n == 0) {
                res++;
            }
        }
        return res;
    }
}
/*System.out.println(concat("Кто-то ", "все ", "съел."));
public static String concat(String first, String second, String third) {
        return first + second + third;}*/
