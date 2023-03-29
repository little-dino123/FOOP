package unit8.WeDoATinyBitOfTomfoolery.ConditionalPrac;

import java.util.Scanner;

public class Magic8Ball {
    private static String[] l = new String[]{"yes", "sure ig idk", "ur bad kid", "no", "maybe", "skill issue", "cope", "ratio"};

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("ask a question");
        s.next();
        System.out.println(returnRandom());

    }
    public static String returnRandom(){
        return l[(int)(Math.random()*l.length)];
    }
}
