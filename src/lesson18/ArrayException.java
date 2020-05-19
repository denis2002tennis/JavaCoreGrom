package lesson18;

public class ArrayException {
    public static void main(String[] args) {
        int[] array={1,5,0};
        try {
            System.out.println(array[3]);
        }catch (Exception e){
            System.err.println("Element was not found");
        }

        System.out.println("Cool");
        System.out.println("Good ");
    }
}
