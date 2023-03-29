package unit8.Classwork.JavaTurtleDefault;

import java.awt.*;

public class Main {
    public static final int canvasW = 1000;
    public static final int canvasH = 1000;
    public static final int houseW = (int) (canvasW * 0.6);
    public static final int houseH = (int) (canvasW * 0.45);
    public static final int houseX = canvasW / 2;
    public static final int houseY = (int) (canvasH * 1.2 / 2);
    public static final int ground = houseY + houseH / 2;

    public static void main(String[] args) {
        Turtle t = new Turtle(new World(canvasW, canvasH));
        t.hide();
        drawHouse(houseX, houseY, houseW, houseH, t);
    }

    public static void drawHouse(int x, int y, int w, int h, Turtle t) {
        t.setPenColor(Color.BLACK);
        drawBody(x, y, w, h, t);
        drawRoof(x, y - h / 2, (int) (w * 5 / 3), (int) (h * 2 / 3), t);
        drawWindow((int) (0.75 * x), (int) (0.95 * y), (int) (w / 3), (int) (h / 3), t);
        drawDoor((int) (1.35 * x), y, (int) (w / 3), (int) (h / 1.35), t);
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
        y = (int) (ground - (h / 2));
        rect(x, y, w, h, t);
        circ(x - w / 3, (int) (y * 0.95), (int) (x / 50), t);
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
        t.moveTo(x, y + r);
        t.penDown();
        for (int i = 0; i <= 360; i += 5) {
            double circX = r * Math.sin(Math.toRadians(i));
            double circY = r * Math.cos(Math.toRadians(i));
            t.moveTo((int) (x + circX), (int) (y + circY));
        }
        t.penUp();
    }
}