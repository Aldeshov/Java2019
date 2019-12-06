package project;

import java.io.Serializable;

public class Manager extends Employee implements Serializable,Cloneable 
{
	private static final long serialVersionUID = 1L;
	private int phoneNumber;
	
	public Manager(String userName, String userPassword, String name, String department, float salary, int phoneNumber) {
		super(userName, userPassword, name, department, salary);
		this.setPhoneNumber(phoneNumber);
		ID = "ID@" + name + hashCode();
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return ID + "\nName: " + name + " - " + phoneNumber + "\nDepartment: " + department + "\nSalary:" + salary;
	}
	
	@Override
	public int hashCode() {
		int hashCode = 17;
		hashCode = 31 * hashCode + department.hashCode();
		hashCode = 31 * hashCode + (int)salary;
		hashCode = 31 * hashCode + name.hashCode();
		hashCode = 31 * hashCode + phoneNumber;
		return hashCode;
	}
	
	@Override
	public boolean equals(Object o) {
	    if(o == this)
	    	return true;
	    if(!(o instanceof Employee))
	    	return false;
	    Manager e = (Manager)o;
	    return name.equals(e.name)&& 
	    		department.equals(e.department) && 
	    		phoneNumber == e.phoneNumber &&
	    		ID.equals(e.ID) && 
	    		salary == e.salary;
	}
	
	@Override
	public Manager clone() throws CloneNotSupportedException {
		Manager clone = (Manager)super.clone();
		return clone;
	}
}
