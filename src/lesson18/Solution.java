package lesson18;

public class Solution {

    public static void main(String[] args) {
        String s="123456789 dfghjk3 4567890 4567";
        System.out.println(findNumbers2(s));
    }

    public static int[] findNumbers(String text){
        String[] line=text.split(" ");
        int[] result=new int[line.length];
        for(int i=0;i<line.length;i++){
        try {
           result[i]= Integer.parseInt(line[i]);
        }catch (Exception e){
            System.out.println("not a number");
        }
        }
            return result;
    }

    public static boolean numbersChecker(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i)))
                return false;
        }
        return true;
    }

    public static int[] findNumbers2(String text){
        String[] line=text.split(" ");
        int[] result=new int[line.length];
        for(int i=0;i<line.length;i++){
          if(numbersChecker(line[i]))
                result[i]= Integer.parseInt(line[i]);
         else
               System.out.println("not a number");

        }
        return result;
    }
}
