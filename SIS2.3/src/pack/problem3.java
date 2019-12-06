package pack;

import java.util.*;

public class problem3 {
	@SuppressWarnings("deprecation")
	public static void main(String args[]) throws CloneNotSupportedException 
	{
		Vector<Employee> e = new Vector<Employee>();
		e.add(new Employee("Aaa",18,new Date(1,1,1)));
		e.add(new Employee("Bbb",24,new Date(-15,3,1)));
		e.add(new Employee("Ccc",16,new Date(7,1,1)));
		e.add(new Employee("Ddd",34,new Date(-19,1,1)));
		e.add(new Employee("Eee",28,new Date(-16,1,1)));
		e.sort(new compareDate());
		System.out.println(e);
		Vector<Manager> m = new Vector<Manager>();
		m.add(new Manager("Eee"));
		m.add(new Manager("Aaa"));
		m.add(new Manager("Ccc"));
		m.add(new Manager("Ddd"));
		m.add(new Manager("Bbb"));
		m.sort(new compareName());
		System.out.println(m);
		Employee original = new Employee("Name",18,new Date());
		Employee clone = (Employee) original.clone();
		System.out.println(clone.toString());
	}
}