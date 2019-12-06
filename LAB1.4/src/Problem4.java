import java.util.Scanner;
public class Problem4 
{
	public static void main(String args[])
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		double a = scan.nextInt();
		double b = scan.nextInt();
		double c = scan.nextInt();
		double discriminant = -1;
		double x1,x2;
		if((b * b - 4 * a * c) >= 0)
		{
			discriminant = Math.sqrt(b * b - 4 * a * c); 
			x1 = (b + discriminant)/2;
			x2 = (b - discriminant)/2;
			System.out.println("X1 is " + x1 + "\nX2 is " + x2 + "\n");
		}
		else
			System.out.println("Error: Discriminant is less than 0; No answer exists");
		
	}
}
