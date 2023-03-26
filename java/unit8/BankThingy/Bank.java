package unit8.BankThingy;

public class Bank {
    String kAccountNumber;
    String kAccountName;
    double APR;
    float balance;

    public Bank(float initialDeposit, String accountNumber, String accountName, double initAPR) {
        kAccountNumber = accountNumber;
        kAccountName = accountName;
        APR = initAPR;
        balance = initialDeposit;
    }

    public Bank(String accountNumber, String accountName) {
        this(0, accountNumber, accountName, 1.0015);
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
