package unit8.WeDoATinyBitOfTomfoolery.TempConverter;

public class Convertor {
     public static double cToF(double temp){
        //update to convert correctly - remember parenthesis - round to 2 decimal places
        return (temp*1.8+32);
    }

     public static double fToC(double temp){
        //update to convert correctly - remember parenthesis - round to 2 decimal places
        return ((temp-32)/1.8);
    }
}
