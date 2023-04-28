package unit9.Classwork.Star;

public class Main {
    public static void main(String[] args) {
        //create a new star object with a starting value of 5
        Star star1 = new Star(5);
        //create a new star object wth a default starting value
        Star star2 = new Star();
        //method calls for star1
        star1.printStars();
        star1.printRowsOfStars();
        star1.cross();
        star1.printSolidDiamond();
        //create method calls for star2
        star2.printStars();
        star2.printRowsOfStars();
        star2.cross();
        star2.printSolidDiamond();
    }
}
