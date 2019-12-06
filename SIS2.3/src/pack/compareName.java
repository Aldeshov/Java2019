package pack;

import java.util.Comparator;

public class compareName implements Comparator<Manager> {

	@Override
	public int compare(Manager o1, Manager o2) 
	{
		return o1.Name.compareTo(o2.Name);
	}
	
}
