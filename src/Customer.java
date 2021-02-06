import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
        //create default constructor
       name = "Jeff";
       accountNumber = 42;
       checkBalance = 500;
       savingBalance = 500;
    }
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        //constructor code here
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
    }

    public double deposit(double amt, Date date, String account){
        //your code here
        Deposit newDeposit = new Deposit(1, new Date(2020, Calendar.FEBRUARY, 18, 23, 57, 34), "checking");
        if (account.equals(CHECKING)){
            checkBalance = checkBalance + amt;
            return checkBalance;
        }
        else {
            savingBalance = savingBalance + amt;
            return savingBalance;
        }
    }
    public double withdraw(double amt, Date date, String account){
        //your code here
        Withdraw newWithdraw = new Withdraw(1, new Date(2020, Calendar.FEBRUARY, 18, 23, 57, 34), "checking");
        if (account.equals(CHECKING)) {
            checkBalance = checkBalance - amt;
            if (checkOverdraft(amt, account)) {
                checkBalance = checkBalance + amt;
            }
            return checkBalance;
        }
        else {
            savingBalance = savingBalance - amt;
            if (checkOverdraft(amt, account)) {
                savingBalance = savingBalance + amt;
            }
            return savingBalance;
        }
    }
    private boolean checkOverdraft(double amt, String account) {
        //your code here
        if (checkBalance < OVERDRAFT) {
            return true;
        }
        return savingBalance < OVERDRAFT;
    }

    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
