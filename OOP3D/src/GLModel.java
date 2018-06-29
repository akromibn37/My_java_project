import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

import com.jogamp.opengl.util.texture.Texture;

//import com.sun.opengl.util.texture.Texture;

// This class reads Wavefront .obj files
public class GLModel
{

	private ArrayList<float[]> vertexsets;
	private ArrayList<float[]> vertexsetsnorms;
	private ArrayList<float[]> vertexsetstexs;
	private ArrayList<int[]> faces;
	private ArrayList<int[]> facestexs;
	private ArrayList<int[]> facesnorms;
	private int objectlist;
	private int numpolys;
	public float toppoint;
	public float bottompoint;
	public float leftpoint;
	public float rightpoint;
	public float farpoint;
	public float nearpoint;
	
	public Vector pos;
	public float scale;
	Texture texture;

	public GLModel(BufferedReader ref, boolean centerit, GL2 gl, Texture texture)
	{

		this.texture = texture;
		vertexsets = new ArrayList<float[]>();
		vertexsetsnorms = new ArrayList<float[]>();
		vertexsetstexs = new ArrayList<float[]>();
		faces = new ArrayList<int[]>();
		facestexs = new ArrayList<int[]>();
		facesnorms = new ArrayList<int[]>();
		numpolys = 0;
		toppoint = 0.0F;
		bottompoint = 0.0F;
		leftpoint = 0.0F;
		rightpoint = 0.0F;
		farpoint = 0.0F;
		nearpoint = 0.0F;
		loadobject(ref);
		if (centerit)
			centerit();
		opengldrawtolist(gl);
		numpolys = faces.size();
		System.out.println("faces.size(); " + faces.size());
		// cleanup();
	}

	public GLModel(BufferedReader ref, boolean centerit, GL gl)
	{

		vertexsets = new ArrayList<float[]>();
		vertexsetsnorms = new ArrayList<float[]>();
		vertexsetstexs = new ArrayList<float[]>();
		faces = new ArrayList<int[]>();
		facestexs = new ArrayList<int[]>();
		facesnorms = new ArrayList<int[]>();
		numpolys = 0;
		toppoint = 0.0F;
		bottompoint = 0.0F;
		leftpoint = 0.0F;
		rightpoint = 0.0F;
		farpoint = 0.0F;
		nearpoint = 0.0F;
		loadobject(ref);
		if (centerit)
			centerit();
		numpolys = faces.size();
		cleanup();
	}

	private void cleanup()
	{
		vertexsets.clear();
		vertexsetsnorms.clear();
		vertexsetstexs.clear();
		faces.clear();
		facestexs.clear();
		facesnorms.clear();
	}

