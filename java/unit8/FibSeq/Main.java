package unit8.FibSeq;

import java.util.Arrays;

public class Main {
    static long x = 1;
    static long y = 1;
    static long z;

    public static void main(String[] args) {
        int number = 97;
        long[] fibbArray = calculate(number);
        System.out.println(fibbArray[number - 1]);
        System.out.println(Arrays.toString(fibbArray));
    }

    public static long[] calculate(int number) {
        long[] seq = new long[number];
        seq[0] = 1;
        seq[1] = 1;
        for (int i = 2; i < number; i++) {
            z = x + y;
            seq[i] = z;
            x = y;
            y = z;
        }
        return seq;
    }
}
