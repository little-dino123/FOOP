package unit8.ScheduleMaker;

public class Day {
    private String day;
    private String[] classes;
    private Schedule schedule;

    public Day(String d, Schedule sched) {
        schedule = sched;
        this.day = d;
        classes = new String[this.day == "mon" ? 7 : 4];
    }

    public void printSchedule() {
        for (int i = 0; i < classes.length; i++) {
            System.out.print("Period " + (i + 1) + ":");
            System.out.println(classes[i]);
        }
    }

    public String getClass(int period) {
        return schedule.getClass(period);
    }

    public String getDay() {
        return day;
    }

    public void makeDay() {
        if (day.equals("mon")) {
            for (int i = 0; i < 7; i++) {
                classes[i] = schedule.getClass(i + 1);
            }
        } else if (day.equals("tue") || day.equals("thu")) {
            for (int i = 0; i < 4; i++) {
                classes[i] = schedule.getClass(i + 1);
            }
        } else if (day.equals("wed")) {
            for (int i = 0; i < 3; i++) {
                classes[i] = schedule.getClass(i + 1);
            }
            classes[3] = "PRIME";
        } else if (day.equals("fri")) {
            classes[0] = schedule.getClass(5);
            classes[1] = schedule.getClass(6);
            classes[2] = "PRIME";
            classes[3] = schedule.getClass(7);


        }
    }
}
