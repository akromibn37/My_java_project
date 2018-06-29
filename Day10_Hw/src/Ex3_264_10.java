import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex3_264_10 extends JPanel{

	public Ex3_264_10() 
	{
		JFrame f = new JFrame();
		f.add(this);
		f.setSize(800,500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		 super.paint(g);
		 Graphics2D g2d = (Graphics2D)g;
		 g2d.setColor(Color.black);
		 
		 double d  =  100;
		 double angle = 0;
		 for(int i = 0;i<10;i++)
		 {
			 
			 g2d.rotate((Math.PI *angle)/180);
			 g.drawRect(800, 50, (int)d, (int)d);
			 //g2d.fillRect(500, 300, (int)d, (int)d);			 
			 angle+=10;			
		 }
	}

	public static void main(String[] args) 
	{
		new Ex3_264_10(); 

	}

}
