package unit8.ScheduleMaker;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static Schedule mySchedule = new Schedule("David");
    public static Day mon = new Day("mon", mySchedule);
    public static Day tue = new Day("tue", mySchedule);
    public static Day wed = new Day("wed", mySchedule);
    public static Day thu = new Day("thu", mySchedule);
    public static Day fri = new Day("fri", mySchedule);
    public static Day[] days = new Day[]{mon,tue,wed,thu,fri};
    public static HashMap<String, Day> daysMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        createSchedule(mySchedule);
        daysMap.put("mon", mon);
        daysMap.put("tue", tue);
        daysMap.put("wed", wed);
        daysMap.put("thu", thu);
        daysMap.put("fri", fri);
        for (int i=0; i<5; i++){
            days[i].makeDay();
        }
        while (true){
            System.out.println("Which day's schedule would you like to see?");
            String temp = scanner.next();
            Day day = daysMap.get(temp);
            if (day!=null){
                day.printSchedule();
            }
            else{
                System.out.println("Please enter a valid option(mon, tue, wed, thu, fri)");
            }
        }
    }
    public static void createSchedule(Schedule schedule){
        for (int i=0; i<7; i++) {
            System.out.println("What is your period " + (i+1) + " class, "+schedule.getName()+"?");
            String temp = scanner.next();
            schedule.addClass(i, temp);
        }
    }
}
