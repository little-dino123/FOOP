package unit9.Classwork.Star;

import java.util.Arrays;


public class Star{
    private int num;
    public Star(){
        num = 10;
    }

    public Star(int inum){
        num  = inum;
    }
    public void printStars(){
        System.out.println("Printing printStars:");
        for (int i = 0; i < num; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
    public void printStars(int num){
        for (int i = 0; i < num; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
    public void printSpace(int num){
        for (int i = 0; i < num; i++) {
            System.out.print(" ");
        }
    }
    public void printRowsOfStars(){
        System.out.println("Printing printRowsOfStars:");
        for (int i = 1; i <= num; i++) {
            printStars(i);
        }
    }
    public void cross(){
        System.out.println("Printing Cross:");
        for (int i = 0; i < num; i++) {
            printSpace(num);
            printStars(num);
        }
        for (int i = 0; i < num; i++) {
            printStars(num*3);
        }
        for (int i = 0; i < num; i++) {
            printSpace(num);
            printStars(num);
        }
    }
    public void printSolidDiamond(){
        System.out.println("Printing printSolidDiamond:");
        // indx0 is num of spaces, indx1 is num of stars
        int[][] thing  = new int[num*2-1][2];
        for (int i = 0; i <num*2-1; i++) {
            thing[i][0] = Math.abs(num - 1 - i);
            thing[i][1]=i<num?(thing[i][1] = 1 + i * 2):(thing[i][1]=(num*2-1)+((num-i-1)*2));
        }
        System.out.println(Arrays.deepToString(thing));
        for (int i = 0; i < thing.length; i++) {
            printSpace(thing[i][0]);
            printStars(thing[i][1]);
        }
    }
}