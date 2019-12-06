package project;

import java.io.Serializable;
import java.util.Vector;

public class Teacher extends Employee implements Serializable,Cloneable 
{
	private static final long serialVersionUID = 1L;
	public Vector<Course> courses;
	private TeachersTitle TEACHERSTITLE;
	
	public Teacher(String userName, String userPassword, String name, TeachersTitle TEACHERSTITLE, String department, float salary) {
		super(userName, userPassword, name, department, salary);
		courses = new Vector<Course>();
		this.TEACHERSTITLE = TEACHERSTITLE;
		ID = "ID@" + name + hashCode();
	}

	public TeachersTitle getTEACHERSTITLE() {
		return TEACHERSTITLE;
	}

	public void setTEACHERSTITLE(TeachersTitle TEACHERSTITLE) {
		this.TEACHERSTITLE = TEACHERSTITLE;
	}
	
	@Override
	public String toString() {
		return ID + "\nName: " + name + " - " + TEACHERSTITLE + "\nDepartment: " + department + "\nSalary:" + salary;
	}
	
	@Override
	public int hashCode() {
		int hashCode = 17;
		hashCode = 31 * hashCode + department.hashCode();
		hashCode = 31 * hashCode + (int)salary;
		hashCode = 31 * hashCode + name.hashCode();
		hashCode = 31 * hashCode + courses.hashCode();
		hashCode = 31 * hashCode + TEACHERSTITLE.hashCode();
		return hashCode;
	}
	
	@Override
	public boolean equals(Object o) {
	    if(o == this)
	    	return true;
	    if(!(o instanceof Employee))
	    	return false;
	    Teacher e = (Teacher)o;
	    return name.equals(e.name)&& 
	    		department.equals(e.department) && 
	    		TEACHERSTITLE.equals(e.TEACHERSTITLE) &&
	    		courses == e.courses &&
	    		ID.equals(e.ID) && 
	    		salary == e.salary;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Teacher clone() throws CloneNotSupportedException {
		Teacher clone = (Teacher)super.clone();
		clone.courses = (Vector<Course>) courses.clone();
		return clone;
	}
	
}
