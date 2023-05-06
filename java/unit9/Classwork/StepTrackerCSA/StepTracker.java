package unit9.Classwork.StepTrackerCSA;

import java.util.ArrayList;

public class StepTracker {
    public int days = 0;
    public int activeDays = 0;
    public ArrayList<Integer> stepsPerDay = new ArrayList<>();
    public final int limit;
    public StepTracker(int limit){
        this.limit = limit;
    }
    public void addDailySteps(int steps){
        stepsPerDay.add(steps);
        days++;
        activeDays+=steps>=limit?1:0;
    }
    public int activeDays(){
        return activeDays;
    }
    public double averageSteps(){
        int total = 0;
        for (int i:stepsPerDay){
            total += i;
        }
        double dtotal = total;
        return days==0?0d:dtotal/days;
    }
}
