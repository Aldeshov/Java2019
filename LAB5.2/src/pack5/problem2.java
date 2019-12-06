package pack5;
import java.util.Date;
import java.util.Vector;

class Person{
	public String Name;
	public Person() {
		
	}
	public String toString() {
		return Name;
	}
	public boolean equals(Object o) {
	    if(o == this)
	    	return true;
	    if(!(o instanceof Employee))
	    	return false;
	    
	    Person e = (Person)o;
	    return Name.equals(e.Name);
	  }
}
class Manager extends Employee implements Comparable<Object>{
	public Vector<Employee> Employees = new Vector<Employee>();
	double bonus;
	public Manager(String Name) {
		super();
		this.Name = Name;
	}
	public Manager() {
		super();
	}
	@Override
	public String toString() {
		return Name;
	}
	@Override
	public boolean equals(Object o) {
	    if(o == this)
	    	return true;
	    if(!(o instanceof Employee))
	    	return false;
	    Manager m = (Manager)o;
	    return Name.equals(m.Name)&& 
	    		Employees == m.Employees;
	}
	
	public int hashCode() {
		int code = 17;
		code = 31 * code + Name.hashCode();
		code = 31 * code + Employees.hashCode();
		return code;
	}
	@Override
	public int compareTo(Object o) {
		Manager other = (Manager) o;
		if (Salary < other.Salary) return -1;
		if (Salary > other.Salary) return 1;
		if (bonus < other.bonus) return -1;
		if (bonus > other.bonus) return 1;
		return 0;
	}
	
}
class Employee extends Person implements Comparable<Object>{
	int Age;
	double Salary;
	Date hireYear;
	String InsuranceNumber;
	public Employee(String Name,int Age,Date date) {
		super();
		this.Name = Name;
		this.Age = Age;
		this.hireYear =date;
	}
	public Employee(String Name,int Age,String InsuranceNumber) {
		super();
		this.Name = Name;
		this.Age = Age;
		this.InsuranceNumber = InsuranceNumber;
		
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return Name + " " + Age + " " + hireYear;
	}
	@Override
	public boolean equals(Object o) {
	    if(o == this)
	    	return true;
	    if(!(o instanceof Employee))
	    	return false;
	    Employee e = (Employee)o;
	    return Name.equals(e.Name)&& 
	    		e.Age == Age && 
	    		hireYear == e.hireYear && 
	    		InsuranceNumber == e.InsuranceNumber && 
	    		Salary == e.Salary;
	  }
	public int hashCode() {
		int code = 17;
		code = 31 * code + Name.hashCode();
		code = 31 * code + Age;
		code = 31 * code + InsuranceNumber.hashCode();
		code = 31 * code + hireYear.hashCode();
		code = 31 * code + (int)Salary;
		return code;
	}
	@Override
	public int compareTo(Object o) {
		Employee other = (Employee) o;
		if (Salary < other.Salary) return -1;
		if (Salary > other.Salary) return 1;
		return 0;
	}
}
public class problem2 {
	public static void main(String args[]) {
		
	}
}