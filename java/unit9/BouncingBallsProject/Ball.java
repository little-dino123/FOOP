package unit9.BouncingBallsProject;
/*
 * You will need to alter code in this class!
 * First, make sure a single ball bounces
 * around the screen correctly.
 * Add collisions between the multiple objects.
 */

import java.awt.*;

import static java.lang.Math.*;

public class Ball {
    public double x, y;           // Ball's center x and y
    public double speedX, speedY; // Ball's speed per step in x and y
    public double radius;
    private Color color;


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
        // Next step
        this.x += speedX;
        this.y += speedY;
        bounceOffSide(box);
    }

    public void bounceOffSide(ContainerBox box) {
        this.x += speedX;
        this.y += speedY;
        if (x <= box.minX || x + 2 * radius >= box.maxX) {
            x -= speedX;
            speedX *= -1;
        }
        if (y <= box.minY || y + 2 * radius >= box.maxY) {
            y -= speedY;
            speedY *= -1;
        }
    }

    public void collides(Ball b2) {
        if (checkColliding(b2)) {
            collideActual(b2);
            //complexCollide(b2);
        }
    }

    public boolean checkColliding(Ball b2) {
        double x1 = x + radius;
        double y1 = y + radius;
        double x2 = b2.x + b2.radius;
        double y2 = b2.y + b2.radius;
        double r1 = radius;
        double r2 = b2.radius;
        double dist = sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
        return dist <= r1 + r2;
    }

    public void collideActual(Ball b2) {
        double b1vx = speedX;
        double b1vy = speedY;
        speedX = b2.speedX;
        speedY = b2.speedY;
        b2.speedX = b1vx;
        b2.speedY = b1vy;
        x += speedX;
        y += speedY;
        b2.x += b2.speedX;
        b2.y += b2.speedY;

    }

    public void complexCollide(Ball b2) {
        double x1, y1, x2, y2;
        x1 = x + radius;
        y1 = y + radius;
        x2 = b2.x + b2.radius;
        y2 = b2.y + b2.radius;
        double x1s, y1s, v1, x2s, y2s, v2;
        x1s = speedX;
        y1s = speedY;
        v1 = getSpeed();
        x2s = b2.speedX;
        y2s = b2.speedY;
        v2 = b2.getSpeed();
        double d1, d2, normalDir;
        d1 = toDegrees(atan(x1s / y1s));
        d2 = toDegrees(atan(x2s / y2s));
        normalDir = toDegrees(atan((x2 - x1) / (y2 - y1)));
        double newd1, newd2;
        newd1 = normalDir + (d1 - normalDir);
        newd2 = -normalDir + (d2 + normalDir);
        double newx1s, newy1s, newx2s, newy2s;
        newx1s = sin(toRadians(newd1)) * v1;
        newy1s = cos(toRadians(newd1)) * v1;
        newx2s = sin(toRadians(newd2)) * v2;
        newy2s = cos(toRadians(newd2)) * v2;
//        System.out.println("x1 "+x1+" y1 "+y1+" x2 "+x2+" y2 "+y2);
//        System.out.println("d1 "+d1+" d2 "+d2);
//        System.out.println("normal "+normalDir);
//        System.out.println("newd1 "+newd1+" newd2 "+newd2);
//        System.out.println("x1s "+x1s+" y1s "+y1s+" x2s "+x2s+" y2s "+y2s);
//        System.out.println("newx1s "+newx1s+" newy1s "+newy1s+" newx2s "+newx2s+" newy2s "+newy2s);
        speedX = newx1s;
        speedY = newy1s;
        b2.speedX = newx2s;
        b2.speedY = newy2s;
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