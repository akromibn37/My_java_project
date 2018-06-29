
public class Ex3_261_28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float[] sin = new float[315];
		float[] cos = new float[315];
		float[] tan = new float[315];

		float j = 0.0f;
		System.out.println("Theta \t\t sin \t cos \t tan");
		for (int i = 0; i <= 314; i++) {
			System.out.printf("%.2f"+"\t\t",j);
			sin[i] = (float)Math.sin(j);
			System.out.printf("%.3f" + "\t",sin[i]);
			cos[i] = (float)Math.cos(j);
			System.out.printf("%.3f" + "\t",cos[i]);
			tan[i] = (float)Math.tan(j);
			System.out.printf("%.3f" + "\t",tan[i]);
			j = j + 0.01f;			
			System.out.println();
		}
		

	}

}
