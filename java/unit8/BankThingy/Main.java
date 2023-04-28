package unit8.BankThingy;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What ios your name?");
        String name = scanner.next();
        System.out.println("What is your ID?");
        String id = scanner.next();
        System.out.println("How much do you want in your account");
        float money = scanner.nextFloat();
        Bank myBank = new Bank(money, id, name);
        while (true) {
            System.out.println("what action would you like to do (balance, deposit, witdraw, changeAPR)");
            String response = scanner.next();
            switch (response) {
                case "balance" -> {
                    System.out.println("Your current balance is " + myBank.currentBalance() + "$.");
                }
                case "deposit" -> {
                    System.out.println("how much would you like to deposit");
                    float deposit = scanner.nextFloat();
                    myBank.deposit(deposit);
                }
                case "withdraw" -> {
                    System.out.println("how much would you like to wihdraw");
                    float withdraw = scanner.nextFloat();
                    myBank.withdraw(withdraw);
                }
                case "changeAPR" -> {
                    System.out.println("What is new apr");
                    double apr = scanner.nextDouble();
                    myBank.changeAPR(apr);
                }
                default -> {
                    System.out.println("Please enter a valid input (balance, deposit, witdraw, changeAPR)");
                }
            }
        }
    }

}