	@SuppressWarnings("unused")
	private void loadobject(BufferedReader br)
	{
		int linecounter = 0;
		int facecounter = 0;
		try
		{
			boolean firstpass = true;
			String newline;
			while ((newline = br.readLine()) != null)
			{
				linecounter++;
				if (newline.length() > 0)
				{
					newline = newline.trim();

					// LOADS VERTEX COORDINATES
					if (newline.startsWith("v "))
					{
						float coords[] = new float[4];
						newline = newline.substring(2, newline.length());
						StringTokenizer st = new StringTokenizer(newline, " ");
						for (int i = 0; st.hasMoreTokens(); i++)
							coords[i] = Float.parseFloat(st.nextToken());

						if (firstpass)
						{
							rightpoint = coords[0];
							leftpoint = coords[0];
							toppoint = coords[1];
							bottompoint = coords[1];
							nearpoint = coords[2];
							farpoint = coords[2];
							firstpass = false;
						}
						if (coords[0] > rightpoint)
							rightpoint = coords[0];
						if (coords[0] < leftpoint)
							leftpoint = coords[0];
						if (coords[1] > toppoint)
							toppoint = coords[1];
						if (coords[1] < bottompoint)
							bottompoint = coords[1];
						if (coords[2] > nearpoint)
							nearpoint = coords[2];
						if (coords[2] < farpoint)
							farpoint = coords[2];
						vertexsets.add(coords);
					} else

					// LOADS VERTEX TEXTURE COORDINATES
					if (newline.startsWith("vt"))
					{
						float coords[] = new float[4];
						newline = newline.substring(3, newline.length());
						StringTokenizer st = new StringTokenizer(newline, " ");
						for (int i = 0; st.hasMoreTokens(); i++)
							coords[i] = Float.parseFloat(st.nextToken());

						vertexsetstexs.add(coords);
					} else

					// LOADS VERTEX NORMALS COORDINATES
					if (newline.startsWith("vn"))
					{
						float coords[] = new float[4];
						newline = newline.substring(3, newline.length());
						StringTokenizer st = new StringTokenizer(newline, " ");
						for (int i = 0; st.hasMoreTokens(); i++)
							coords[i] = Float.parseFloat(st.nextToken());

						vertexsetsnorms.add(coords);
					} else

					// LOADS FACES COORDINATES
					if (newline.startsWith("f "))
					{
						facecounter++;
						newline = newline.substring(2, newline.length());
						StringTokenizer st = new StringTokenizer(newline, " ");
						int count = st.countTokens();
						int v[] = new int[count];
						int vt[] = new int[count];
						int vn[] = new int[count];
						for (int i = 0; i < count; i++)
						{
							char chars[] = st.nextToken().toCharArray();
							StringBuffer sb = new StringBuffer();
							char lc = 'x';
							for (int k = 0; k < chars.length; k++)
							{
								if (chars[k] == '/' && lc == '/')
									sb.append('0');
								lc = chars[k];
								sb.append(lc);
							}

							StringTokenizer st2 = new StringTokenizer(sb.toString(), "/");
							int num = st2.countTokens();
							v[i] = Integer.parseInt(st2.nextToken());
							if (num > 1)
								vt[i] = Integer.parseInt(st2.nextToken());
							else
								vt[i] = 0;
							if (num > 2)
								vn[i] = Integer.parseInt(st2.nextToken());
							else
								vn[i] = 0;
						}

						faces.add(v);
						facestexs.add(vt);
						facesnorms.add(vn);
					} else
					// LOADS MATERIALS
					if (newline.charAt(0) == 'm' && newline.charAt(1) == 't' && newline.charAt(2) == 'l' && newline.charAt(3) == 'l' && newline.charAt(4) == 'i' && newline.charAt(5) == 'b')
					{
					} else
					// USES MATERIALS
					if (newline.charAt(0) == 'u' && newline.charAt(1) == 's' && newline.charAt(2) == 'e' && newline.charAt(3) == 'm' && newline.charAt(4) == 't' && newline.charAt(5) == 'l')
					{
					}
				}
			}
		} catch (IOException e)
		{
			System.out.println("Failed to read file: " + br.toString());
		} catch (NumberFormatException e)
		{
			System.out.println("Malformed OBJ file: " + br.toString() + "\r \r" + e.getMessage());
		}
	}

	private void centerit()
	{
		float xshift = (rightpoint - leftpoint) / 2.0F;
		float yshift = (toppoint - bottompoint) / 2.0F;
		float zshift = (nearpoint - farpoint) / 2.0F;
		for (int i = 0; i < vertexsets.size(); i++)
		{
			float coords[] = new float[4];
			coords[0] = ((float[]) vertexsets.get(i))[0] - leftpoint - xshift;
			coords[1] = ((float[]) vertexsets.get(i))[1] - bottompoint - yshift;
			coords[2] = ((float[]) vertexsets.get(i))[2] - farpoint - zshift;
			vertexsets.set(i, coords);
		}
	}

	public float getXWidth()
	{
		float returnval = 0.0F;
		returnval = rightpoint - leftpoint;
		return returnval;
	}

	public float getYHeight()
	{
		float returnval = 0.0F;
		returnval = toppoint - bottompoint;
		return returnval;
	}

	public float getZDepth()
	{
		float returnval = 0.0F;
		returnval = nearpoint - farpoint;
		return returnval;
	}

	public int numpolygons()
	{
		return numpolys;
	}

