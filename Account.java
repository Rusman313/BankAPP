//Parent Class - we do not create objects from this so its abstract
public abstract class Account implements IBaseRate {
    // List common properties for saving and checking accounts
    String name;
    String sSN;
    double balance;
    static int index = 10000;
    String accountNumber;
    double rate;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    // Constructor to set base properties and initialize the account
    public Account(String name, String sSN, double initDeposit){
        //System.out.println("NEW ACCOUNT: ");
        this.name = name;
        this.sSN = sSN;
        balance = initDeposit;
        

        // Set account number
        index++;
        this.accountNumber = setAccountNumber();
        //System.out.println("Account Number: " + this.accountNumber);
        setRate();
    }

	private String setAccountNumber(){
        String lastTwoOfSSN = sSN.substring(sSN.length()-2, sSN.length());
        int uniqueID = index;
        int randomNum = (int) (Math.random() * Math.pow(10, 3));
        return lastTwoOfSSN + uniqueID + randomNum;
    }

    public void compound(){
        double accruedInterest = balance*(rate/100);
        balance = balance + accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
        printBalance();
    }

    // List common methods
    public void showInfo(){
        System.out.println("Name: " + name+"\nSSN: "+ANSI_CYAN + sSN +ANSI_RESET+"\nBalance: "+ANSI_CYAN+ balance + ANSI_RESET +ANSI_CYAN + "\nRATE: " + rate + "%"+ ANSI_RESET );
    }

    public abstract void setRate();
    public void deposit (double amount){
        balance = balance + amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }

    public void withdraw(double amount){
        balance = balance - amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();
    }

    public void transfer(String toWhere, double amount){
        balance = balance - amount;
        System.out.println("Transferring $" + amount + "to" + toWhere);
        printBalance();
    }

    public void printBalance(){
        System.out.println("Your balance is now: $" + balance);
    }
    
}