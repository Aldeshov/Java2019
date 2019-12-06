import java.util.Scanner;
public class Problem6 {
	public static boolean isPalindrome(String a){
		char[] ch = a.toCharArray();
		for(int i = 0; i < a.length()/2;i++){
			if(ch[i] != ch[a.length() - 1 - i])
			{
				return false;
			}
		}
		return true;
	}
	public static void main(String args[])
	{
		while(true){
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String abc = scan.next();
		if(isPalindrome(abc))
		{
			System.out.println("Palindrome");
		}
		else
			System.out.println("Not Palindrome");
		}

	}

}
