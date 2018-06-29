import java.awt.Color;
import java.awt.Graphics;
/**
 * 
 * @author Administrator
 * สามารถ add comment ได้ตรงนี้
 *
 */

public class Ball {
	public int R,G,B,Size;
	public Vector pos,vel;
	
	public Ball() {
		// TODO Auto-generated constructor stub
		R = (int)(Math.random()*255);
		G = (int)(Math.random()*255);
		B = (int)(Math.random()*255);
		Size = (int)(Math.random()*200);
		pos = new Vector((int)(Math.random()*500),(int)(Math.random()*500));
		vel = new Vector((int)(Math.random()*10-5),(int)(Math.random()*10-5));
	}
	public void draw(Graphics g)
	{	
		g.setColor(new Color(R,G,B,120));// 200 is alpha value to make ball transparent 
		g.fillOval((int)pos.x, (int)pos.y, Size, Size);		
	}
	public void move()
	{
		pos = pos.add(vel.mul(Math.random()*2));
		if(pos.x + Size >1000)
		{
			pos.x = 1000-Size;
			vel.x*=-1;
			R+=102;
			if(R>255) R=255;
			G-=102;
			if(G<0) G=0;
			B-=102;
			if(B<0) B=0;
		}
		if(pos.x < 0)
		{
			pos.x =0;
			vel.x*=-1;
			R+=102;
			if(R>255) R=255;
			G-=102;
			if(G<0) G=0;
			B-=102;
			if(B<0) B=0;
		}
		if(pos.y + Size >1000)
		{
			pos.y = 1000-Size;
			vel.y*=-1;
			R+=102;
			if(R>255) R=255;
			G-=102;
			if(G<0) G=0;
			B-=102;
			if(B<0) B=0;
		}
		if(pos.y < 0)
		{
			pos.y =0;
			vel.y*=-1;
			R+=102;
			if(R>255) R=255;
			G-=102;
			if(G<0) G=0;
			B-=102;
			if(B<0) B=0;
		}
	}

}