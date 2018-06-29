import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Stock extends JPanel{
	ArrayList<Double> a,mv;
	int window_size = 5;

	public Stock() {
		a = new ArrayList<Double>();
		try{
			File f = new File("C:\\Users\\Administrator.MMTYOYDSVM1GISI\\Desktop\\PTT.txt");
			Scanner sc = new Scanner(f);
			while(sc.hasNext())
			{
				String s = sc.nextLine();
				double x =Double.parseDouble(s);
				a.add(x);
			}
			sc.close();
		}
		catch(Exception e){e.printStackTrace();}
		mv = new ArrayList<Double>();
		for(int k = 0;k<a.size();k++)
		{
			if(k<window_size)
			{
				mv.add(0.0);
			}
			else
			{
				double sum = 0;
				for(int i =k-window_size;i<k;i++)
				{
					sum += a.get(i);					
				}
				double avg = sum/window_size;
				mv.add(avg);
			}
		}
		JFrame f = new JFrame();
		f.add(this);
		f.setSize(1000,700);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		for(int i = 1;i<a.size();i++)
		{
			g.drawLine((i-1)*2,(int)(700-a.get(i-1)*1), (i*2),(int)(700-a.get(i)*1));
		}
		g.setColor(Color.RED);
		for(int i =1;i<mv.size();i++)
		{
			g.drawLine((i-1)*2, (int)(700-mv.get(i-1)*1), (i*2),(int)(700-mv.get(i)*1));
		}
	}
	public static void main(String []args)
	{
		new Stock();
	}
}
