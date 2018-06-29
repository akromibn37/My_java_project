import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class xxx
{
	public static void main(String[] args)
	{
		GLCanvas canvas = new GLCanvas();
		JFrame frame = new JFrame(); // or AWT's Frame
		frame.getContentPane().add(canvas); // add Component
		canvas.addGLEventListener(new GLEventListener()
		{

			@Override
			public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void init(GLAutoDrawable arg0)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void dispose(GLAutoDrawable arg0)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void display(GLAutoDrawable drawable)
			{
				// TODO Auto-generated method stub
				javax.media.opengl.GL4 gl = drawable.getGL().getGL4();
			}
		});
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
