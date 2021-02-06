import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    public String toString(double withdraw){
        //your code here
        
        return ("Withdraw of: $" + withdraw + " Date: " + date + " into account: " + account);
    }
}
