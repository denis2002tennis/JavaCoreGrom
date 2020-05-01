package lesson2;

public class LoopExample {
   public static void main(String[] args) {
        int a = 1;
        while (a<=10)
        {
            System.out.println(a);
            a++;
        }
        for ( int i=1; i<=10; i++)
        {
            System.out.println(i);
        }

               int i =0;
               long res =0;
               while(i<=10000000)
               {
                   res=res+i;
               }
               System.out.println(res);
           }

   /*public static void main(String[] args) {
       int a = 5;
       do {
           System.out.println(a);
           a++;
       } while (a <= 10);
       a = a + 5;
       while (a <= 20) {

           System.out.println(a);
           a++;
       }
   }*/
}
