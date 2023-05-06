package unit9.BouncingBallsProject;
/*
 * You will need to alter code in this class!
 * This contains control logic and main display panel for the objects.
 * * Add a second ball in here - understand how the first
 * one is made and make at least one more
 * Don't forget the update class to get detection between objects
 */

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class BallWorld extends JPanel {
    private static final int UPDATE_RATE = Config.frameRate;  // Frames per second (fps)
    private ArrayList<Ball> ballArray = new ArrayList<>();
    private ContainerBox box;  // The container... rectangular box

    private DrawCanvas canvas; // Custom canvas for drawing the box/ball
    private int canvasWidth, canvasHeight;

    /**
     * Constructor to create the UI components and init the game objects.
     * Set the drawing canvas to fill the screen (given its width and height).
     */

    public BallWorld() {

        canvasWidth = Config.canvasDimensions[0];
        canvasHeight = Config.canvasDimensions[1];

        // Initiate the ball at a random location (inside the box)
        Random rand = new Random();
        int radius = Config.ballRadius;
        for (int i = 0; i < Config.numberOfBalls; i++) {
            int x = rand.nextInt(canvasWidth - (radius * 2));
            int y = rand.nextInt(canvasHeight - (radius * 2));
            int angle = rand.nextInt(360);
            int speed = Config.ballSpeed == 0 ? rand.nextInt(5) + 2 : Config.ballSpeed;
            Color color = hsvToColor(rand.nextInt(360), 100, 100);
            ballArray.add(new Ball(x, y, radius, speed, angle, color));
        }
        // Initialize the Container to fill the screen
        box = new ContainerBox(0, 0, canvasWidth, canvasHeight, Config.backGroundColor, Config.borderColor);

        // Initialize the custom drawing panel
        canvas = new DrawCanvas();
        this.setLayout(new BorderLayout());
        this.add(canvas, BorderLayout.CENTER);

        // Handling window resize
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Component c = (Component) e.getSource();
                Dimension dim = c.getSize();
                canvasWidth = dim.width;
                canvasHeight = dim.height;
                // Adjust the bounds of the container to fill the window
                box.set(0, 0, canvasWidth, canvasHeight);
            }
        });

        // Start the ball bouncing
        bounce();
    }

    /**
     * Start the ball bouncing.
     */
    public void bounce() {
        // Run the game logic in its own thread.
        Thread thread = new Thread() {
            public void run() {
                while (true) {
                    // Calculate what happens next
                    update();
                    // Refresh the display
                    repaint();
                    // Makes the program slow down so things can be drawn properly
                    try {
                        Thread.sleep(1000 / UPDATE_RATE);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        thread.start();  // start the thread for graphics
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

    /**
     * One time-step.
     * Update the objects, with collision detection and response
     */
    public void update() {
        for (int i = 0; i < ballArray.size(); i++) {
            Ball ball = ballArray.get(i);
            ball.moveOneStepWithCollisionDetection(box);
            for (int j = i + 1; j < ballArray.size(); j++) {
                Ball ball2 = ballArray.get(j);
                ball.collides(ball2);
            }
        }
    }

    /**
     * The custom drawing panel for the bouncing ball (inner class).
     */
    class DrawCanvas extends JPanel {
        /**
         * Custom drawing codes
         */
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);    // Paint background
            // Draw the box and the ball
            box.draw(g);
            for (Ball ball : ballArray) {
                ball.draw(g);
            }
        }

        /**
         * Called back to get the preferred size of the component.
         */
        @Override
        public Dimension getPreferredSize() {
            return (new Dimension(canvasWidth, canvasHeight));
        }
    }
}