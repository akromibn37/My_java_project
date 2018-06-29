import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class clock2 extends JPanel implements Runnable{
	Thread thread = null;
	static SimpleDateFormat formatter = new SimpleDateFormat("s", Locale.getDefault());
	Date currentDate;
	int xcenter = 175, ycenter = 175, lastxs = 0, lastys = 0, lastxm = 0, lastym = 0, lastxh = 0, lastyh = 0;
	
	public void draws(Graphics g2d)
	{		
		g2d.setFont(new Font("TimesNewRoman", Font.BOLD, 18));
		g2d.setColor(Color.BLACK);
		g2d.fillOval(xcenter-150, ycenter-150, 300, 300);
		g2d.setColor(Color.red);
		g2d.drawString("My new clock", xcenter-55, ycenter+80);
		g2d.setColor(Color.white);		
		g2d.fillRect(xcenter-150, ycenter, 15, 2);
		g2d.fillRect(xcenter+135, ycenter, 15, 2);
		g2d.fillRect(xcenter, ycenter-150, 2, 15);
		g2d.fillRect(xcenter, ycenter+135, 2,15);
		g2d.drawString("12", xcenter-8, ycenter-120);
		g2d.drawString("6", xcenter-3, ycenter+132);
		g2d.drawString("3", xcenter+122, ycenter+5);
		g2d.drawString("9", xcenter-133, ycenter+5);
	}
	
	public void paint(Graphics g)
	{
		int xhour,yhour,xminute,yminute,xsecond,ysecond,hour,minute,second;
		draws(g);
		currentDate = new Date();
		formatter.applyPattern("s");
		second = Integer.parseInt(formatter.format(currentDate));
		formatter.applyPattern("m");
		minute = Integer.parseInt(formatter.format(currentDate));
		formatter.applyPattern("h");
		hour = Integer.parseInt(formatter.format(currentDate));
		xsecond = (int)(Math.cos((second * Math.PI / 30) - (Math.PI / 2))*120 +xcenter);
		ysecond = (int)(Math.sin((second * Math.PI / 30) - (Math.PI / 2))*120 +ycenter);
		xminute = (int)(Math.cos((minute * Math.PI / 30) - (Math.PI / 2))*100 +xcenter);
		yminute = (int)(Math.sin((minute * Math.PI / 30) - (Math.PI / 2))*100 +ycenter);
//		xhour = (int) (Math.cos((hour*Math.PI/6) + (minute*Math.PI/72)+(Math.PI)) * 80 + xcenter);
//		yhour = (int) (Math.sin((hour*Math.PI/6) + (minute*Math.PI/72)+(Math.PI)) * 80 + ycenter);
		xhour = (int) (Math.cos((hour * 30 + minute / 2) * 3.14f / 180 - 3.14f / 2) * 80 + xcenter);
		yhour = (int) (Math.sin((hour * 30 + minute / 2) * 3.14f / 180 - 3.14f / 2) * 80 + ycenter);
		
//		for(int i = 1;(i<15) && (i!=15) && (i!=30)&&(i!=45);i++)
//		{
//			int xminutetype = (int)(Math.cos((i * Math.PI / 30) - (Math.PI / 2))*120 +xcenter);
//			int yminutetype = (int)(Math.sin((i * Math.PI / 30) - (Math.PI / 2))*120 +ycenter);
//			if(i<15)
//			{
//				g.drawLine(xcenter + 100, ycenter - 100, xminutetype ,yminutetype);
//			}
//			else if(i<30)
//			{
//				g.drawLine(xcenter + 120, ycenter + 120, xminutetype ,yminutetype);
//			}
//			else if(i<45)
//			{
//				g.drawLine(xcenter - 120, ycenter + 120, xminutetype ,yminutetype);
//			}
//			else
//			{
//				g.drawLine(xcenter - 120, ycenter - 120, xminutetype ,yminutetype);
//			}
//		}
		g.setColor(Color.white);
		g.drawLine(xcenter, ycenter, xsecond, ysecond);
		g.setColor(Color.red);
		g.drawLine(xcenter, ycenter, xminute, yminute);
		g.setColor(Color.GREEN);
		g.drawLine(xcenter, ycenter, xhour, yhour);
		g.drawLine(xcenter, ycenter, xhour, yhour);
		
		
		
	}
	
	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	public void stop() {
		thread = null;
	}

	public void run() {
		while (thread != null) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			repaint();
		}
		thread = null;
	}
	
	public static void main(String[] args)
	{
		JFrame f = new JFrame("Clock");
		f.setSize(425,425);
		f.setBounds(20, 100, 400, 400);
		f.setBackground(Color.cyan);
		clock2 ck =new clock2();
		f.getContentPane().add(ck);
		f.setVisible(true);	
		ck.start();
	
	
	}

	
}