	public void opengldrawtolist(GL2 gl)
	{
		// retrieving object list
		this.objectlist = gl.glGenLists(1);
		System.out.println("a");
		gl.glNewList(objectlist, GL2.GL_COMPILE);
		texture.enable(gl);
		texture.bind(gl);
		gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_REPEAT);
		gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_REPEAT);
		gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_LINEAR);
		gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_LINEAR);
		System.out.println("faces.size()" + faces.size());
		for (int i = 0; i < faces.size(); i++)
		{

			int[] tempfaces = (int[]) (faces.get(i));
			int[] tempfacesnorms = (int[]) (facesnorms.get(i));
			int[] tempfacestexs = (int[]) (facestexs.get(i));

			// // Quad Begin Header ////
			int polytype;
			if (tempfaces.length == 3)
			{
				polytype = GL.GL_TRIANGLES;
			} else if (tempfaces.length == 4)
			{
				polytype = GL2.GL_QUADS;
			} else
			{
				polytype = GL2.GL_POLYGON;
			}
			gl.glBegin(polytype);

			for (int w = 0; w < tempfaces.length; w++)
			{
				if (tempfacesnorms[w] != 0)
				{
					float normtempx = ((float[]) vertexsetsnorms.get(tempfacesnorms[w] - 1))[0];
					float normtempy = ((float[]) vertexsetsnorms.get(tempfacesnorms[w] - 1))[1];
					float normtempz = ((float[]) vertexsetsnorms.get(tempfacesnorms[w] - 1))[2];
					gl.glNormal3f(normtempx, normtempy, normtempz);
				}

				if (tempfacestexs[w] != 0)
				{
					float textempx = ((float[]) vertexsetstexs.get(tempfacestexs[w] - 1))[0];
					float textempy = ((float[]) vertexsetstexs.get(tempfacestexs[w] - 1))[1];
					float textempz = ((float[]) vertexsetstexs.get(tempfacestexs[w] - 1))[2];
					gl.glTexCoord3f(textempx, 1f - textempy, textempz);
				}

				float tempx = ((float[]) vertexsets.get(tempfaces[w] - 1))[0];
				float tempy = ((float[]) vertexsets.get(tempfaces[w] - 1))[1];
				float tempz = ((float[]) vertexsets.get(tempfaces[w] - 1))[2];
				gl.glVertex3f(tempx, tempy, tempz);
			}
			// Quad End

			gl.glEnd();
		}

		gl.glEndList();
	}

	public void opengldraw(GL2 gl)
	{
		gl.glScalef(0.01f, 0.01f, 0.01f);
		gl.glCallList(objectlist);
	}

	public void opengldraw2(GL2 gl)
	{
		double angle =zzz.MeDir_angle* 180 / Math.PI;
		gl.glRotatef(-(float) (angle), 0, 1, 0);
		gl.glTranslatef(-(float) zzz.MePos.x, 0, -(float) zzz.MePos.y);
		
		gl.glTranslated((float)pos.x, 0, -(float)pos.y);
		
		gl.glScalef(scale, scale, scale);
		texture.enable(gl);
		texture.bind(gl);
		gl.glEnable(GL.GL_DEPTH_TEST);
		gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_REPEAT);
		gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_REPEAT);
		gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_LINEAR);
		gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_LINEAR);
		//System.out.println(faces.size());
		for (int i = 0; i < faces.size(); i++)
		{

			int[] tempfaces = (int[]) (faces.get(i));
			int[] tempfacesnorms = (int[]) (facesnorms.get(i));
			int[] tempfacestexs = (int[]) (facestexs.get(i));

			// // Quad Begin Header ////
			int polytype;
			if (tempfaces.length == 3)
			{
				polytype = GL.GL_TRIANGLES;
			} else if (tempfaces.length == 4)
			{
				polytype = GL2.GL_QUADS;
			} else
			{
				polytype = GL2.GL_POLYGON;
			}
			gl.glBegin(polytype);

			for (int w = 0; w < tempfaces.length; w++)
			{
				if (tempfacesnorms[w] != 0)
				{
					float normtempx = ((float[]) vertexsetsnorms.get(tempfacesnorms[w] - 1))[0];
					float normtempy = ((float[]) vertexsetsnorms.get(tempfacesnorms[w] - 1))[1];
					float normtempz = ((float[]) vertexsetsnorms.get(tempfacesnorms[w] - 1))[2];
					gl.glNormal3f(normtempx, normtempy, normtempz);
				}

				if (tempfacestexs[w] != 0)
				{
					float textempx = ((float[]) vertexsetstexs.get(tempfacestexs[w] - 1))[0];
					float textempy = ((float[]) vertexsetstexs.get(tempfacestexs[w] - 1))[1];
					float textempz = ((float[]) vertexsetstexs.get(tempfacestexs[w] - 1))[2];
					gl.glTexCoord3f(textempx, 1f - textempy, textempz);
				}

				float tempx = ((float[]) vertexsets.get(tempfaces[w] - 1))[0];
				float tempy = ((float[]) vertexsets.get(tempfaces[w] - 1))[1];
				float tempz = ((float[]) vertexsets.get(tempfaces[w] - 1))[2];
				gl.glColor3f(1, 1, 1);
				gl.glVertex3f(tempx, tempy, tempz);
				//System.out.println(tempx+","+ tempy+","+ tempz);
			}
			// Quad End

			gl.glEnd();
		}
		texture.disable(gl);
	}

	public boolean collision(float[] position)
	{
		return false;
	}

	public void setTexature(Texture tex)
	{
		this.texture = tex;
	}
}