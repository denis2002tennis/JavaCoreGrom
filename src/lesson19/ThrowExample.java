package lesson19;

public class ThrowExample {
    private static String[] array={"-1,10,5,10,100","test","test",null};

    private static void test()throws Exception{
        for(String element:array){
            if(element==null)
                throw new Exception("null is detected");
        }
        System.out.println("done");
    }
    private static void useOfTestMethod(){
        try {
            test();
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }


    }

    public static void main(String[] args) {
        useOfTestMethod();
    }
}
