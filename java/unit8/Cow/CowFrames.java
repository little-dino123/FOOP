package unit8.Cow;

import java.awt.*;
import javax.swing.JFrame;

public class CowFrames extends JFrame {
	private final Color BISQUE = new Color(0xcdb79e);
	private final Color GRASS = new Color(0x7ec236);
	private final int OFFSET = -300;

	public CowFrames () {
		init();
	}
	
	public void init() {
		setSize(350,200);
		setBackground(GRASS);
		repaint();
	}
	public void drawLegs(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(400+OFFSET,140,10,50);
		g.fillRect(490+OFFSET,140,10,50);

	}
	public void paint(Graphics g) {
		g.setColor(BISQUE);
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(350+OFFSET, 50, 200, 100);
		g.setColor(Color.WHITE);
		g.fillOval(340+OFFSET, 50, 60, 40);
		drawLegs(g);



    //advanced
    //make a triangle/any other shape
    //g.drawPolygon(new int[] {1, 10, 20}, new int[] {1, 10, 20}, 3);
    //2D graphics so you can change rotation
    //Graphics2D g2 = (Graphics2D) g; //put at top of paint function
    //g2.rotate(Math.toRadians(45)); //put BEFORE you draw
	}
}