import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Ex4_269_7 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(
				new FileReader("C:\\Users\\Administrator.MMTYOYDSVM1GISI\\Desktop\\aaa.txt"));
		String[] line = new String[100];
		int i = 0;
		int countchar = 0;		
		char[] charac = new char[29];
		int [] sum = new int[29];		
		
		while ((line[i] = in.readLine()) != null)
		{			
			System.out.println(line[i]);
//			System.out.println(line[i].length());
			
			for(int j =0;j<line[i].length();j++)
			{
				boolean z = true;
				for(int k = 0;k<29;k++)
				{
					if(line[i].toLowerCase().charAt(j) == charac[k])
					{
						sum[k]++;
						z = false;
//						System.out.println("in");
						break;
					}
				}
//				System.out.println(line[i].charAt(j));
				if(z && (Character.isLetter(line[i].charAt(j))))
				{
//					System.out.println("in z");
//					System.out.println(z);
					charac[countchar] = line[i].charAt(j);
					sum[countchar] = 1;
					countchar++;					
				}
				
			}
		}
		System.out.println(Arrays.toString(charac));
		System.out.println(Arrays.toString(sum));

	}

}
