class Temperature{
	private double temperature;
	private char scale;
	Temperature(double t, char s){
		temperature = t;
		scale = s;
	}
	Temperature(double t){
		temperature = t;
		scale = 'C';
	}
	Temperature(char s){
		temperature = 0;
		scale = s;
	}
	Temperature(){
		temperature = 0;
		scale = 'C';
	}
	public double toCelcius() {
		double c = temperature;
		if(scale == 'F') {
			c = 5 * (temperature - 32) / 9;
			scale = 'C';
		  temperature = c;
		}
		return c;
	}
	public double toFahrenheit() {
		double f = temperature;
		if(scale == 'C') {
			f = (9 * (temperature / 5) + 32);
			scale = 'F';
			temperature = f;
		}
			return f;
	}
	public void setValue(double t) {
		temperature = t;
	}
	public void setValue(char s) {
		scale = s;
	}
	public void setValue(double t, char s) {
		temperature = t;		
		scale = s;
	}
	public char getScale() {
		return scale;
	}
}

public class Problem1 {
	public static void main(String args[]) 
	{
		Temperature t = new Temperature(45,'F');
		System.out.println(t.toCelcius());
		System.out.println(t.toFahrenheit());
	}
}
