package pack;

import java.util.Date;

public class Employee extends Person implements Comparable<Object>,Cloneable{
	int Age;
	double Salary;
	Date hireYear;
	String InsuranceNumber;
	public Employee(String Name,int Age,Date date) {
		super();
		this.Name = Name;
		this.Age = Age;
		this.hireYear = date;
		InsuranceNumber = "Null";
	}
	public Employee(String Name,int Age,String InsuranceNumber) {
		super();
		this.Name = Name;
		this.Age = Age;
		this.InsuranceNumber = InsuranceNumber;
		hireYear = new Date();
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
	public Employee clone() throws CloneNotSupportedException {
		Employee clone = (Employee)super.clone();
		clone.hireYear = (Date) hireYear.clone();
		return clone;
	}
}
