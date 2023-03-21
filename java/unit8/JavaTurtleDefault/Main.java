package unit8.JavaTurtleDefault;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import java.math.*;

public class Main {
    public static final int canvasW = 500;
    public static final int canvasH = 500;
    public static final int houseW = 200;
    public static final int houseH = 150;


    public static void main(String[] args) {

        World world = new World(canvasW, canvasH);
        Turtle t = new Turtle(world);
        t.hide();
        t.setPenColor(Color.BLACK);
//        drawHouse(canvasW / 2, canvasH / 2, houseW, houseH, t);
        circ(canvasW / 2, canvasH / 2, 100, t);
    }

    public static void drawHouse(int x, int y, int w, int h, Turtle t) {
        final int houseY = y;
        drawBody(x, y, w, h, t);
        drawRoof(x, y - h / 2, (int) (w * 1.5), (int) (h * 0.5), t);
        drawWindow((int) (0.8 * x), (int) (0.95 * y), 50, 40, t);
        drawDoor((int) (1.2 * x), y, (int) (w / 3), (int) (h / 1.5), t);
    }

    public static void drawBody(int x, int y, int w, int h, Turtle t) {
        rect(x, y, w, h, t);
    }

    public static void drawRoof(int x, int y, int w, int h, Turtle t) {
        t.penUp();
        t.moveTo(x - w / 2, y);
        t.penDown();
        t.moveTo(x, y - h);
        t.moveTo(x + w / 2, y);
        t.moveTo(x - w / 2, y);
        t.penUp();
    }

    public static void drawWindow(int x, int y, int w, int h, Turtle t) {
        t.penUp();
        t.moveTo(x, y - h / 2);
        t.penDown();
        t.moveTo(x, y + h / 2);
        t.penUp();
        t.moveTo(x - w / 2, y);
        t.penDown();
        t.moveTo(x + w / 2, y);
        rect(x, y, w, h, t);
    }

    public static void drawDoor(int x, int y, int w, int h, Turtle t) {
        y = (int) ((canvasW / 2) + (houseH / 2) - (h / 2));
        rect(x, y, w, h, t);
        circ(x, y, 100, t);
    }

    public static void rect(int x, int y, int w, int h, Turtle t) {
        t.penUp();
        t.moveTo(x - w / 2, y - h / 2);
        t.penDown();
        t.turnRight();
        t.forward(w);
        t.turnRight();
        t.forward(h);
        t.turnRight();
        t.forward(w);
        t.turnRight();
        t.forward(h);
        t.penUp();
    }

    public static void circ(int x, int y, int r, Turtle t) {
        t.penUp();
        t.moveTo(x, y - r);
        t.penDown();
        for (int i = 0; i <= 360; i += 5) {
            double circX = r * Math.sin(Math.toRadians(i));
            double circY = r * Math.cos(Math.toRadians(i));
            t.moveTo((int) (x + circX), (int) (y + circY));
        }
        t.penUp();
        t.show();
    }
}