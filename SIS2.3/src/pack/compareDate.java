package pack;

import java.util.Comparator;

public class compareDate implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) 
	{
		return o1.hireYear.compareTo(o2.hireYear);
	}
}