package pack5;

public class MinMax {
	static class Value 
	{
		public int min = 999999;
		public int max = -1;
	}
	public static Value minmax(int values[]){
		Value v = new Value();
		for(int i = 0;i < values.length;i++) {
			if(values[i] > v.max) {
				v.max = values[i];
			}
			if(values[i] < v.min) {
				v.min = values[i];
			}
		}
		return v;
		}
	public static void main(String args[]) 
	{
		System.out.println(minmax(new int[] {8,3,4,5,6,7,8,12}).max + " " + minmax(new int[] {8,3,4,5,6,7,8,12}).min);
	}
}
