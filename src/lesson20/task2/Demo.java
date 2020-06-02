package lesson20.task2;


import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {
        TransactionDAO transactionDAO=new TransactionDAO();
        Transaction transaction=new Transaction(1,"Kiev",12,"cds",TransactionType.INCOME, new Date());
        transactionDAO.save(transaction);
        System.out.println(transactionDAO.transactionList());
    }
}
