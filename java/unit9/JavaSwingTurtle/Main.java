import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class Main {
  public static void main(String[] args) {  
    World world = new World(300,300);
   
     
    Turtle yertle = new Turtle(world);
    // Add your code here
    yertle.forward();
    yertle.turnRight();
    yertle.forward();

  
    world.setVisible(true);
  }
}
