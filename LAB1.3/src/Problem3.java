
import java.util.Scanner;
public class Problem3 
{
	public static void main(String args[])
	{
		int grade = -1;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		while(grade < 0 || grade > 100)
		{
			grade = scan.nextInt();
		}
		String ABC[] = { "D" , "D+" , "C-" , "C" , "C+" , "B-" , "B" , "B+" , "A-" , "A" };
		int num = ((grade - 50) +(5 - (grade - 50) % 5)) / 5;
		if(grade < 50)
			System.out.println("F");
		else if( grade == 100)
			System.out.println("A");
		else
		System.out.println(ABC[num - 1]);
	}
}
