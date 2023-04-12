package unit8.Classwork.ValidDate;

public class Checker {
    private byte d;
    private byte m;
    private long y;
    private static final byte[] monthLengths = new byte[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public Checker(byte day, byte month, long year){
        d=day;
        m=month;
        y=year;
    }
    public boolean checkValidDate(){
        return checkValidDay() && checkValidMonth();
    }
    public boolean checkLeapYear(){
        return (y%4==0 || y%400==0 || !(y%100==0)) ? (d<=29) : (d<=28);
    }
    public boolean checkValidDay(){
        return (!(m==2))&&m>0?(d<=monthLengths[m-1]):(checkLeapYear());
    }
    public boolean checkValidMonth(){
        return m<=12&&m>1;
    }
    boolean GoofyAhhhh(){return m<13&&!(m==2)?(d>monthLengths[m-1]):(((y%4==0||y%400==0)&&!(y%100==0))?(d<29):(d<28));}
}