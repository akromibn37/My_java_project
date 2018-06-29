import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.imageio.ImageIO;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLException;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.fixedfunc.GLLightingFunc;
import javax.media.opengl.glu.GLU;

import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

import static javax.media.opengl.GL.*; // GL constants
import static javax.media.opengl.GL2.*; // GL2 constants

/**
 * JOGL 2.0 Example 2: Rotating 3D Shapes (GLCanvas)
 */
@SuppressWarnings("serial")
public class zzz extends GLCanvas implements GLEventListener
{
	// Define constants for the top-level container
	private static String TITLE = "Rotating 3D Shapes (GLCanvas)"; // window's
																	// title
	private static final int CANVAS_WIDTH = 800; // width of the drawable
	private static final int CANVAS_HEIGHT = 800; // height of the drawable
	private static final int FPS = 200; // animator's target frames per second

	public static Vector MePos;
	public static double MeDir_angle;
	public static Vector MeDir = new Vector(0, -1);
	public Vector a,b;
	public ArrayList<BOX2> box2s;
	
	/** The entry main() method to setup the top-level container and animator */
	public static void main(String[] args)
	{
		// Run the GUI codes in the event-dispatching thread for thread safety
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				// Create the OpenGL rendering canvas
				GLCanvas canvas = new zzz();
				canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

				// Create a animator that drives canvas' display() at the
				// specified FPS.
				final FPSAnimator animator = new FPSAnimator(canvas, FPS, true);

				// Create the top-level container
				final JFrame frame = new JFrame(); // Swing's JFrame or AWT's
													// Frame
				frame.getContentPane().add(canvas);
				frame.addWindowListener(new WindowAdapter()
				{
					@Override
					public void windowClosing(WindowEvent e)
					{
						// Use a dedicate thread to run the stop() to ensure
						// that the
						// animator stops before program exits.
						new Thread()
						{
							@Override
							public void run()
							{
								if (animator.isStarted())
									animator.stop();
								System.exit(0);
							}
						}.start();
					}
				});
				frame.setTitle(TITLE);
				frame.pack();
				frame.setVisible(true);
				animator.start(); // start the animation loop
			}
		});
	}

	// Setup OpenGL Graphics Renderer

	private GLU glu; // for the GL Utility
	private float anglePyramid = 0; // rotational angle in degree for pyramid
	private float angleCube = 0; // rotational angle in degree for cube
	private float speedPyramid = 2.0f; // rotational speed for pyramid
	private float speedCube = -1.5f; // rotational speed for cube

	public int[][] map;
	public ArrayList<BOX> boxs;

	/** Constructor to setup the GUI for this Component */
	public zzz()
	{
		this.addGLEventListener(this);
		boxs = new ArrayList<BOX>();
		box2s = new ArrayList<BOX2>();
		Scanner sc = null;
		try
		{
			sc = new Scanner(new File("map.txt"));
			int x = 0;
			int y = 0;
			while (sc.hasNext())
			{
				String s = sc.nextLine();
				x = 0;
				for (int i = 0; i < s.length(); i++)
				{
					if (s.charAt(i) == 'x' || s.charAt(i) == 'X')
					{
						boxs.add(new BOX());
						boxs.get(boxs.size() - 1).dir = new Vector(0, 0);
						boxs.get(boxs.size() - 1).pos = new Vector(x, y);
						boxs.get(boxs.size() - 1).Size = 1;
					}
					else if(s.charAt(i)=='a')
					{
						a= new Vector(x, y);
					}
					else if(s.charAt(i)=='b')
					{
						b= new Vector(x, y);
					}
					x++;
				}
				y++;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if (sc != null)
				sc.close();
		}

		MePos = new Vector(5, 5);
		MeDir_angle = Math.PI;
		MeDir = new Vector(0, -1);
		MeDir_angle = MeDir.getAngleWith_minusY();
		this.addKeyListener(new KeyListener()
		{

			@Override
			public void keyTyped(KeyEvent e)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e)
			{
				// System.out.println(e.getKeyCode());
				if (e.getKeyCode() == 'W') // 'w'
				{
					MePos = MePos.add(MeDir);
				}
				if (e.getKeyCode() == 'S') // 'w'
				{
					MePos = MePos.sub(MeDir);

				}
				if (e.getKeyCode() == 'A') // 'w'
				{
					double a = (10 * Math.PI / 180.0);
					MeDir = MeDir.rotate(a);
					MeDir_angle += a;
				}

				if (e.getKeyCode() == 'D') // 'w'
				{
					double a = -(10 * Math.PI / 180.0);
					MeDir = MeDir.rotate(a);
					MeDir_angle += a;
				}
				if(e.getKeyChar() == 'G' || e.getKeyChar() == ' ')
				{
					box2s.add(new BOX2(MePos, MeDir));
					
				}
				System.out.println(MePos + "\t\t" + MeDir+" "+ box2s.size());

			}
		});

	}

	GLModel model;
	GLModel model_plane;

	// ------ Implement methods declared in GLEventListener ------

	/**
	 * Called back immediately after the OpenGL context is initialized. Can be
	 * used to perform one-time initialization. Run only once.
	 */
	@Override
	public void init(GLAutoDrawable drawable)
	{
		GL2 gl = drawable.getGL().getGL2(); // get the OpenGL graphics context
		glu = new GLU(); // get GL Utilities
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // set background (clear) color
		gl.glClearDepth(1.0f); // set clear depth value to farthest
		gl.glEnable(GL_DEPTH_TEST); // enables depth testing
		gl.glDepthFunc(GL_LEQUAL); // the type of depth test to do
		gl.glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST); // best
																// perspective
																// correction
		gl.glShadeModel(GL_SMOOTH); // blends colors nicely, and smoothes out
									// lighting
		gl.glShadeModel(GL_LIGHT_MODEL_AMBIENT);
		//doLighting(gl);
		try
		{
			Texture tex = loadTexture("w2.jpeg");
			model = new GLModel
					(new BufferedReader(new FileReader(new File("mini_obj.obj")))
					, true, gl, tex);
			model.pos = b;
			model.scale = 0.005f;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		model.opengldrawtolist(gl);

		// ////
		// model_plane
		try
		{
			Texture tex = loadTexture("w2.jpeg");
			model_plane = new GLModel(
					new BufferedReader(new FileReader(new File("toyplane.obj"))),
					true, gl, tex);
			model_plane.pos = a;
			model_plane.scale = 0.025f;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		model_plane.opengldrawtolist(gl);
		// ////
		System.out.println(model.getXWidth());
		System.out.println(model.getYHeight());
		System.out.println(model.getZDepth());

		System.out.println(model_plane.getXWidth());
		System.out.println(model_plane.getYHeight());
		System.out.println(model_plane.getZDepth());

	}

	public static Texture loadTexture(String file) throws GLException, IOException
	{
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ImageIO.write(ImageIO.read(new File(file)), "jpg", os);
		InputStream fis = new ByteArrayInputStream(os.toByteArray());
		return TextureIO.newTexture(fis, true, TextureIO.JPG);
	}

	/**
	 * Call-back handler for window re-size event. Also called when the drawable
	 * is first set to visible.
	 */
	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height)
	{
		GL2 gl = drawable.getGL().getGL2(); // get the OpenGL 2 graphics context

		if (height == 0)
			height = 1; // prevent divide by zero
		float aspect = (float) width / height;

		// Set the view port (display area) to cover the entire window
		gl.glViewport(0, 0, width, height);

		// Setup perspective projection, with aspect ratio matches viewport
		gl.glMatrixMode(GL_PROJECTION); // choose projection matrix
		gl.glLoadIdentity(); // reset projection matrix
		glu.gluPerspective(45.0, aspect, 0.1, 1000.0); // fovy, aspect, zNear,
														// zFar

		// Enable the model-view transform
		gl.glMatrixMode(GL_MODELVIEW);
		gl.glLoadIdentity(); // reset
	}

	/**
	 * Called back by the animator to perform rendering.
	 */
	@Override
	public void display(GLAutoDrawable drawable)
	{
		GL2 gl = drawable.getGL().getGL2(); // get the OpenGL 2 graphics context
		gl.glMatrixMode(GL_MODELVIEW);
		gl.glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear color
																// and depth
		

		gl.glLoadIdentity();
		model.opengldraw2(gl);

		gl.glLoadIdentity();
		model_plane.opengldraw2(gl);
		
		for (int i = 0; i < boxs.size(); i++)
		{
			gl.glLoadIdentity(); // reset the model-view matrix
			boxs.get(i).draw(drawable);
		}
		
		for(int i=0;i< box2s.size();i++)
		{
			gl.glLoadIdentity(); // reset the model-view matrix
			box2s.get(i).draw(drawable);
			box2s.get(i).update();
		}
		for(int i=0;i< box2s.size();i++)
		{
			System.out.println( box2s.get(i).life);
			if(box2s.get(i).isDead())
			{
				box2s.remove(i);
				i--;
			}
		}
	}

	/**
	 * Called back before the OpenGL context is destroyed. Release resource such
	 * as buffers.
	 */
	@Override
	public void dispose(GLAutoDrawable drawable)
	{
	}

	private void doLighting(GL2 gl)
	{
		float[] lightPos = new float[4];
		lightPos[0] = 0;
		lightPos[1] = 2;
		lightPos[2] = 0;
		lightPos[3] = 1;
		gl.glEnable(GLLightingFunc.GL_LIGHTING);
		gl.glEnable(GLLightingFunc.GL_LIGHT0);
		float[] noAmbient =
		{ 0.9f, 0.9f, 0.9f, 1f }; // low ambient light
		float[] spec =
		{ 1f, 0.9f, 0f, 1f }; // low ambient light
		float[] diffuse =
		{ 1f, 1f, 1f, 1f };
		// properties of the light
		gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_AMBIENT, noAmbient, 0);
		gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_SPECULAR, spec, 0);
		gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_DIFFUSE, diffuse, 0);
		gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_POSITION, lightPos, 0);
	}
}