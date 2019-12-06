package pack;

import java.io.Serializable;

class TextBook implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ISBN;
	private String Title;
	private String Author;
	public TextBook(String ISBN,String Title,String Author) {
		this.Author = Author;
		this.ISBN = ISBN;
		this.Title = Title;
	}
	public TextBook(String Title) {
		Author = "";
		ISBN = "";
		this.Title = Title;
	}
	public TextBook() {
		Author = "";
		ISBN = "";
	    Title = "";
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public void setTitle(String Title) {
		this.Title = Title;
	}
	public void setAuthor(String Author) {
		this.Author = Author;
	}
	
	public String getISBN() {
		return ISBN;
	}
	public String getAuthor() {
		return Author;
	}
	public String getTitle() {
		return Title;
	}
	public String toString() {
		return "----------TextBook-------------\n" + "Title: " + Title + " \n" + "ISBN: " + ISBN + " \n" + "Author: " + Author;
	}
	public boolean equals(Object o) {
		if(o == this)
			return true;
		if(o == null)
			return false;
		if(!(o instanceof TextBook))
			return false;
		TextBook t = (TextBook)o;
		return t.Author.equals(Author) &&
				t.ISBN.equals(ISBN) &&
				t.Title.equals(Title);
	}
	public int hashCode() {
		int hash = 17;
		hash = 31 * hash + ISBN.hashCode();
		hash = 31 * hash + Title.hashCode();
		hash = 31 * hash + Author.hashCode();
		return hash;
		}
}

class Instructor implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String department;
	private String email;
	public Instructor(String firstName,String lastName,String department,String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.email = email;
	}
	public Instructor(String firstName,String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		department = "";
		email = "";
	}
	public Instructor() {
		firstName = "";
		lastName = "";
		department = "";
		email = "";
	}
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	public void setdepartment(String department) {
		this.department = department;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getfirstName() {
		return firstName;
	}
	public String getlastName() {
		return lastName;
	}
	public String getdepartment() {
		return department;
	}
	public String getemail() {
		return email;
	}
	public String toString() {
		return "----------Instructor-------------\n" + "Surname: " +  firstName + " \n" + "Name: " + lastName + " \n" + "Department: " + department + " \n" + email;
	}
	public boolean equals(Object o) {
		if(o == this)
			return true;
		if(o == null)
			return false;
		if(!(o instanceof Instructor))
			return false;
		Instructor i = (Instructor)o;
		return i.department.equals(department) &&
				i.email.equals(email) &&
				i.firstName.equals(firstName) &&
				i.lastName.equals(lastName);
	}
	public int hashCode() {
		int hash = 17;
		hash = 31 * hash + department.hashCode();
		hash = 31 * hash + email.hashCode();
		hash = 31 * hash + firstName.hashCode();
		hash = 31 * hash + lastName.hashCode();
		return hash;
		}
}
class Course implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String CourseTitle;
	private TextBook t;
	private Instructor i;
	public Course(String CourseTitle) {
		this.CourseTitle = CourseTitle;
		t = new TextBook();
		i = new Instructor();
	}
	public void setCoursetitle(String CourseTitle) {
		this.CourseTitle = CourseTitle;
	}
	public void setTextBook(TextBook t) {
		this.t = t;
	}
	public void setInstructor(Instructor i) {
		this.i = i;
	}
	public String getCourseTitle() {
		return CourseTitle;
	}
	public String getTextBook() {
		return t.toString();
	}
	public String getInstructor() {
		return i.toString();
	}
	public String toString() {
		return "------------Course---------------\n" + CourseTitle + " \n" + t.toString() + " \n" + i.toString();
	}
	public boolean equals(Object o) {
		if(o == this)
			return true;
		if(o == null)
			return false;
		if(!(o instanceof Course))
			return false;
		Course c = (Course)o;
		return c.CourseTitle.equals(CourseTitle) &&
				c.i.equals(i) &&
				c.t.equals(t);
	}
	public int hashCode() {
		int hash = 17;
		hash = 31 * hash + CourseTitle.hashCode();
		hash = 31 * hash + i.hashCode();
		hash = 31 * hash + t.hashCode();
		return hash;
		}
}
class Admin implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String hash(String password) {
		String h = "a" + password.hashCode() + "x";
		return h;
	}
	public Admin(String username,String password) {
		this.username = username;
		this.password = hash(password);
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public boolean equals(Object o) {
		if(o == this)
			return true;
		if(o == null)
			return false;
		if(!(o instanceof Admin))
			return false;
		Admin c = (Admin)o;
		return c.username.equals(username) &&
				c.password.equals(password);
	}
}