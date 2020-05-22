public class Checking extends Account{
    //List properties specific to a Checking account
    int debitCardNumber;
    int debitCardPin;

    //Constructor to initialize checking account properties
    public Checking(String name, String sSN, double initDeposit){
        super(name, sSN, initDeposit);
        accountNumber = 2+ accountNumber;
        setDebitCard();
       //System.out.println("Account Number: " + this.accountNumber);

        //System.out.println("NEW CHECKING ACCOUNT");
        //System.out.println("NAME: " + name);

        
    }


    //List any methods specific to the checking account

    public void showInfo(){
        System.out.println("Account Type: Checking"); 
        super.showInfo();
        System.out.println("Your Account Features:" + "\n Debit Card Number: " + ANSI_PURPLE+debitCardNumber +ANSI_RESET+ "\n Debit Card PIN: "+ANSI_PURPLE + debitCardPin+ANSI_RESET);
    }
    private void setDebitCard(){
        debitCardNumber = (int) (Math.random()* Math.pow(10, 12));
        debitCardPin = (int) (Math.random() * Math.pow(10, 4));
        //System.out.println("CARD:" + this.debitCardNumber);
       //System.out.println("PIN:" + this.debitCardPin);
    }
    @Override
    public void setRate(){
        rate = getBaseRate()* .15;
    }



}