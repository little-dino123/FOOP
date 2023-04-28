package unit9.JavaSwingTurtle.Shapes;

import unit9.JavaSwingTurtle.Turtle.Turtle;

import java.awt.*;

public class Asterick {
    private final int centerX, centerY;
    Turtle t;
    private Color color;
    private final int sides, size;
    public Asterick(Turtle it, int isides, int isize, Color icolor, int icenterX, int icenterY){
        t = it;
        sides = isides;
        size = isize;
        color = icolor;
        centerX = icenterX;
        centerY = icenterY;
    }
    public Asterick(Turtle it, int isides,int isize){
        this(it,isides, isize,Color.BLACK);
    }
    public Asterick(Turtle it,int isides,int isize, Color icolor){
        this(it,isides, isize, icolor, 0, 0);
    }
    public void draw(){
        t.setPenColor(color);
        t.penUp();
        t.moveTo(centerX, centerY);
        t.penDown();
        for (double i = 0; i < sides; i++) {
            t.setHeading(360*i/sides);
            t.forward(size);
            t.moveTo(centerX,centerY);
        }
        t.penUp();
    }
}
