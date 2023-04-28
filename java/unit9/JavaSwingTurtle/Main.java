package unit9.JavaSwingTurtle;

import unit9.JavaSwingTurtle.Shapes.Asterick;
import unit9.JavaSwingTurtle.Shapes.Pinwheel;
import unit9.JavaSwingTurtle.Shapes.Polygon;
import unit9.JavaSwingTurtle.Turtle.Turtle;
import unit9.JavaSwingTurtle.Turtle.World;

import java.awt.*;

public class Main {
    public static final int worldWidth = 1000;
    public static final int worldHeight = 1000;

    private static World world = new World(worldWidth, worldHeight);
    private static Turtle t = new Turtle(world);
    private static Asterick ast1 = new Asterick(t, 5, 100, Color.BLACK, worldWidth/2, worldHeight/2);
    private static Polygon pol1 = new Polygon(t, 5, 100, Color.BLACK, worldWidth/2, worldHeight/2);
    private static Pinwheel pin1 = new Pinwheel(t, 5, 100, Color.BLACK, worldWidth/2, worldHeight/2);
    public static void main(String[] args) {
        t.setVisible(false);
        Turtle t = new Turtle(world);
        t.setVisible(false);
        drawAllTest();
        world.setVisible(true);
    }
    public static void drawAllTest(){
        ast1.draw();
        pol1.draw();
        pin1.draw();
        Polygon pol2 = new Polygon(t, 36, 100, Color.BLACK, worldWidth/2, worldHeight/2);
        pol2.draw();
    }
    public static void drawShapes(int sides, int size, boolean drawAll){

    }
    public static void drawShapes(int sides, int size, boolean drawAll, boolean drawAst, boolean drawPol, boolean drawPin, boolean drawSno){

    }

}
