import static javax.media.opengl.GL2GL3.GL_QUADS;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;

public class BOX2
{
	public double Size;
	public Vector3f pos;
	public Vector3f vel;
	public Vector3f acc;
	public Vector3f dir;

	public long life;

	public BOX2(Vector mypos, Vector mydir)
	{
		Size = 0.15;
		pos = new Vector3f(mypos.x, mypos.y, 0);
		double size = mydir.size();
		vel = new Vector3f(mydir.x / size*0.05, mydir.y / size*0.05, 0.05);
		acc = new Vector3f(0, 0, -0.01);
		life = 60;

	}

	public void update()
	{
		vel = vel.add(acc);
		pos = pos.add(vel);
		
		if(pos.z < -0)
		{
			pos.z=-0;
		}
		life--;
	}

	public boolean isDead()
	{
		if (life < 0)
			return true;
		return false;
	}

	public void draw(GLAutoDrawable drawable)
	{
		GL2 gl = drawable.getGL().getGL2(); // get the OpenGL 2 graphics context

		// double angle =zzz. MeDir.getAngleWith_minusY() * 180 / Math.PI;
		double angle = zzz.MeDir_angle * 180 / Math.PI;
		gl.glRotatef(-(float) (angle), 0, 1, 0);

		gl.glTranslatef(-(float) zzz.MePos.x, 0, -(float) zzz.MePos.y);
		gl.glTranslatef((float) (pos.x), (float) (pos.z), (float) (pos.y)); // translate
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
