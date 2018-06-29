
public class Ex7_281_8 {

	public static void main(String[] drgs) {
		

	}
	public static int[] maxmin(int []d,int i,int j)
	{
		int min;
        int max;
        int mid;
        if (j == i){
            return maxmin(d,i, j);
        } else {
            mid = (i + j)/2;
            maxmin (d,i, mid);
            max = mid;
            maxmin (d,mid+1, j);
            min = mid;

            if (d[max] > d[min]){
                return maxmin(d,i, max);
            } else 
                return maxmin(d,min, j);
        }
    }		
	
	

}
