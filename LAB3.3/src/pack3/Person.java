package pack3;

public class Person{
	public String Name;
	public Person() {
		
	}
	public String toString() {
		return Name;
	}
	public boolean equals(Object o) {
	    if(o == this)
	    	return true;
	    if(!(o instanceof Employee))
	    	return false;
	    
	    Person e = (Person)o;
	    return Name.equals(e.Name);
	  }
}