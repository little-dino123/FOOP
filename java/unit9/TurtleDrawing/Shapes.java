package unit9.TurtleDrawing;

import unit9.TurtleDrawing.Turtle.Turtle;

import java.awt.*;

public class Shapes {
    private final int centerX, centerY;
    private final Turtle t;
    private final TypeOfShape shape;
    private final Color color;
    private final int sides, size;
    private final double heading;
    private final boolean rainbow;

    public Shapes(Turtle t, int sides, int size, double heading, TypeOfShape shape, Color color, boolean rainbow, int centerX, int centerY) {
        this.t = t;
        this.sides = sides;
        this.size = size;
        this.heading = heading;
        this.shape = shape;
        this.color = color;
        this.rainbow = rainbow;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public Shapes(Turtle t, int sides, int size, double heading, TypeOfShape shape, Color color, boolean rainbow) {
        this(t, sides, size, heading, shape, color, rainbow, Config.canvasSize / 2, Config.canvasSize / 2);
    }

    public Shapes(Turtle t, TypeOfShape shape, boolean rainbow) {
        this(t, Config.numberOfSides, Config.radius, 0, shape, Config.shapeColor, rainbow, Config.canvasSize / 2, Config.canvasSize / 2);
    }

    public void draw() {
        switch (shape) {
            case POLYGON -> drawPolygon();
            case ASTERICK -> drawAsterick();
            case PINWHEEL -> drawPinwheel();
            case SNOWFLAKE -> drawSnowflake();
        }
    }

    public void drawPolygon() {
        t.setPenColor(color);
        t.penUp();
        t.moveTo(centerX, centerY);
        t.setHeading(heading);
        t.forward(size);
        t.penDown();
        t.turn(90 + 180d / sides);
        int sidelength = (int) ((size * size * Math.sin(Math.toRadians(360d / sides))) / (size * Math.cos(Math.toRadians(180d / sides))));
        for (double i = 0; i < sides; i++) {
            if (rainbow) t.setPenColor(hsvToColor(i * 360 / sides, 100, 100));
            t.forward(sidelength);
            t.turn(360d / sides);
        }
        t.penUp();
    }

    public void drawAsterick() {
        t.setPenColor(color);
        t.penUp();
        t.moveTo(centerX, centerY);
        t.setHeading(heading);
        t.penDown();
        for (double i = 0; i < sides; i++) {
            if (rainbow) t.setPenColor(hsvToColor(t.getHeading(), 100, 100));
            t.turn(360d / sides);
            t.forward(size);
            t.moveTo(centerX, centerY);
        }
        t.penUp();
    }

    public void drawPinwheel() {
        t.setPenColor(color);
        t.penUp();
        t.moveTo(centerX, centerY);
        t.setHeading(heading);
        t.forward(size / 2);
        t.penDown();
        t.turn(90 + 180d / sides);
        int sidelength = (int) ((size * size * Math.sin(Math.toRadians(360d / sides))) / (size * Math.cos(Math.toRadians(180d / sides))));
        System.out.println(sidelength);
        System.out.println(2 * size * size * (1 - Math.cos(Math.toRadians(360d / sides))));
        for (double i = 0; i < sides; i++) {
            if (rainbow) t.setPenColor(hsvToColor(i * 360 / sides, 100, 100));
            t.forward(sidelength);
            t.backward(sidelength / 2);
            t.turn(360d / sides);
        }
        t.penUp();
    }

    public void drawSnowflake() {
        t.setPenColor(color);
        t.penUp();
        t.moveTo(centerX, centerY);
        t.setHeading(heading);
        t.penDown();
        for (double i = 0; i < sides; i++) {
            if (rainbow) t.setPenColor(hsvToColor(i * 360 / sides, 100, 100));
            drawTriange(180d / sides, size);
            t.moveTo(centerX, centerY);
            t.turn(360d / sides);
        }
        t.penUp();
    }

    public void drawTriange(double vertexAngle, int longLength) {
        t.turn(-vertexAngle / 2);
        t.forward(longLength);
        t.turn(180 - ((180 - vertexAngle) / 2));
        t.forward((int) (Math.sin(Math.toRadians(vertexAngle / 2)) * longLength * 2));
        t.turn(180 - ((180 - vertexAngle) / 2));
        t.forward(longLength);
        t.turn(180 - (vertexAngle / 2));
    }

    public static Color hsvToColor(double h, double s, double v) {
        s = s / 100;
        v = v / 100;
        double c = v * s;
        double x = c * (1 - Math.abs((h / 60) % 2 - 1));
        double m = v - c;
        double r, g, b;
        if (0 <= h && h < 60) {
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
