package unit8.ScheduleMaker;

public class Schedule {
    private String[] classes = new String[7];
    private String name;

    public Schedule(String n) {
        name = n;
    }

    public void addClass(int period, String className) {
        classes[period] = className;
    }

    public String getClass(int period) {
        return classes[period - 1];
    }

    public String getName() {
        return name;
    }

}
