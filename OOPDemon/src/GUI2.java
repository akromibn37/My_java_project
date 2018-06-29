import javax.swing.JPanel;

public class GUI2 extends JPanel
{
	Ball [] balls;
	Rect [] rects;
	Star [] stars;
	
	public GUI2()
	{
		balls = new Ball[10];
		rects = new Rect[10];
		stars = new Star[10];
		for(int i =0;i<balls.length;i++)
		{
			balls[i] = new Ball();
		}
		for(int i =0;i<rects.length;i++)
		{
			rects[i] = new Rect();
		}
		for(int i =0;i<stars.length;i++)
		{
			stars[i] = new Star();
		}
	}
	
}
