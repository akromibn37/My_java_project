import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Monster
{
	public int posx,posy;
	public BufferedImage img;
	
	public Monster()
	{}
	
	public Monster(File x,int y) throws IOException
	{
		posx = 20;
		if(y == 1)
		{
			posy = 60;
		}		
		else if(y == 2)
		{
			posy = 200;
		}
		else
		{
			posy = 330;
		}

		img = ImageIO.read(x);
	}
	public int getposx(Monster x)
	{
		return posx;
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(img, posx, posy, 100, 100, null);
		
	}
	public void move()
	{
		posx = posx + (int) (Math.random() * 7);
	}
	
}
