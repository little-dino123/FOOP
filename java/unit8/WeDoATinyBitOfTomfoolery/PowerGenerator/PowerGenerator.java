package unit8.WeDoATinyBitOfTomfoolery.PowerGenerator;

public class PowerGenerator{
    private double b;
    private short p = 0;
    public PowerGenerator(double x){
        b = x;
    }
    public double next(){
        return Math.pow(b, p++);
    }
}