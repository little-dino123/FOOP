package unit9.Classwork.SelfDivisor;

public class Main {
    /** @param number the number to be tested
     *         Precondition: number > 0
     *  @return true if every decimal digit of
     *          number is a divisor of number;
     *          false otherwise
     */

    /****************/
    public static void main (String[] args){
        System.out.println("128: " + isSelfDivisor(128)); //true
        System.out.println("22: " + isSelfDivisor(22)); //true
        System.out.println("26: " + isSelfDivisor(26)); //false
        System.out.println("120: " + isSelfDivisor(120)); //false
        System.out.println("102: " + isSelfDivisor(102)); //false
    }
    public static boolean isSelfDivisor(int number){
        String sNumber = Integer.toString(number);
        for (int i = 0; i < sNumber.length(); i++) {
            int currentNumber = Integer.parseInt(sNumber.substring(i,i+1));
            if (currentNumber==0||number%currentNumber!=0){return false;}
        }
        return true;
    }
}

