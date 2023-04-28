package unit9.Classwork.Loops;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(input);
        mainLoop(input);
    }

    public static int sumOfDigits(String input) {
        int current;
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            current = Integer.parseInt(Character.toString(input.charAt(i)));
            sum += current;
            System.out.println("sum " + sum);
        }
        return sum;
    }

    public static void mainLoop(String input) {
        int tempI;
        String tempS = input;
        do {
            tempI = sumOfDigits(tempS);
            tempS = Integer.toString(tempI);
            System.out.println("total " + tempS);
        } while (tempS.length() > 1);
        System.out.println("final " + tempS);
    }
}
