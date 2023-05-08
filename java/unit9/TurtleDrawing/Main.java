package unit9.TurtleDrawing;

import unit9.TurtleDrawing.Turtle.Turtle;
import unit9.TurtleDrawing.Turtle.World;

import java.awt.*;
import java.util.ArrayList;

import static unit9.TurtleDrawing.TypeOfShape.*;

public class Main {
    public static final int worldWidth = Config.canvasSize;
    public static final int worldHeight = Config.canvasSize;
    private static final int radius = Config.radius;
    private static final int numberOfSides = Config.numberOfSides;
    private static final Color shapeColor = Config.shapeColor;
    private static final World world = new World(worldWidth, worldHeight);
    private static final Turtle t = new Turtle(world);
    private static final ArrayList<Shapes> shapeList = new ArrayList<>();
    private static final ArrayList<Shapes> rainbowCircleList = new ArrayList<>();
    private static final ArrayList<Shapes> colorWheel = new ArrayList<>();


    public static void main(String[] args) {
        t.setVisible(false);
        world.setVisible(true);
        makeShapes();
        // Choose what you want to draw, rainbowCircleList is a gradient circle, colorWheel is a color wheel, and shapeList is just showcasing the 4 shapes
        drawAll(colorWheel);
    }

    public static void drawAll(ArrayList<Shapes> array) {
        for (Shapes shape : array) {
            shape.draw();
        }
        System.out.println("done");
    }

    public static void makeShapes() {
        makeRainbowCircle();
        makeColorWheel();
        shapeList.add(new Shapes(t, Config.numberOfSides, Config.radius, 0, POLYGON, Config.shapeColor, Config.rainbowYN, Config.canvasSize / 4, Config.canvasSize / 4));
        shapeList.add(new Shapes(t, Config.numberOfSides, Config.radius, 0, ASTERICK, Config.shapeColor, Config.rainbowYN, 3 * Config.canvasSize / 4, Config.canvasSize / 4));
        shapeList.add(new Shapes(t, Config.numberOfSides, Config.radius, 0, PINWHEEL, Config.shapeColor, Config.rainbowYN, Config.canvasSize / 4, 3 * Config.canvasSize / 4));
        shapeList.add(new Shapes(t, Config.numberOfSides, Config.radius, 0, SNOWFLAKE, Config.shapeColor, Config.rainbowYN, 3 * Config.canvasSize / 4, 3 * Config.canvasSize / 4));
    }

    public static void makeRainbowCircle() {
        double rad = Config.canvasSize / 2d - 1;
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < rad; j += 2) {
                rainbowCircleList.add(new Shapes(t, i, j, 0, POLYGON, hsvToColor(j / rad * 360, 100, 100), false));
            }
        }
    }

    public static void makeColorWheel() {
        double rad = Config.canvasSize / 2d - 1;
//        for (int i = 0; i <= rad; i += 1) {
//            colorWheel.add(new Shapes(t, 360, i, 0, POLYGON, hsvToColor(i / rad * 360, 100, 100), true));
//        }
        int sides = 4;
        for (double i = 0; i < 360d/sides; i += 0.001) {
            colorWheel.add(new Shapes(t, sides, (int)rad, i, ASTERICK, Color.BLACK, true));
        }
    }

    public static Color hsvToColor(double h, double s, double v) {
        s = s / 100;
        v = v / 100;
        double c = v * s;
        double x = c * (1 - Math.abs((h / 60) % 2 - 1));
        double m = v - c;
        double r, g, b;
        if (h < 0 || h >= 360) {
            return new Color(255, 0, 0);
        } else if (0 <= h && h < 60) {
            r = c;
            g = x;
            b = 0;
        } else if (60 <= h && h < 120) {
            r = x;
            g = c;
            b = 0;
        } else if (120 <= h && h < 180) {
            r = 0;
            g = c;
            b = x;
        } else if (180 <= h && h < 240) {
            r = 0;
            g = x;
            b = c;
        } else if (240 <= h && h < 300) {
            r = x;
            g = 0;
            b = c;
        } else if (300 <= h && h < 360) {
            r = c;
            g = 0;
            b = x;
        } else return Color.BLACK;
        return new Color((int) ((r + m) * 255), (int) ((g + m) * 255), (int) ((b + m) * 255));
    }
}
