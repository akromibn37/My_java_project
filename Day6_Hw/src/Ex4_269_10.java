import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Ex4_269_10 {

	private static final String FILE_ENCODE = "UTF-8";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		URL url = new URL("http://www.expert-programming-tutor.com/Downloads/riwords.txt");
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), FILE_ENCODE));
		String[] line = new String[100000];
		int i = 0;
		int countone = 0;
		int counttwo = 0;
		int countthree = 0;
		int countfour = 0;
		while ((line[i] = in.readLine()) != null) {
			int countline = 0;
			System.out.println(line[i]);
			System.out.println(line[i].length());
			for (int j = 0; j < line[i].length(); j++) {
				if (line[i].charAt(j) == 'è') {
					countone++;
				} else if (line[i].charAt(j) == 'é') {
					counttwo++;
				} else if (line[i].charAt(j) == 'ê') {
					countthree++;
				} else if (line[i].charAt(j) == 'ë') {
					countfour++;
				}
				countline++;
			}
			System.out.println(countone);
			System.out.println(counttwo);
			System.out.println(countthree);
			System.out.println(countfour);
			System.out.println("line" + (i + 1) + " = " + countline);
			i++;
		}
		int max = max4(countone, counttwo, countthree, countfour);
		System.out.println(countone);
		System.out.println(counttwo);
		System.out.println(countthree);
		System.out.println(countfour);
		System.out.println("max = " + max);
		in.close();
	}

	public static int max(int a, int b) {
		return a > b ? a : b;
	}

	public static int max4(int a, int b, int c, int d) {
		return max(a, (max(b, max(c, d))));
	}

}
