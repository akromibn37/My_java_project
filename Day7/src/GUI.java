import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JPanel
{
	Ball[] balls;
	//Rect[] rects;
	//Star[] stars; Because polymorphism
	
	public GUI()
	{
		balls = new Ball[30];
		for(int i =0;i<10;i++)
		{
			balls[i] = new Ball();
		}		
		for(int i =10;i<20;i++)
		{
			balls[i] = new Rect();
		}		
		for(int i =20;i<30;i++)
		{
			balls[i] = new Star();
		}
		Thread t =new Thread(new Runnable()
		{
			public void run()
			{
				while(true)
				{
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {					
						e.printStackTrace();
					}
					for(int i=0;i<balls.length;i++)
					{
						balls[i].move();
					}					
					repaint();
				}
			}
		});
		t.start();
		JFrame f = new JFrame();
		f.add(this);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000, 1000);
		f.setVisible(true);
	}
	public void paint(Graphics g){
		super.paint(g);
		for(int i=0;i<balls.length;i++){
			balls[i].draw(g);
		}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI();
	}
}
