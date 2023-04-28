package unit9.JavaSwingTurtle.Shapes;

import unit9.JavaSwingTurtle.Turtle.Turtle;

import java.awt.*;

public class Pinwheel {
    private final int centerX, centerY;
    Turtle t;
    private Color color;
    private final int sides, size;
    public Pinwheel(Turtle it, int isides, int isize, Color icolor, int icenterX, int icenterY){
        t = it;
        sides = isides;
        size = isize;
        color = icolor;
        centerX = icenterX;
        centerY = icenterY;
    }
    public Pinwheel(Turtle it, int isides, int isize){
        this(it,isides, isize,Color.BLACK);
    }
    public Pinwheel(Turtle it, int isides, int isize, Color icolor){
        this(it,isides, isize, icolor, 0, 0);
    }
    public void draw(){
        t.setPenColor(color);
        t.penUp();
        t.moveTo(centerX, centerY);
        t.setHeading(0);
        t.forward(size/2);
        t.penDown();
        t.turn(90+180/sides);
        int sidelength = (int)((size*size*Math.sin(Math.toRadians(360/sides)))/(size*Math.cos(Math.toRadians(180/sides))));
        System.out.println(sidelength);
        System.out.println(2*size*size*(1-Math.cos(Math.toRadians(360/sides))));
        for (double i = 0; i < sides; i++) {
            t.forward(sidelength);
            t.backward(sidelength/2);
            t.turn(360/sides);
        }
        t.penUp();
    }
}
