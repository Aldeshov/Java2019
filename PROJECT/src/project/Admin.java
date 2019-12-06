package project;

import java.io.Serializable;

public class Admin extends Employee implements Serializable,Cloneable 
{
	private static final long serialVersionUID = 1L;
	public Admin(String userName, String userPassword, String name, String department, float salary) {
		super(userName, userPassword, name, department, salary);
		ID = "ID@" + name + hashCode();
	}
}
