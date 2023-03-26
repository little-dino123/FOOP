package unit8.BankThingy;


public class Main {
    public static void main(String[] args) {
        Bank helloThere = new Bank(1000000000, "237947934", "General Kenobi", 1.002);
        Bank mistaWhite = new Bank("56478390457", "jessie, we're gonna cook");
        helloThere.withdraw(1000);
        System.out.println(helloThere.currentBalance());
        helloThere.withdraw(10000);
        System.out.println(helloThere.currentBalance());

        System.out.println("\n\n");

        System.out.println(mistaWhite.currentBalance());
        mistaWhite.deposit(1000);
        mistaWhite.changeAPR(10);
        mistaWhite.payInterest();
        System.out.println(mistaWhite.currentBalance());
        mistaWhite.changeAPR(1.0123);
        mistaWhite.payInterest();
        System.out.println(mistaWhite.currentBalance());
    }

}

