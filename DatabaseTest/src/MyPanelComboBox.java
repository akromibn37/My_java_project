import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyPanelComboBox extends JPanel 
{
	
	public void paint(Graphics g)
	{
		g.setColor(Color.red);
		g.fillOval(0, 0, 20, 20);
	}
}
