import java.awt.Color;
import java.awt.Graphics;

public class Star extends Ball{
	public void draw(Graphics g) {
		g.setColor(new Color(R, G, B));
		g.fillRect((int) pos.getX() - Size, (int) pos.getY() - Size, 2 * Size, 2 * Size);
	}


}
