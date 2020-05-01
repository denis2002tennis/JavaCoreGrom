package lesson9.utils;

public class Checker {
    //private - доступен только внутри класса
    //default - (package-private)
    //protected
    //public - доступен во всех классах проекта


    public int companyNamesValidatedCount= 0;


    public boolean checkCompanyName(String companyName) {
       // if(companyName == "Google" || companyName == "Amazom")
         //   return  false;
           // return true;
         companyNamesValidatedCount++;
        return companyName != "Google" && companyName != "Amazom";
    }

}
