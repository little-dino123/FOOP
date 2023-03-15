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
	public void drawGrid(Graphics g){
		g.setColor(Color.RED);
		// vertical lines
		for(int i=0; i<350; i=i+10) {
			g.drawLine(i, 0, i, 200);
		}
		//horizontal lines
		for(int j=0; j<200; j=j+10){
			g.drawLine(0,j,350,j);
		}
	}
	public void drawLegs(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(400+OFFSET,140,10,50);
		g.fillRect(490+OFFSET,140,10,50);

	}
	public void drawTail(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(550+OFFSET,100, 25,5);
	}
	public void paint(Graphics g) {
		drawGrid(g);
		g.setColor(BISQUE);
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(350+OFFSET, 50, 200, 100);
		g.setColor(Color.WHITE);
		g.fillOval(340+OFFSET, 50, 60, 40);
		drawLegs(g);
		drawTail(g);



    //advanced
    //make a triangle/any other shape
    //g.drawPolygon(new int[] {1, 10, 20}, new int[] {1, 10, 20}, 3);
    //2D graphics so you can change rotation
    //Graphics2D g2 = (Graphics2D) g; //put at top of paint function
    //g2.rotate(Math.toRadians(45)); //put BEFORE you draw
	}
}