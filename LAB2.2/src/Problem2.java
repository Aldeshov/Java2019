import java.util.Scanner;
class StarTriangle
{
	public String S = "";
	public String abc = "[*]";
	public  StarTriangle(int a)
	{
		for(int i = 0; i < a; i++)
		{
			S =  S + abc + "\n";
			abc += "[*]";
		}
	}
	public String toString()
	{
		return S;
	}
}
public class Problem2 
{
	public static void main(String args[])
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		StarTriangle  small = new StarTriangle(n); 
		System.out.println(small);
	}
}
