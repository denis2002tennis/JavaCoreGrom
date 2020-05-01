package lesson10.homework;

import java.util.Date;

public class ElectronicsOrder extends Order {
    private int guaranteeMonths;


    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    @Override
    public void validateOrder() {
        if (getShipFromCity() == "Киев" || getShipFromCity() == "Одесса" || getShipFromCity() == "Днепр" || getShipFromCity() == "Харьков") {
            if (getShipToCity() == "Киев" || getShipToCity() == "Одесса" || getShipToCity() == "Днепр" || getShipToCity() == "Харьков") {
                if (getBasePrice() > 100) {
                    if (getCustomerOwned().getName() != null) {
                        if (getCustomerOwned().getGender() == "Женский")
                            setDateConfirmed(new Date());
                    }
                }
            }
        }
    }

    @Override
    public void calculatePrice() {
        double commission = getShipToCity() != null && (getShipToCity() == "Киев" || getShipToCity() == "Одесса") ?
                getBasePrice() * 0.1 : getBasePrice() * 0.15;
        double bonus = getBasePrice() > 1000 ? (getBasePrice() + commission) * 0.05 : 0;
        setTotalPrice(getBasePrice() + commission - bonus);


    }
}

      /*  if (getShipToCity() == "Киев" || getShipToCity() == "Одесса"){
            if((getBasePrice() * 1.1)>1000)
                setTotalPrice((getBasePrice() * 1.1)*0.95);
            else
                setTotalPrice(getBasePrice() * 1.1);
        }
        else {
            if ((getBasePrice() * 1.15) > 1000)
            setTotalPrice((getBasePrice() * 1.15) * 0.95);
            else
            setTotalPrice(getBasePrice() * 1.15);
        }
*/
