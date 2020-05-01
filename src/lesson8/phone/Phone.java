package lesson8.phone;

public class Phone {
    int price;
    double weight;
    String countryPoduced;

    public Phone(int price, double weight, String countryPoduced) {
        System.out.println("phone constructor was invoked...");
        this.price = price;
        this.weight = weight;
        this.countryPoduced = countryPoduced;
    }

    void orderPhone() {
        System.out.println("orderPhone invoked...");
    }
}
