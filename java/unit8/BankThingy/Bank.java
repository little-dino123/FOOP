package unit8.BankThingy;

public class Bank {
    String kAccountNumber;
    String kAccountName;
    double APR;
    float balance;

    /**
     * Full contructor
     *
     * @param initialDeposit
     * @param accountNumber
     * @param accountName
     * @param initAPR
     */
    public Bank(float initialDeposit, String accountNumber, String accountName, double initAPR) {
        kAccountNumber = accountNumber;
        kAccountName = accountName;
        APR = initAPR;
        balance = initialDeposit;
    }

    /**
     * Constructor wihout initAPR because i need a second contructor go brrrrrrrrr
     * <b><i>heheheha</i></b>
     * <br></br>
     * <img src="https://media.tenor.com/MOZ0kG5WZ2wAAAAC/heheheha-clash-royale.gif" width = "200"></img>
     *
     * @param initialDeposit
     * @param accountNumber
     * @param accountName
     * @return void
     * @author goofy ahh
     * @version -1
     */
    public Bank(float initialDeposit, String accountNumber, String accountName) {
        this(initialDeposit, accountNumber, accountName, 1.0015);
    }

    public void deposit(float deposit) {
        balance += deposit;
    }

    public void withdraw(float amount) {
        if (amount <= balance && amount <= 3000) {
            balance -= amount;
            System.out.println("Success, you withdrew " + amount);
        } else {
            System.out.println("Balance too low l+ratio+poor+cope harder");
        }
    }

    public float currentBalance() {
        return balance;
    }

    public void changeAPR(double newAPR) {
        APR = newAPR;
    }

    public void payInterest() {
        balance *= APR;
    }
}
