package unit8.Classwork.ValidDate;

import java.util.Scanner;

public class Main {
    private static byte day;
    private static byte month;
    private static long year;
    public static void main(String[] args) {
        getDate();
        Checker c = new Checker(day, month, year);
        System.out.println(c.checkValidDate()?"Your date is valid":"Your date is invalid");
    }
    public static void getDate(){
        Scanner s = new Scanner(System.in);
        String date = s.next();
        month = Byte.parseByte(date.split("/")[0]);
        day = Byte.parseByte(date.split("/")[1]);
        year = Long.parseLong(date.split("/")[2]);
    }
}
