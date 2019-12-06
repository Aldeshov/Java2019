package project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Vector;

public class DataBase
{
	@SuppressWarnings("rawtypes")
	public Vector<Vector> allData;
	public Vector<User> users;
	public Vector<Course> courses;
	public Registrator regData;
	public Calendar date;
	
	@SuppressWarnings("rawtypes")
	public DataBase() {
		allData = new Vector<Vector>();
		users = new Vector<User>();
		courses = new Vector<Course>();
		regData = new Registrator();
	}
	
	public boolean WriteLog(String s) throws IOException {
		try 
		{
			date = Calendar.getInstance();
			FileWriter pw = new FileWriter("log.FileL",true);
			pw.write("* " + date.getTime() + " : " + s + "\n");
			pw.close();
			return true;
		}
		catch(Exception ex) 
		{
			System.out.println(" !* LogWriteError: " + ex.getLocalizedMessage());
			return false;
		}
	}
	
	public boolean Serialize() {
		try 
		{
			FileOutputStream fos0 = new FileOutputStream("reg.FileC");
			ObjectOutputStream oos0 = new ObjectOutputStream(fos0);
			oos0.writeObject(regData);
			oos0.flush();
			oos0.close();
			
			/////////////////////////////////////////////////////////
			
			allData.clear();
			allData.add(users);
			allData.add(courses);
			FileOutputStream fos = new FileOutputStream("allData.fileS");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(allData);
			oos.flush();
			oos.close();
			return true;
		}
		catch(Exception e) 
		{
			System.out.println(" !* Serialization Error: " + e.getLocalizedMessage());
			return false;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean DeSerialize() {
		try
		{
			FileInputStream fis0 = new FileInputStream("reg.FileC");
			ObjectInputStream oin0 = new ObjectInputStream(fis0);
			regData = (Registrator) oin0.readObject();
			oin0.close();
		}
		catch(Exception e)
		{
			if(users.size() == 0)
			{
				System.out.println("admin default added: " + e.getMessage());
				users.add(new Admin("admin","password","Admin","Department",(float) 0.0));
				Serialize();
			}
			else
				System.out.println("It seems you deleted needed file: " + e.getMessage());
			return false;
		}
		
		/////////////////////////////////////////////////////////
		
		try
		{
			FileInputStream fis = new FileInputStream("allData.fileS");
			ObjectInputStream oin = new ObjectInputStream(fis);
			allData = (Vector<Vector>) oin.readObject();
			users = allData.get(0);
			courses = allData.get(1);
			oin.close();
		}
		catch(Exception e)
		{
			System.out.println("admin default added: " + e.getMessage());
			users.add(new Admin("admin","password","Admin","Department",(float) 0.0));
			Serialize();
			return false;
		}
		return true;
	}	
}
