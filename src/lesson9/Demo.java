package lesson9;

import lesson9.utils.Checker;

public class Demo {
    public static void main(String[] args) {
        Company company=new Company("Apple","USA");
        System.out.println(company.getCountryFounded());
        System.out.println(company.getName());

        //company.setName("IBM");

        Checker checker= new Checker();
        System.out.println(checker.checkCompanyName(company.getCountryFounded()));
        System.out.println(checker.companyNamesValidatedCount);

        System.out.println(company.code);


    }
}
