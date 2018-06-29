import java.awt.Color;
import java.awt.Graphics;

public class Star extends Ball{

	public void draw(Graphics g)
	{	
		g.setColor(new Color(R,G,B,255));// 120 is alpha value to make ball transparent 
		int n = 5;
		int []x = new int[n*2];
		int []y = new int[n*2];
		
		for(int i=0;i<n*2;i++)
		{
			x[i] = (int)(pos.x + Size*Math.cos(i*Math.PI/n));
			y[i] = (int)(pos.y + Size*Math.sin(i*Math.PI/n));
			i++;
			x[i] = (int)(pos.x + Size/2*Math.cos(i*Math.PI/n));
			y[i] = (int)(pos.y + Size/2*Math.sin(i*Math.PI/n));
			
		}
		g.fillPolygon(x, y, n*2);
		
	}
}
