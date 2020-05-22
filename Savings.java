public class Savings extends Account {

    // List properties specific to a Savings account
    int safetyDepositBoxID;
    int safetyDepositBoxKey;
    

    // Constructor to initialize savings account properties

    public Savings(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = 1 + accountNumber;
        // System.out.println("Account Number: " + this.accountNumber);
        setSafetyDepositBox();
    }
    // List any methods specific to the savings account
    private void setSafetyDepositBox(){
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
        //System.out.println(safetyDepositBoxID);
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
    }

    public void showInfo() {
        System.out.println("Account Type: Savings");
        super.showInfo();
        System.out.println("Your Account Features:" + "\n Safety Deposit Box ID: " +ANSI_GREEN+ safetyDepositBoxID +ANSI_RESET+ "\n Safety Deposit Box Key: "+ANSI_GREEN + safetyDepositBoxKey+ANSI_RESET);
    }

    @Override
    public void setRate(){
        rate = getBaseRate() - .25;
    }

}