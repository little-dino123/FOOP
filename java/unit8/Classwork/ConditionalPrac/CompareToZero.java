package unit8.Classwork.ConditionalPrac;

import java.util.Scanner;

public class CompareToZero {

    public static void main(String[] args) {
        double x;
        Scanner s  = new Scanner(System.in);
        System.out.println("enter a numbr idot");
        try {
            x = s.nextDouble();
            System.out.println(cZero(x));
        }
        catch (Exception InputMismatchException) {
            System.out.println("idot enter a numbr not letters stooppid");
        }
    }
    public static String cZero(double x){
        return x > 0 ? "ur num is beeger than 0" : x < 0 ? "your num is less than 0" : "ur num is 0";
    }
}
