import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class J103_Exam_3_1 extends JPanel{
	
	int x[] = new int[20];
	public J103_Exam_3_1() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Administrator.MMTYOYDSVM1GISI\\Desktop\\PTT.txt"));
		try {
			
			int i =0;
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        x[i] = Integer.parseInt(line);
		        i++;
		        line = br.readLine();
		    }
		    
		} finally {
		    br.close();
		}
		System.out.println(Arrays.toString(x));
		JFrame f = new JFrame();
		f.add(this);
		f.setSize(800,500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		int xpos = 60;
		int ypos = 400;
		
		g.setColor(Color.BLACK);
		g.drawLine(50, 400, 50, 50);
		g.drawLine(50, 400, 750, 400);
		for(int i = 0;i<x.length;i++)
		{
			xpos = xpos+30;
			g.setColor(Color.blue);
			g.drawRect(xpos, ypos, 15, -x[i]);
			g.setColor(Color.red);
			g.drawString(String.valueOf(x[i]), xpos-5,x[i]-100);
		}
	}

	
	public static void main(String[] args) throws IOException 
	{
		new J103_Exam_3_1();

	}

}
