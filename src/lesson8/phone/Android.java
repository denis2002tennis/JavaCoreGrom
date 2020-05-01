package lesson8.phone;

public class Android extends Phone {

    String androidVersion;
    int screenSize;

    String secretDeviseCode;

    public Android(int price, double weight, String countryPoduced, String androidVersion, int screenSize, String secretDeviseCode) {
        super(price, weight, countryPoduced);

        this.androidVersion = androidVersion;
        this.screenSize = screenSize;
        this.secretDeviseCode = secretDeviseCode;
    }

    void installNewAndroidVersion() {
        System.out.println("installNewAndroidVersion invoked...");
    }
}
