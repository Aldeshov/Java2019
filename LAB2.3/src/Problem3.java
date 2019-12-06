import java.util.Scanner;
class Data{
	private double average;
	private double maximum;
	private int sum = 0;
	public Data(){
	}
	public int Value(double a, int b){
		if(a > maximum)
			maximum = a;
		sum += a;
		average = sum / b;
		return 0;
	}
	public double getAverage(){
		return average;
	}
	public double getMaximum(){
		return maximum;
	}
}
class Analyzer{
	public void Analyze(){
		Data data = new Data();
		int count = 1;
		while(true){
			System.out.print("Enter number (Q to quit):");
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			String s = scan.next();
			if(s.equals("q") || s.equals("Q")){
				break;
			}
			else{
				double num = Double.parseDouble(s);
				data.Value(num,count);
				count++;
			}
		}
		System.out.println("Average = " + data.getAverage());
		System.out.println("Maximum = " + data.getMaximum());
	}
}
public class Problem3 
{
	public static void main(String args[])
	{
		Analyzer a = new Analyzer();
		a.Analyze();	
	}
}
