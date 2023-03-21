import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class Main {
  public static void main(String[] args) {  
    World world = new World(300,300);
     
    Turtle tia = new Turtle(world);
    // Add your code here
    tia.penUp();
    tia.moveTo(60, 260);
    tia.penDown();
    tia.forward(); //default value 100
    tia.turnRight();
    tia.forward(200);


  
    world.setVisible(true);
  }
}
