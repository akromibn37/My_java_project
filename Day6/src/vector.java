
public class vector {
	public double x,y;
	
	public vector add(vector b)
	{
		vector result = new vector();
		result.x = x + b.x;
		result.y = y + b.y;
		
		return result;
	}
	//public 
}
