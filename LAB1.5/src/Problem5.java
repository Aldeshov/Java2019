import java.util.Scanner;
public class Problem5 
{
	public static void main(String args[])
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		System.out.println(a + (a * b)/100);
		
	}
}
