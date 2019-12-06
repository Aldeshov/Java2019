package pack;

import java.util.Vector;

public class Manager extends Employee implements Comparable<Object>,Cloneable{
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
	public Manager clone() throws CloneNotSupportedException {
		Manager clone = (Manager)super.clone();
		clone.Employees = Employees;
		return clone;
	}
}