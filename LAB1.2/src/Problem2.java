import java.util.Scanner;
public class Problem2 {
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int area = a * a;
		int Perimetr = a * 4;
		double diagonal = Math.sqrt(2) * a;
		System.out.print("Area = " + area +"\nPerimetr = " + Perimetr + "\nDiagonal = " + diagonal + "\n");
		scan.close();
	}

}
