import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;
public class Problem1 {
	public static void main(String args[]) {
		File scores,grades;
		BufferedReader read;
		PrintStream print;
		StringTokenizer tokenizer;
		Vector<String> v = new Vector<String>();
		Vector<Integer> v1 = new Vector<Integer>();
		int best = 0;
		try 
		{
		scores = new File("C:\\Users\\azata\\JavaProjects\\LAB4.1\\bin\\Scores.txt");
		grades = new File("C:\\Users\\azata\\JavaProjects\\LAB4.1\\bin\\grades.txt");
		read = new BufferedReader(new FileReader(scores));
		print = new PrintStream(grades);
		tokenizer = new StringTokenizer(read.readLine()," ",true);
		while(tokenizer.countTokens() != 0) 
		{
			String s = tokenizer.nextToken();
			s += tokenizer.nextToken();
			s += tokenizer.nextToken();
			s += tokenizer.nextToken();
			v.add(s);
			int x = Integer.parseInt(tokenizer.nextToken());
			if(best < x)
				best = x;
			v1.add(x);
			String temp = read.readLine();
			if(temp != null) 
				tokenizer = new StringTokenizer(temp," ",true);
		}
		for(int i = 0; i < v.size();i++) {
			print.print(v.elementAt(i));
			if(v1.elementAt(i) <= best && v1.elementAt(i) >= best - 10) {
				print.println("- \"A\"");			
				}
			else if(v1.elementAt(i) < best - 10 && v1.elementAt(i) >= best - 20) {
				print.println("- \"B\"");			
			}
			else if(v1.elementAt(i) < best - 20 && v1.elementAt(i) >= best - 30) {
				print.println("- \"C\"");			
			}
			else if(v1.elementAt(i) < best  - 30 && v1.elementAt(i) >= best - 40) {
				print.println("- \"D\"");			
			}
			else {
				print.println("- \"F\"");			
			}
		}
		print.close();
		System.out.println("OK");
		}
		catch(Exception e) 
		{
			System.out.println(e.getLocalizedMessage());
		}
		
	}
}
