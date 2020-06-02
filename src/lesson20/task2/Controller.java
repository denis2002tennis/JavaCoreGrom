package lesson20.task2;

public class Controller {
    private TransactionDAO transactionDAO=new TransactionDAO();

    public Transaction save(Transaction transaction) throws Exception{
        return transactionDAO.save(transaction);
    }
    public String transactionList(){
        return transactionDAO.transactionList();
    }
    public String transactionList(String city){
        return transactionDAO.transactionList(city);
    }
    public String transactionList(int amount){
        return transactionDAO.transactionList(amount);
    }

}
