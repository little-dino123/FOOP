package unit8.JavaTurtleDefault;

import java.awt.*;
public class Main {
    public static final int canvasW = 500;
    public static final int canvasH = 500;
    public static final int houseW = 200;
    public static final int houseH = 150;
    public static final int houseX = canvasW/2;
    public static final int houseY = canvasH/2 + 100;
    public static final int ground = houseY + houseH / 2;


    public static void main(String[] args) {

        World world = new World(canvasW, canvasH);
        Turtle t = new Turtle(world);
        t.hide();
        t.setPenColor(Color.BLACK);
        drawHouse(houseX, houseY, houseW, houseH, t);
    }

    public static void drawHouse(int x, int y, int w, int h, Turtle t) {
        drawBody(x, y, w, h, t);
        drawRoof(x, y - h / 2, (int) (w*5/3), (int) (h*2/3), t);
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
        y = (int) (ground - (h / 2));
        rect(x, y, w, h, t);
        circ(x-h/5, (int)(y*0.975), 5, t);
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