import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;
public class Problem1_2 {
	public static void main(String args[]) {
		File scores,grades;
		BufferedReader read;
		FileWriter fw;
		StringTokenizer tokenizer;
		Vector<String> v = new Vector<String>();
		Vector<Integer> v1 = new Vector<Integer>();
		int minimum = 999;
		double average = 0.0;
		int count = 0;
		int best = 0;
		try 
		{
		scores = new File("C:\\Users\\azata\\JavaProjects\\LAB4.1\\bin\\Scores.txt");
		grades = new File("C:\\Users\\azata\\JavaProjects\\LAB4.1\\bin\\grades.txt");
		read = new BufferedReader(new FileReader(scores));
		fw = new FileWriter(grades,true);
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
			if(minimum > x)
				minimum = x;
			count += x;
			v1.add(x);
			String temp = read.readLine();
			if(temp != null) 
				tokenizer = new StringTokenizer(temp," ",true);
		}
		average = count / v1.size(); 
		fw.write("Maximum - " + best + "\nMinimum - " + minimum + "\nAverage - " + average);
		System.out.println("OK");
		fw.close();
		}
		catch(Exception e) 
		{
			System.out.println(e.getLocalizedMessage());
		}
		
	}
}
