package project;

import java.io.Serializable;
import java.util.Vector;

public class Registrator implements Serializable
{
	private static final long serialVersionUID = 1L;
	public Vector<Course> Courses;
	private boolean isOpen;
	
	public Registrator() {
		Courses = new Vector<Course>();
		isOpen = false;
	}
	
	public boolean openRegistrator(Vector<Course> v) {
		if(!isOpen)
		{
			isOpen = true;
			Courses = v;
			return true;
		}
		return false;
	}
	
	public boolean isOpen() {
		return isOpen;
	}
	
	public boolean closeRegistrator() {
		if(isOpen)
		{
			isOpen = false;
			Courses.removeAllElements();
			return true;
		}
		return false;
	}
	
	public Vector<Course> getRegistrationCourses() {
		if(isOpen)
			return Courses;
		else
			return (new Vector<Course>());
	}
}
