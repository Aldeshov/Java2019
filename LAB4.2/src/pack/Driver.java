package pack;
import java.io.*;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.Vector;

public class Driver {
	public static boolean adminmode = false;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String args[]) throws IOException {
		System.out.println("----------------------Console1.0---------------------------");
		String admin = "user";
		Admin curradmin;
		FileWriter pw = new FileWriter("C:\\Users\\azata\\JavaProjects\\LAB4.2\\bin\\pack\\admin.txt",true);
		Vector<Vector> all = new Vector<Vector>();
		Vector<Course> courses = new Vector<Course>();
		Vector<TextBook> textbooks = new Vector<TextBook>();
		Vector<Instructor> instructors = new Vector<Instructor>();
		try 
		{
		FileInputStream fis = new FileInputStream("C:\\Users\\azata\\JavaProjects\\LAB4.2\\bin\\pack\\file.out");
		ObjectInputStream oin = new ObjectInputStream(fis);
		all = (Vector<Vector>)oin.readObject();
		courses = all.get(0);
		textbooks = all.get(1);
		instructors = all.get(2);
		oin.close();
		}catch(Exception e) 
		{
			System.out.println(" !* Serialization Error: " + e.getMessage());
		}
		BufferedReader in = new BufferedReader( new InputStreamReader (System.in));		
		StringTokenizer s;
		while(true) {
			System.out.print("(" + admin + ")>");
			String sin = in.readLine();
			if(!sin.equals(""))
				s = new StringTokenizer(sin," ",true);
			else
				s = new StringTokenizer("null"," ",true);
			String next = s.nextToken();
			if(next.equals("exit"))
				break;
			if(!adminmode && next.equals("enable") && s.countTokens() == 0) {
				try {
					FileInputStream fis = new FileInputStream("C:\\Users\\azata\\JavaProjects\\LAB4.2\\bin\\pack\\adminuh.key");
					ObjectInputStream oin = new ObjectInputStream(fis);
					curradmin = (Admin)oin.readObject();
					System.out.print("\nUsername:");
					String us = in.readLine();
					System.out.print("Password:");
					String ps = in.readLine();
					Admin temp = new Admin(us,ps);
					oin.close();
					if(curradmin.equals(temp)) 
					{
						adminmode = true;
						admin = "admin";
						pw.write("\nUserName: " + curradmin.getUsername() + "\nPassword: " + curradmin.getPassword() + "\n");
						Date date = new Date();
						pw.write(date + "  admin logged in to a system\n");
					}
					else
						System.out.println("Wrong Username or password!");
				}catch(Exception e) {
					System.out.print("\n New Admin\nUserName:");
					String us = in.readLine();
					System.out.print("Password:");
					String ps = in.readLine();
					curradmin = new Admin(us,ps);
					FileOutputStream fos = new FileOutputStream("C:\\Users\\azata\\JavaProjects\\LAB4.2\\bin\\pack\\adminuh.key");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(curradmin);
					oos.flush();
					oos.close();
					adminmode = true;
					admin = "admin";
					pw.write("\nUserName:" + curradmin.getUsername() + "\nPassword" + curradmin.getPassword() + "\n");
					Date date = new Date();
					pw.write(date + "  admin logged in to a system\n");
				}
			}else
			if(adminmode && next.equals("disable")) {
				adminmode = false;
				admin = "user";
			}else
			if(adminmode && next.equals("add")) {
				if(s.countTokens() == 4 || s.countTokens() >= 6) {
					s.nextToken();
					next = s.nextToken();
				}
				if(next.equals("course")) {
					s.nextToken();
					next = s.nextToken();
					Course c = new Course(next);
					Date date = new Date();
					courses.add(c);
					pw.write(date + "  admin added new course \"" + next + "\" \n");
				}
				if(next.equals("textbook")) {
					s.nextToken();
					next = s.nextToken();
					TextBook t = new TextBook(next);
					Date date = new Date();
					textbooks.add(t);
					pw.write(date + "  admin added new TextBook \"" + next + "\" \n");
				}
				if(next.equals("instructor") && s.countTokens() >= 4) {
					s.nextToken();
					next = s.nextToken();
					s.nextToken();
					String ln = s.nextToken();
					Instructor i = new Instructor(next,ln);
					Date date = new Date();
					instructors.add(i);
					pw.write(date + "  admin added new Instructor \"" + next + " " + ln + "\" \n");
				}
			}else
			if(next.equals("insert") && adminmode) {
				if(s.countTokens() >= 6 || s.countTokens() == 2  || s.countTokens() == 4) {
					s.nextToken();
					next = s.nextToken();
				}
				for(Course c:courses)
					if(next.equals(c.getCourseTitle()) && s.countTokens() == 2) {
						s.nextToken();
						next = s.nextToken();
						if(next.equals("textbook")) {
							System.out.print("\nnew TextBook to " + c.getCourseTitle() + "\nISBN:");
							String isbn = in.readLine();
							System.out.print("Title:");
							String title = in.readLine();
							System.out.print("Author:");
							String author = in.readLine();
							Date date = new Date();
							pw.write(date + "  admin added new TextBook \"" + title + "\" for -> " + c.getCourseTitle() + " \n");
							courses.get(courses.indexOf(c)).setTextBook(new TextBook(isbn,title,author));
						}
						if(next.equals("instructor")) {
							System.out.print("\nnew Instructor to " + c.getCourseTitle() + "\nFirstname:");
							String fn = in.readLine();
							System.out.print("Lastname:");
							String ln = in.readLine();
							System.out.print("Department:");
							String d = in.readLine();
							System.out.print("email:");
							String e = in.readLine();
							Date date = new Date();
							pw.write(date + "  admin added new Instructor \"" + fn + " " + ln + "\" for -> " + c.getCourseTitle() + " \n");
							courses.get(courses.indexOf(c)).setInstructor(new Instructor(fn,ln,d,e));
						}
						break;
					}
				for(TextBook c:textbooks) {
					if(next.equals(c.getTitle()) && s.countTokens() == 0) {
							System.out.print("\nnew TextBook " + c.getTitle() + "\nISBN:");
							String isbn = in.readLine();
							System.out.print("Author:");
							String author = in.readLine();
							Date date = new Date();
							pw.write(date + "  admin inserted TextBook datas for \"" + c.getTitle() + "\" \n");
							textbooks.get(textbooks.indexOf(c)).setAuthor(author);
							textbooks.get(textbooks.indexOf(c)).setISBN(isbn);
							break;
					}
				}
			for(Instructor c:instructors) {
					if(next.equals(c.getfirstName()) && s.countTokens() == 2) {
						s.nextToken();
						next = s.nextToken();
						if(next.equals(c.getlastName())) {
							System.out.print("\nnew Instructor " + c.getfirstName()  + " " + c.getlastName() + "\nDepartment:");
							String d = in.readLine();
							System.out.print("email:");
							String e = in.readLine();
							Date date = new Date();
							pw.write(date + "  admin inserted Instructor datas for \"" + c.getfirstName()  + " " + c.getlastName() + "\" \n");
							instructors.get(instructors.indexOf(c)).setdepartment(d);
							instructors.get(instructors.indexOf(c)).setemail(e);
						}
						break;
						}
			}
			}else
			if(next.equals("view")) {
				if(s.countTokens() == 2) {
					s.nextToken();
					next = s.nextToken();
				}
				if(next.equals("list")) {
					for(Course c:courses)
						System.out.println(c.getCourseTitle());
				}else
				if(next.equals("allinfo") && adminmode) {
					System.out.println("---------Courses---------");
					for(Course c:courses)
						System.out.println(c.getCourseTitle());
					System.out.println("---------TextBooks---------");
					for(TextBook c:textbooks)
						System.out.println(c.getTitle());				
					System.out.println("---------Instructors---------");
					for(Instructor c:instructors)
						System.out.println(c.getfirstName() + " " + c.getlastName());
				}else {
					for(Course c:courses)
						if(next.equals(c.getCourseTitle())) {
							System.out.println(c);
							break;
						}
					//System.out.println("view list or all info or select");
				}
			}else
			if(next.equals("help")) {
				if(!adminmode)
					System.out.print("\n enable - into to admin mode\n view - view list or selected course\n exit - quit the program\n\n");
				else
					System.out.print("\n disable - exit from admin mode\n view - view list or all information or selected course\n exit - quit the program\n add - add a new course & etc\n insert - insert a textbook or instructor to course\n\n");
			}
			else
				System.out.println("tip help to how to use");
		}
		all.clear();
		all.add(courses);
		all.add(textbooks);
		all.add(instructors);
		//Serialization--
		try 
		{
			FileOutputStream fos = new FileOutputStream("C:\\Users\\azata\\JavaProjects\\LAB4.2\\bin\\pack\\file.out");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(all);
			oos.flush();
			oos.close();
		}catch(Exception e) 
		{
			System.out.println(e.getLocalizedMessage());
		}
		in.close();
		pw.close();
	}
}
