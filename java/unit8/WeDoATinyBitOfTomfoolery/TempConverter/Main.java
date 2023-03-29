package unit8.WeDoATinyBitOfTomfoolery.TempConverter;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to convert to C or F");
        String r = scan.next();
        if (r.equals("c")) {
            System.out.println("Enter a temp in F and I will convert it to C");
            double f = scan.nextDouble();
            System.out.println(f + " degrees fahrenheit is the following in celsius: " + Convertor.fToC(f));
        } else if (r.equals("f")) {
            System.out.println("Enter a temp in C and I will convert it to F");
            double c = scan.nextDouble();
            System.out.println(c + " degrees fahrenheit is the following in celsius: " + Convertor.cToF(c));
        }
        scan.close();
    }
}