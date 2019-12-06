class InitBlock{
	static{
		System.out.println("Static Init Block");
	}
	
	{
		System.out.println("Init Block");
	}
	
	InitBlock(){
		{
			System.out.println("Constructor Init Block");
		}
	}
}

class This{
	int ex1;
	String ex2;
	
	This(int ex1,String ex2){
		this.ex1 = ex1;
		this.ex2 = ex2;
	}
}

class StaticFinal{
	public static int Ex1;
	public final String Ex2 = "Constant";
	
	public static void Ex3(){
		
	}
	
	public void Ex4(){
		
	}
}

class ENum{
	public enum Enumeration{
		Enum1, Enum2, Enum3
	}
}

class MethodOverloading{
	public void method(int a){
		
	}
	public void method(int a,int b){
		
	}
	public void method(int a,int b, int c){
		
	}
}

class ReadOnlyFields{
	private int abc;
	private int def;
	
	ReadOnlyFields(int ex1, int ex2){
		abc = ex1;
		def = ex2;
	}
	public int getabc(){
		return abc;
	}
	public int getdef(){
		return def;
	}
}

public class Problem5 {
	public static void main(String args[])
	{
		
	}
}
