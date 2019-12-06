package project;

import java.io.Serializable;
import java.util.Vector;

public class Student extends User implements Serializable,Cloneable 
{
	private static final long serialVersionUID = 1L;
	private String name;
	private Faculty FACULTY;
	private String specialty;
	private int currentYear = 0;
	private final String ID;
	public Vector<Course> courses;
	
	public Student(String userName,String userPassword,String name,Faculty FACULTY, String specialty) {
		isRegistered = false;
		if(setUserName(userName) && setUserPassword(userPassword))
			isRegistered = true;
		this.name = name;
		this.FACULTY = FACULTY;
		this.specialty = specialty;
		courses = new Vector<Course>();
		ID = "ID@" + name + hashCode();
		upYear();
	}
	
	public String getID() {
		return ID;
	}
	
	public void upYear() {
		currentYear++;
	}
	public Faculty getFaculty() {
		return FACULTY;
	}
	
	public String getName() {
		return name;
	}
	
	public String setName(String name) {
		this.name = name;
		return name;
	}
	
	public String getSpecialty() {
		return specialty;
	}
	
	public String setSpecialty(String specialty) {
		this.specialty = specialty;
		return specialty;
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
		return ID + "\n Name: " + name + "\n Faculty: " + FACULTY + " :-> " + specialty + "\n CurrentYear:" + currentYear;
	}
	
	public int hashCode() {
		int hashCode = 17;
		hashCode = 31 * hashCode + specialty.hashCode();
		hashCode = 31 * hashCode + FACULTY.hashCode();
		hashCode = 31 * hashCode + (int)currentYear;
		hashCode = 31 * hashCode + name.hashCode();
		return hashCode;
	}
	
	public boolean equals(Object o) {
	    if(o == this)
	    	return true;
	    if(!(o instanceof Employee))
	    	return false;
	    Student s = (Student)o;
	    return name.equals(s.name)&& 
	    		specialty.equals(s.specialty) && 
	    		FACULTY == s.FACULTY &&
	    		ID.equals(s.ID) && 
	    		currentYear == s.currentYear;
	}
	
	@SuppressWarnings("unchecked")
	public Student clone() throws CloneNotSupportedException {
		Student clone = (Student)super.clone();
		clone.courses = (Vector<Course>) courses.clone();
		return clone;
	}
	
	public int compareTo(Object o) {
		Student other = (Student) o;
		if (currentYear < other.currentYear) return -1;
		if (currentYear > other.currentYear) return 1;
		return 0;
	}
}
