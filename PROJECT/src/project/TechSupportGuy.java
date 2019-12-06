package project;

import java.util.Calendar;
import java.util.Vector;

public class TechSupportGuy extends Employee
{
	private static final long serialVersionUID = 1L;
	public Vector<String> messages = new Vector<String>();
	public Vector<Boolean> status = new Vector<Boolean>();
	public Vector<Boolean> read = new Vector<Boolean>();
	
	public TechSupportGuy(String userName, String userPassword, String name, String department, float salary) {
		super(userName, userPassword, name, department, salary);
		ID = "ID@" + name + hashCode();
	}
	
	public boolean addMessage(String s) {
		Calendar c = Calendar.getInstance();
		messages.add((status.size() + 1) +  ") " + c.getTime() + " : " + s);
		status.add(false);
		read.add(false);
		return true;
	}
}
