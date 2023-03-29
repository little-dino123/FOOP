package unit8.WeDoATinyBitOfTomfoolery.ConditionalPrac;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in);
        while (true) {
            System.out.println("enter a numbr idot");
            double x = s.nextDouble();
            System.out.println(cZero(x));
        }
    }
    public static String cZero(double x){
        return x > 0 ? "ur num is beeger than 0" : x < 0 ? "your num is less than 0" : "ur num is 0";
    }

}
