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

        return transaction;
    }

    private void validate(Transaction transaction)throws Exception{
        if(transaction.getAmount()>utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceeded"+transaction.getId()+". Can't be saved");

        int sum=0,count=0;
        for(Transaction trans:getTransactionsPerDay(transaction.getDateCreated())){
            sum+=trans.getAmount();
            count++;
        }
        if(sum>utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Transaction limit per day amount exceeded"+transaction.getId()+". Can't be saved");

        if(count>utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceeded"+transaction.getId()+". Can't be saved");

        boolean checker=false;
        for(String string:utils.getCities()){
            if(string.equals(transaction.getCity()))
                checker=true;
        }
        if(checker==false)
            throw new BadRequestException("Transaction city is not correct "+transaction.getId()+". Can't be saved");

        checker=false;
        //TODO не хватило места InternalServerException
        for(int i=0;i<transactions.length;i++){
            if(transactions[i]==null){
                transactions[i]=transaction;
                checker=true;
              //  return i;
            }
        }
        if(checker==false)
            throw new InternalServerException("Not enough space in "+transaction.getId()+". Can't be saved");


    }
    public Transaction[] transactionList(){
        return null;
    }
    public Transaction[] transactionList(String city){
        return null;
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
            if(transactions!=null){
                calendar.setTime(transaction.getDateCreated());
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
            if(transactions!=null){
                calendar.setTime(transaction.getDateCreated());
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
