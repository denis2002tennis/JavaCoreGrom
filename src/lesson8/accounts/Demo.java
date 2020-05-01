package lesson8.accounts;

public class Demo {
    public static void main(String[] args) {
        SavingAccount savingAcoount = new SavingAccount("SomeBank", "Denis", 1000, 50);
        savingAcoount.depositMoney(100);
        System.out.println(savingAcoount.moneyAmount);

        savingAcoount.changeOwnerName("Oleg");
        System.out.println(savingAcoount.ownerName);

        CheckingAccount checkingAccount= new CheckingAccount("SomeBank", "Denis", 1000, 500);
        checkingAccount.changeOwnerName("Oleg");
        System.out.println(checkingAccount.ownerName);
    }
}
