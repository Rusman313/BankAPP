import java.util.LinkedList;
import java.util.List;
public class BankAccountApp {
    public static void main(String[] args) {
        List<Account>accounts = new LinkedList<Account>(); 
        //Checking chk1 = new Checking("Rafeena Usman", "1234567895", 1000000.00);
        //chk1.showInfo();
       // Savings sav1 = new Savings("Usman Alladin", "1243579635", 9582145.0);
       // sav1.showInfo();

        // Read a CSV file then create new accounts base on that data
        String file = "original.csv";
        List<String[]> newAccountHolders = CSV.read(file);
        for(String[]accountHolder : newAccountHolders){
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            if(accountType.equals("Savings")) {
                accounts.add(new Savings(name, sSN, initDeposit));
            }
            else if (accountType.equals("Checking")){
                accounts.add(new Checking(name, sSN, initDeposit));
            }
            else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }

        // accounts.get(5).showInfo();

        for (Account acc : accounts){
            System.out.println("***************");
            acc.showInfo();
        }
    }
}