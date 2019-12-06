package project;

import java.io.Serializable;

public class Schedule implements Serializable,Cloneable 
{
	private static final long serialVersionUID = 1L;
	private boolean[][] day;
	
	public Schedule() {
		day = new boolean[7][12];
	}
	
	public boolean setDay(int i, int j) {
		day[i][j] = true;
		return true;
	}
	
	public boolean getDay(int i, int j) {
		return day[i][j];
	}
	
	public Schedule clone() {
		return this.clone();
	}
	
	public int timeCount() {
		int count = 0;
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 12; j++) {
				if(day[i][j])
					count++;
			}
		}
		return count;
	}
	
	public String toString() {
		String s = "             |   Monday    |  Tuesday    |Wednesday | Thursday    |     Friday     |  Saturday   |    Sunday    |\n";
		for(int j = 0; j < 12; j++) 
		{
			if(j < 2)
				s += "  " + (j + 8) + ":00    |";
			else
				s += " " + (j + 8) + ":00   |";
			for(int i = 0; i < 7; i++) 
			{
				if(day[i][j])
				{
					s += "|||||||||||||||||||||";
				}
				else
					s += "                     ";
				s += "|";
			}
			s += "\n";
		}
		return s;
	}
}
