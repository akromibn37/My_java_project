import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI extends JPanel 
{
	public Monster mon1,mon2,mon3;
	
	public GUI()
	{
		File x = new File("C:\\Users\\Administrator.MMTYOYDSVM1GISI\\Desktop\\Shoeshop\\cartoon1.jpg");		
		File y = new File("C:\\Users\\Administrator.MMTYOYDSVM1GISI\\Desktop\\Shoeshop\\cartoon2.jpg");
		File z = new File("C:\\Users\\Administrator.MMTYOYDSVM1GISI\\Desktop\\Shoeshop\\cartoon3.jpg");
		
		try {
			mon1 = new Monster(x,1);
			mon2 = new Monster(y,2);
			mon3 = new Monster(z,3);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        this.setLayout(layout);       
		JButton autoButton = new JButton("Go");
        add(autoButton);
        autoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Thread t = new Thread(new Runnable()
				{

					@Override
					public void run()
					{
						while (true)
						{
							try
							{
								Thread.sleep(20);
							} catch (Exception e)
							{
							}
//							KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(
//							        new KeyEventDispatcher() {
//										
//										@Override
//										public boolean dispatchKeyEvent(KeyEvent e) {
//											// TODO Auto-generated method stub
//											if(e.getID() == KeyEvent.KEY_PRESSED)
//											{
//												if(e.getKeyCode() == 87) //w
//												{
//													mon1.move();
//												}
//												if(e.getKeyCode() == 83) //s
//												{
//													mon2.move();
//												}
//												if(e.getKeyCode() == 88) //x
//												{
//													mon3.move();
//												}
//											}
//											return false;
//										}									
//							    });
							mon1.move();
							mon2.move();
							mon3.move();
							int monx1 = mon1.getposx(mon1);
							int monx2 = mon2.getposx(mon2);
							int monx3 = mon3.getposx(mon3);
							if(monx1 >= 1000 || monx2 >= 1000 || monx3 >= 1000)
							{
								if(monx1 >= 1000)
								{
									JOptionPane.showMessageDialog(GUI.this, "Monster1 Win!!");
								}
								else if(monx2 >= 1000)
								{
									JOptionPane.showMessageDialog(GUI.this, "Monster2 Win!!");
								}
								else
								{
									JOptionPane.showMessageDialog(GUI.this, "Monster3 Win!!");
								}
								System.exit(1000);
							}					
							repaint();
						}
					}
				});
				t.start();
				
			}          
        });
    
		
		
		JFrame f = new JFrame();
		f.add(this);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1100, 500);
		f.setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.RED);
		g.fillRect(1000, 0, 10, 500);
		mon1.draw(g);
		mon2.draw(g);
		mon3.draw(g);		
	}
	
	public static void main(String [] args) //throws IOException
	{
		new GUI();
	}

}
