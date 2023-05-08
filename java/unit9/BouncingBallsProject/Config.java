package unit9.BouncingBallsProject;

import java.awt.*;

public class Config {
    /**
     * set the number of balls simulated
     */
    public static final int numberOfBalls = 20;
    /**
     * set the radius of the balls
     */
    public static final int ballRadius = 25;
    /**
     * set the size of the world in pixels, (x, y)
     */
    public static final int[] canvasDimensions = new int[]{1000, 1000};
    /**
     * ballSpeed, if set to 0, it will be a random int in range [2,7)
     */
    public static final int ballSpeed = 0;
    /**
     * set the background color of the canvas
     */
    public static final Color backGroundColor = Color.BLACK;
    /**
     * set the border color
     */
    public static final Color borderColor = Color.DARK_GRAY;
    public static final int frameRate = 60;

}
