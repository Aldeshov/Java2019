package project;

import java.io.Serializable;

public class Employee extends User implements Serializable,Cloneable 
{
	private static final long serialVersionUID = 1L;
	protected String name;
	protected String ID;
	protected String department;
	protected float salary;
	
	public Employee(String userName,String userPassword,String name, String department, float salary) {
		isRegistered = false;
		if(setUserName(userName) && setUserPassword(userPassword))
			isRegistered = true;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	
	public String setName(String name) {
		this.name = name;
		return name;
	}
	public String getID() {
		return ID;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public String setDepartment(String department) {
		this.department = department;
		return department;
	}
	
	public float getSalary() {
		return salary;
	}
	
	public float setSalary(float salary) {
		this.salary = salary;
		return salary;
	}
	
	@Override
	public String getUserName() {
		if(isRegistered)
			return userName;
		return null;
	}
	
	@Override
	public boolean setUserName(String userName) {
		if(userName.length() >= 4) {
			if(userName.contains(" "))
				return false;
			this.userName = userName;
			if(userPassword != null)
				isRegistered = true;
			return true;
		}
		return false;
	}

	@Override
	public boolean setUserPassword(String userPassword) {
		if(userPassword.length() >= 6) {
			this.userPassword = getHash(userPassword);
			if(userName != null)
				isRegistered = true;
			return true;
		}
		return false;
	}
	
	@Override
	public String getHashPassword() {
		if(isRegistered)
			return userPassword;
		return null;
	}

	@Override
	public String getHash(String userPassword) {
		String hash = "hash" + userPassword.hashCode() + (userPassword.length() * 3) + "Code";
		return hash;
	}

	@Override
	public String toString() {
		return ID + "\nName: " + name + "\nDepartment: " + department + "\nSalary:" + salary;
	}
	
	public int hashCode() {
		int hashCode = 17;
		hashCode = 31 * hashCode + department.hashCode();
		hashCode = 31 * hashCode + (int)salary;
		hashCode = 31 * hashCode + name.hashCode();
		return hashCode;
	}
	
	public boolean equals(Object o) {
	    if(o == this)
	    	return true;
	    if(!(o instanceof Employee))
	    	return false;
	    Employee e = (Employee)o;
	    return name.equals(e.name)&& 
	    		department.equals(e.department) && 
	    		ID.equals(e.ID) && 
	    		salary == e.salary;
	}
	
	public Employee clone() throws CloneNotSupportedException {
		Employee clone = (Employee)super.clone();
		return clone;
	}
	
	public int compareTo(Object o) {
		Employee other = (Employee) o;
		if (salary < other.salary) return -1;
		if (salary > other.salary) return 1;
		return 0;
	}
}
