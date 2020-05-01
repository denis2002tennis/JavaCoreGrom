package lesson8.phone;

public class Iphone extends Phone {


    boolean fingerPrint;

    public Iphone(int price, double weight, String countryPoduced, boolean fingerPrint) {
        super(price, weight, countryPoduced);
        System.out.println("Iphone constructor was invoked...");
        this.fingerPrint = fingerPrint;
    }

    void orderPhone() {

    }

    void deleteIphoneFromDb() {
        System.out.println("deleteIphoneFromDb invoked...");
    }
}
