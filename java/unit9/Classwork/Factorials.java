package unit9.Classwork;

public class Factorials {
    private static long n = 20;
    public static long recurse(long num){
        if(num<=1){
            return 1;
        }
        else {
            return (num*recurse(num-1));
        }
    }

    public static void main(String[] args) {
        System.out.println(recurse(n));
    }
}
