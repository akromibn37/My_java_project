import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;

public class Ex3_263_8 extends JFrame {

		public Rectangle2D rect;
		public Ex3_263_8()
		{
			setSize(1000,2500);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
		}
		public void paint(Graphics g)//Draw on monitor
		{
			super.paint(g);
			for(int i =0;i<100;i++)
			{
				for(int j=0;j<100;j++){
					Graphics2D g2d = (Graphics2D)(g);
		            g2d.setColor(Color.ORANGE);
		            rect = new Rectangle2D.Double(j*50, i*20, 50, 20);
		            g2d.fill(rect);
		            g.setColor(Color.BLACK);
		            g.drawRect(j*50, i*20, 50, 20);
				}
				i++;
				for(int j=0;j<100;j++){
					Graphics2D g2d = (Graphics2D)(g);
		            g2d.setColor(Color.yellow);
		            rect = new Rectangle2D.Double(j*50+25, i*20, 50, 20);
		            g2d.fill(rect);
		            g.setColor(Color.BLACK);
					g.drawRect(j*50+25, i*20, 50, 20);
					
				}
			}
			
		}

		public static void main(String[] args) {			
			new Ex3_263_8();
		}
	

}
