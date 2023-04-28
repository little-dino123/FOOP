package unit9.BouncingBallsUnfinished;
/*
 * You will need to alter code in this class!
 * First, make sure a single ball bounces
 * around the screen correctly.
 * Add collisions between the multiple objects.
 */

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Formatter;

import static java.lang.Math.*;

public class Ball {
    public double x, y;           // Ball's center x and y
    public double speedX, speedY; // Ball's speed per step in x and y
    public double radius;
    private Color color;

    private double x1,y1,x2,y2,r1,r2,dist;


    /**
     * Constructor to create the ball and it's attributes.
     *
     * @param x             : x coordinate of the center of the ball
     * @param y             : y coordinate of the center of the ball
     * @param radius        : radius of the ball
     * @param speed         : speed the ball will move (converted to x and y components later)
     * @param angleInDegree : direction ball will initially move
     * @param color         : color of the ball
     */
    public Ball(double x, double y, double radius, double speed, double angleInDegree, Color color) {
        //Notice the 'global' variables have the same name as the parameters.
        //Use the .this keyword to signify the 'global' variable
        this.x = x;
        this.y = y;
        // Convert (speed, angle) to (x, y)
        this.speedX = (speed * Math.cos(Math.toRadians(angleInDegree)));
        this.speedY = (-speed * Math.sin(Math.toRadians(angleInDegree)));
        this.radius = radius;
        this.color = color;
    }

    /**
     * Update the graphics on the screen
     *
     * @param g: Graphics object
     */
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int) x, (int) y, (int) (2 * radius), (int) (2 * radius));
    }

    /**
     * Move, check for collisions and react accordingly if collision occurs.
     *
     * @param box: the container (obstacle) for this ball.
     */
    // Used to determine how to reflect off the walls of the screen
    public void moveOneStepWithCollisionDetection(ContainerBox box) {
        // Use the variable box to get the max/min x/y values of the screen
        double minX = box.minX;
        double minY = box.minY;
        double maxX = box.maxX;
        double maxY = box.maxY;
        // Next step
        this.x += speedX;
        this.y += speedY;
        bounceOffSide(box);
    }
    public void bounceOffSide(ContainerBox box){
        this.x += speedX;
        this.y += speedY;
        if (x <= box.minX || x + 2 * radius >= box.maxX) {
            speedX *= -1;
        }
        if (y <= box.minY || y + 2 * radius >= box.maxY) {
            speedY *= -1;
        }
    }

    public void collides(Ball b2) {
        // Use this classes x, y, and radius
        // Compare versus the b2.x, b2.y, and b2.radius
        // Determine if they collide and have them bounce off each other
        x1 = x + radius;
        y1 = y + radius;
        x2 = b2.x + b2.radius;
        y2 = b2.y + b2.radius;
        r1 = radius;
        r2 = b2.radius;
        if (checkColliding(b2)) {

        }
    }

    public boolean checkColliding(Ball b2) {
        dist = sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
        return dist < r1 + r2;
    }

    public double returnCollisionAngle(Ball b2) {

        double angleR = atan((y2 - y1) / (x2 - x1));
        double angleD = toDegrees(angleR);
        double b1AngleR = atan(speedY / speedX);
        double b1AngleD = toDegrees(b1AngleR);
        double b2AngleR = atan(b2.speedY / b2.speedX);
        double b2AngleD = toDegrees(b2AngleR);
        // TODO: try to calculate the angle each ball will be after the collision by finding the angle of the collision on the circle, finding the difference to the oppposite of the current direction, then doubleling it and adding it on to the opposite of the original direction to net the final angle
        return 1d;
    }

    /**
     * Return the magnitude of speed.
     */
    public double getSpeed() {
        return Math.sqrt(speedX * speedX + speedY * speedY);
    }

    /**
     * Return the direction of movement in degrees (counter-clockwise).
     */
    public double getMoveAngle() {
        return Math.toDegrees(Math.atan2(-speedY, speedX));
    }
}