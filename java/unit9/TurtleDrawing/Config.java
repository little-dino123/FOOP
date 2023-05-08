package unit9.TurtleDrawing;

import java.awt.*;

/**
 * IMPORTANT:
 * All of the below don't affect the rainbow and the color wheel EXCEPT canvasSide, the only apply to the 4 predefined shapes
 * <p>
 * See the main method in Main.java for instruction to see some other demos
 * <p>
 * camvasSize: defines the length of one of the sides of the canvas. The canvas will always be square
 * numberOfSides: defines how many sides the shapes will have.
 * radius: defines the radius of the shapes. NOTE: This is not side length, calculations are taken to get siode length from this.
 * shapeColor: defines the color of the shapes. NOTE: Is overrriden by rainbowYN
 * rainbowYN: defines whether the shapes will be rainbow. NOTE: Overrides shapeColor
 */
public class Config {
    public static final int canvasSize = 800;
    public static final int numberOfSides = 5;
    public static final int radius = canvasSize / 5;
    public static final Color shapeColor = Color.BLACK;
    public static final boolean rainbowYN = true;

}
