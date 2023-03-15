import java.awt.*;
import javax.swing.JFrame;

public class CowFrames extends JFrame {
	private final Color BISQUE = new Color(0xcdb79e);
	private final Color CHARTRUSE = new Color(0x7FFF00);
	public CowFrames () {
		init();
	}
	
	public void init() {
		setSize(700,600);
		setBackground(Color.BLUE);
		repaint();
	}
	
	public void paint(Graphics g) {
    g.setColor(BISQUE);
		//g.setColor(CHARTRUSE);
		g.fillRect(0, 0, 400, 200);
		g.setColor(Color.ORANGE);
		g.drawOval(350, 50, 200, 100);
    g.setColor(Color.BLACK);
    g.fillOval(355, 55, 25, 60);


    //advanced
    //make a triangle/any other shape
    //g.drawPolygon(new int[] {1, 10, 20}, new int[] {1, 10, 20}, 3);
    //2D graphics so you can change rotation
    //Graphics2D g2 = (Graphics2D) g; //put at top of paint function
    //g2.rotate(Math.toRadians(45)); //put BEFORE you draw
	}
}