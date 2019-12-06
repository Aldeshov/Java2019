import java.util.*;
class Person{
	String name;
	String address;
	public
	Person(String name,String address){
		this.name = name;
		this.address= address;
	}
	public
	String getName() {
		return name;
	}
	public
	String getAddress() {
		return address;
	}
	public
	void setAddress(String address) {
		this.address = address;
	}
	public String toString() {
		return "Person[name = " + name + ",address = " + address + "]";
	}
}
////////////////////////////////////////////////////////////////////
class Student extends Person{
	String program;
	int year;
	double fee;
	public 
	Student(String name, String address,String program,int year,double fee){
		super(name,address);
		this.program = program;
		this.year = year;
		this.fee = fee;
	}
	public 
	String getProgram() {
		return program;
	}
	public 
	void setProgram(String program) {
		this.program = program;
	}
	public 
	int getYear() {
		return year;
	}
	public 
	void setYear(int year) {
		this.year = year;	
	}
	public 
	double getFee() {
		return fee;
	}
	public 
	void setFee(double fee) {
		this.fee = fee;
	}
	@Override
	public 
	String toString() {
		return "Student[Person[name = " + name +",address = " + address + "],program = " + program + ",year = " + year + ",fee = " + fee + "]";
	}
}
/////////////////////////////////////////////////////////////////////////
class Staff extends Person{
	String school;
	double pay;
	public Staff(String name, String address, String school, double pay) {
		super(name,address);
		this.school = school;
		this.pay = pay;
		}
	public
	String getSchool() {
		return school;
	}
	public 
	void setSchool(String school) {
		this.school = school;
	}
	public
	double getPay() {
		return pay;
	}
	public
	void setPay(double pay) {
		this.pay = pay;
	}
	public
	String toString() {
		return "Staff[Person[name = " + name + ",address = " + address + "],school = " + school + ",pay = " + pay + "]";
	}
}


//M I
// A N
public class problem5 {
	public static void main(String[] args) {
		Vector<Person> P = new Vector<Person>();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		while(!s.equalsIgnoreCase("exit")) 
		{
			if(s.equalsIgnoreCase("Person"))
			{
				System.out.println("Person: Name & Address");
				P.add(new Person(scan.next(),scan.next()));
			}
			if(s.equalsIgnoreCase("Staff"))
			{
				System.out.println("Staff: Name & Address & School & Pay");
				P.add(new Staff(scan.next(),scan.next(),scan.next(),scan.nextDouble()));
			}
			if(s.equalsIgnoreCase("Student"))
			{
				System.out.println("Student: Name & Address & Program & Year & Fee");
				P.add(new Student(scan.next(),scan.next(),scan.next(),scan.nextInt(),scan.nextDouble()));
			}
			s = scan.nextLine();
		}
		for(Person p:P) {
			System.out.println(p.toString());
		}
	}
}
