package pack3;

import java.util.Vector;

public class Manager extends Person{
	public Vector<Employee> Employees = new Vector<Employee>();
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
	
}
