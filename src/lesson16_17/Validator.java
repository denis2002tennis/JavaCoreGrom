package lesson16_17;

public class Validator {
    public static void main(String[] args) {
        String s1 = "https://google.com";
        String s2 = "http://google.com";
        String s3 = "h3ttps://google.com";
        String s4 = "https://goo-gle.com";
        String s5 = "https://google.coo";
        String s6 = "";
        String s7 = null;
        String s8 = "https://www.google.com";
        String s9 = "https://ww.google.com";
        String s10 = " https://ww.google.com";
        String s11 = "https:// www.google.com";
        String s12 = "https://www.google.com   ";
        String s13 = "https://www.googl2e.com";

        validate(s1);
        System.out.println(validate(s1));
        System.out.println(validate(s2));
        System.out.println(validate(s3));
        System.out.println(validate(s4));
        System.out.println(validate(s5));
        System.out.println(validate(s6));
        System.out.println(validate(s7));
        System.out.println(validate(s8));
        System.out.println(validate(s9));
        System.out.println(validate(s10));
        System.out.println(validate(s11));
        System.out.println(validate(s12));
        System.out.println(validate(s13));
    }

    public static boolean validate(String address){
        if(address!=(null)&&protokolChecker(address)!=null&&checkAddress(address)!=null)
        return true;
            return false;
    }


    public static String protokolChecker(String input){
        String protokol ="http://";
        String protokol1 ="https://";

        if(input.startsWith(protokol))
            return protokol;
        if(input.startsWith(protokol1))
            return protokol1;
            return null;
    }

    public static String checkAddress(String input){
        String protokol=protokolChecker(input);
        if(protokol!=null){
           input= input.replace(protokol,"");
            if(input.startsWith("www."))
             input=input.replace("www.","");
        }
        else return null;
        input=checkDomain(input);
       if( input!=null){
        if(checkWord(input)==true)
            return input;
       }
        return null;
    }


    public static boolean checkWord(String input) {
        if(input!=null&&input.length()>0)
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetterOrDigit(input.charAt(i)))
                return false;
        }
        return true;
    }

    public static String checkDomain(String input){
        String domain=".com";
        String domain1=".org";
        String domain2=".net";
        if(input.endsWith(domain)){
            input=input.replace(domain,"");
        return input;
        }
        if(input.endsWith(domain1)){
            input=input.replace(domain1,"");
            return input;
        }
        if(input.endsWith(domain2)){
            input=input.replace(domain2,"");
            return input;
        }
        return null;
    }

}
