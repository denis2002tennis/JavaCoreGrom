package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions=new Transaction[10];
    private Utils utils=new Utils();

    public Transaction save(Transaction transaction) throws Exception{
         validate(transaction);
         for(int i=0;i<transactions.length;i++){
             if(transactions[i]==null){
                 transactions[i]=transaction;
                 return transactions[i];
             }
         }
       throw new BadRequestException("Unknown error");
    }

    private void validate(Transaction transaction)throws BadRequestException,InternalServerException{
        limitsChecker(transaction);
        cityChecker(transaction);
        emptyChecker(transaction);
        sameTransactionChecker(transaction);
    }

    private void limitsChecker(Transaction transaction) throws LimitExceeded{
        if(transaction.getAmount()>utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceeded"+transaction.getId()+". Can't be saved");

        int sum=transaction.getAmount(),count=1;
        for(Transaction trans:getTransactionsPerDay(transaction.getDateCreated())){
            sum+=trans.getAmount();
            count++;
        }
        if(sum>utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Transaction limit per day amount exceeded"+transaction.getId()+". Can't be saved");

        if(count>utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceeded"+transaction.getId()+". Can't be saved");
    }
    private void cityChecker(Transaction transaction) throws BadRequestException{
        for(String string:utils.getCities()){
            if(string.equals(transaction.getCity()))
                return;
        }
            throw new BadRequestException("Transaction city "+transaction.getCity()+" is not correct "+transaction.getId()+". Can't be saved");
    }

    private void emptyChecker(Transaction transaction) throws InternalServerException{
        for(int i=0;i<transactions.length;i++){
            if(transactions[i]==null){
               return;
            }
        }
            throw new InternalServerException("Not enough space in "+transaction.getId()+". Can't be saved");
    }

    private void sameTransactionChecker(Transaction transaction) throws BadRequestException{
        for(int i=0;i<transactions.length;i++){
            if(transactions[i]!=null)
            if(transactions[i].equals(transaction)){
                throw new BadRequestException("Transaction "+transaction.getId()+" is already present in the scope. Can't be saved");
            }
        }

    }

    public Transaction[] transactionList(){
        return transactions;
    }
    public Transaction[] transactionList(String city){
        Transaction[] transactions1=new Transaction[transactions.length];
        for(int i=0;i<transactions.length;i++){
            if(transactions[i].getCity().equals(city))
            transactions1[i]=transactions[i];
        }
        return transactions1;
    }
    public Transaction[] transactionList(int amount){
        return null;
    }

    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);


        int count=0;
        for(Transaction transaction:transactions){
            if(transaction!=null){
                calendar.setTime(dateOfCurTransaction);
                int trMonth=calendar.get(Calendar.MONTH);
                int trDay=calendar.get(Calendar.DAY_OF_MONTH);

                if(trMonth==month&&trDay==day){
                    count++;
                }
            }
        }

        Transaction[] result=new Transaction[count];
        int index=0;
        for(Transaction transaction:transactions){
            if(transaction!=null){
                calendar.setTime(dateOfCurTransaction);
                int trMonth=calendar.get(Calendar.MONTH);
                int trDay=calendar.get(Calendar.DAY_OF_MONTH);

                if(trMonth==month&&trDay==day){
                   result[index]=transaction;
                   index++;
                }
            }
        }
        return result;

    }
}
