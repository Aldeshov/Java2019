package project;

import java.io.Serializable;
import java.util.Vector;

public class Course implements Serializable,Cloneable 
{
	private static final long serialVersionUID = 1L;
	private String name;
	private String ID;
	private int credits;
	public Schedule schedule;
	public Vector<CourseFile> courseFiles;
	public Vector<Mark> studentmarks;
	
	public Course(String name, String ID, Schedule schedule) {
		this.name = name;
		this.ID = ID;
		this.schedule = schedule;
		courseFiles = new Vector<CourseFile>();
		credits = schedule.timeCount();
		studentmarks = new Vector<Mark>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getID() {
		return ID;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public int getCredits() {
		return credits;
	}
	
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	public String toString() {
		return ID + "\n Name: " + name + "\n Credits: " + credits;
	}
	
	public int hashCode() {
		int hashCode = 17;
		hashCode = 31 * hashCode + name.hashCode();
		hashCode = 31 * hashCode + ID.hashCode();
		hashCode = 31 * hashCode + credits;
		hashCode = 31 * hashCode + schedule.hashCode();
		hashCode = 31 * hashCode + courseFiles.hashCode();
		return hashCode;
	}
	
	public boolean equals(Object o) {
	    if(o == this)
	    	return true;
	    if(!(o instanceof Employee))
	    	return false;
	    Course s = (Course)o;
	    return name.equals(s.name)&& 
	    		schedule.equals(s.schedule) && 
	    		courseFiles == s.courseFiles &&
	    		ID.equals(s.ID) && 
	    		credits == s.credits;
	}
	
	@SuppressWarnings("unchecked")
	public Course clone() throws CloneNotSupportedException {
		Course clone = (Course)super.clone();
		clone.courseFiles = (Vector<CourseFile>) courseFiles.clone();
		clone.schedule = (Schedule) this.schedule.clone();
		return clone;
	}
	
	public int compareTo(Object o) {
		Course other = (Course) o;
		if (credits < other.credits) return -1;
		if (credits > other.credits) return 1;
		return 0;
	}
}
