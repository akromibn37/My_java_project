import static javax.media.opengl.GL.GL_COLOR_BUFFER_BIT;
import static javax.media.opengl.GL.GL_DEPTH_BUFFER_BIT;
import static javax.media.opengl.GL.GL_TRIANGLES;
import static javax.media.opengl.GL2GL3.GL_QUADS;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;

public class BOX
{
	public double Size;
	public Vector pos;
	public Vector dir;

	public void draw(GLAutoDrawable drawable)
	{
		GL2 gl = drawable.getGL().getGL2(); // get the OpenGL 2 graphics context

		//double angle =zzz. MeDir.getAngleWith_minusY() * 180 / Math.PI;
		double angle =zzz.MeDir_angle* 180 / Math.PI;
		gl.glRotatef(-(float) (angle), 0, 1, 0);
		
		gl.glTranslatef(-(float) zzz.MePos.x, 0, -(float) zzz.MePos.y);
		gl.glTranslatef((float) (pos.x), 0.0f, -(float) (pos.y)); // translate
																	// right and
																	// into the
																	// screen
		
		
		gl.glScalef((float) Size, (float) Size, (float) Size);
		gl.glBegin(GL_QUADS); // of the color cube

		// Top-face
		
		gl.glColor3f(0.0f, 1.0f, 0.0f); // green
		gl.glVertex3f(0.5f, 0.5f, -0.5f);
		gl.glVertex3f(-0.5f, 0.5f, -0.5f);
		gl.glVertex3f(-0.5f, 0.5f, 0.5f);
		gl.glVertex3f(0.5f, 0.5f, 0.5f);

		// Bottom-face
		gl.glColor3f(1.0f, 0.5f, 0.0f); // orange
		gl.glVertex3f(0.5f, -0.5f, 0.5f);
		gl.glVertex3f(-0.5f, -0.5f, 0.5f);
		gl.glVertex3f(-0.5f, -0.5f, -0.5f);
		gl.glVertex3f(0.5f, -0.5f, -0.5f);

		// Front-face
		gl.glColor3f(1.0f, 0.0f, 0.0f); // red
		gl.glVertex3f(0.5f, 0.5f, 0.5f);
		gl.glVertex3f(-0.5f, 0.5f, 0.5f);
		gl.glVertex3f(-0.5f, -0.5f, 0.5f);
		gl.glVertex3f(0.5f, -0.5f, 0.5f);

		// Back-face
		gl.glColor3f(1.0f, 1.0f, 0.0f); // yellow
		gl.glVertex3f(0.5f, -0.5f, -0.5f);
		gl.glVertex3f(-0.5f, -0.5f, -0.5f);
		gl.glVertex3f(-0.5f, 0.5f, -0.5f);
		gl.glVertex3f(0.5f, 0.5f, -0.5f);

		// Left-face
		gl.glColor3f(0.0f, 0.0f, 1.0f); // blue
		gl.glVertex3f(-0.5f, 0.5f, 0.5f);
		gl.glVertex3f(-0.5f, 0.5f, -0.5f);
		gl.glVertex3f(-0.5f, -0.5f, -0.5f);
		gl.glVertex3f(-0.5f, -0.5f, 0.5f);

		// Right-face
		gl.glColor3f(1.0f, 0.0f, 1.0f); // magenta
		gl.glVertex3f(0.5f, 0.5f, -0.5f);
		gl.glVertex3f(0.5f, 0.5f, 0.5f);
		gl.glVertex3f(0.5f, -0.5f, 0.5f);
		gl.glVertex3f(0.5f, -0.5f, -0.5f);

		gl.glEnd(); // of the color cube

	}
}
