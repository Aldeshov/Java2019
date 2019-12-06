package problem1;
public class Student
{
	private int year = 0;
	private String name;
	private String id;
	public Student(String name, String id){
		this.id = id;
		this.name = name;
		Year();
	}
	public Student() {
		Year();
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setID(String id) {
		this.id = id;
	}
	public String getID(){
		return id;
	}
	public String getName(){
		return name;
	}
	public int Year(){
		return ++year;
	}
	public String toString() {
		return "Name: " + name + "  ID: " + id + "  Year: " + year;
	}
	/*public void Access()
	{
		@SuppressWarnings("resource")
		Scanner stud = new Scanner(System.in);
		System.out.print("Name:");
		String name = stud.next();
		System.out.print("ID:");
		String id = stud.next();
	}*/
}
