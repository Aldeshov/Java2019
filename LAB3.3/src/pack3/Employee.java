package pack3;
public class Employee extends Person{
	int Age;
	double Salary;
	int Year;
	String InsuranceNumber;
	public Employee(String Name,int Age) {
		super();
		this.Name = Name;
		this.Age = Age;
	}
	public Employee(String Name,int Age,int Year,String InsuranceNumber) {
		super();
		this.Name = Name;
		this.Age = Age;
		this.Year = Year;
		this.InsuranceNumber = InsuranceNumber;
		
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return Name + " " + Age + " " + Year;
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
	    		Year == e.Year && 
	    		InsuranceNumber == e.InsuranceNumber && 
	    		Salary == e.Salary;
	  }
	public int hashCode() {
		int code = 17;
		code = 31 * code + Name.hashCode();
		code = 31 * code + Age;
		code = 31 * code + InsuranceNumber.hashCode();
		code = 31 * code + Year;
		code = 31 * code + (int)Salary;
		return code;
	}
}