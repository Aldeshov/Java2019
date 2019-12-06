package project;

import java.io.Serializable;
import java.util.Vector;

public class Mark implements Serializable 
{
	private static final long serialVersionUID = 1L;
	public Student student;
	public Vector<Integer> marks = new Vector<Integer>();
	
	public int getCount() {
		int count = 0;
		for(int i = 0; i < marks.size(); i++)
			count += marks.get(i);
		return count;
	}
	
	public String toString() {
		return marks.toString() + " : " + getCount();
	}
}
