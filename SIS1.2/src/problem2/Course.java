package problem2;

public class Course {
	public String Name;
	public String Description;
	public int Credits;
	public String Prerequisites;
	
	public String toString() {
		return Name + Description + Credits;
	}
}
