package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.*;

public class Program extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JButton teacher = new JButton("Teachers");
	private JButton manager = new JButton("Managers");
	private JButton student = new JButton("Student");
	private JButton admin = new JButton("Admin");
	private JButton techGuy = new JButton("Tech Support Guy");
	private DataBase DB = new DataBase();
	
	public Program() {
		super("Intranet");
		this.setBounds(100,100,400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DB.DeSerialize();
		Container container = new Container();
		container.setLayout(new GridLayout(14,14,4,4));
		teacher.addActionListener(new Action(0));
		admin.addActionListener(new Action(1));
		manager.addActionListener(new Action(2));
		student.addActionListener(new Action(3));
		techGuy.addActionListener(new Action(4));
		container.add(teacher);
		container.add(admin);
		container.add(manager);
		container.add(student);
		container.add(techGuy);
		this.setContentPane(container);
	}
	
	
	class Action extends JFrame implements ActionListener
	{
		private JLabel forpassword = new JLabel("Password:");
		private JLabel forname = new JLabel("Username:");
		private JPasswordField password = new JPasswordField("",5);
		private JTextField username = new JTextField("",5);
		private JButton login = new JButton("login");
		private int userint;
		private static final long serialVersionUID = 1L;
		
		public Action(int i) {
			super("LogIn");
			userint = i;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			this.setBounds(100,100,400,400);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container container = new Container();
			container.setLayout(new GridLayout(15,15,2,2));
			container.add(forname);
			container.add(username);
			container.add(forpassword);
			container.add(password);
			login.addActionListener(new CheckPassword());
			container.add(login);
			this.setContentPane(container);
			this.setVisible(true);
			Program.this.dispose();
		}
		
		class CheckPassword implements ActionListener
		{
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				String n = username.getText();
				String p = password.getText();
				String message= "AccessDenied";
				if(userint == 0) {
					for(int j = 0; j < DB.users.size(); j++) {
						if(DB.users.get(j) instanceof Teacher && ((Teacher)DB.users.get(j)).isRegistered())
						{
							if(DB.users.get(j).getHashPassword().equals(DB.users.get(j).getHash(p)) && DB.users.get(j).getUserName().equals(n))
							{
								Action.this.dispose();
								TeacherIntranet teacher = new TeacherIntranet((Teacher) DB.users.get(j));
								teacher.setVisible(true);
								try {
									DB.WriteLog("Teacher: " + ((Teacher) DB.users.get(j)).getName() + " logged in");
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								return;
							}
						}
					}
				}
				else
					if(userint == 1) {
						for(int j = 0; j < DB.users.size(); j++) {
							if(DB.users.get(j) instanceof Admin && ((Admin)DB.users.get(j)).isRegistered())
							{
								if(DB.users.get(j).getHashPassword().equals(DB.users.get(j).getHash(p)) && DB.users.get(j).getUserName().equals(n))
								{
									Action.this.dispose();
									AdminIntranet admin = new AdminIntranet((Admin) DB.users.get(j));
									admin.setVisible(true);
									try {
										DB.WriteLog("Admin: " + ((Admin) DB.users.get(j)).getName() + " logged in");
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									return;
								}
							}
						}
					}
					else
						if(userint == 2) {
							for(int j = 0; j < DB.users.size(); j++) {
								if(DB.users.get(j) instanceof Manager && ((Manager)DB.users.get(j)).isRegistered())
								{
									if(DB.users.get(j).getHashPassword().equals(DB.users.get(j).getHash(p)) && DB.users.get(j).getUserName().equals(n))
									{
										ManagerIntranet manager = new ManagerIntranet((Manager) DB.users.get(j));
										manager.setVisible(true);
										Action.this.dispose();
										try {
											DB.WriteLog("Manager: " + ((Manager) DB.users.get(j)).getName() + " logged in");
										} catch (IOException e1) {
											e1.printStackTrace();
										}
										return;
									}
								}
							}
						}
						else
							if(userint == 3) {
								for(int j = 0; j < DB.users.size(); j++) {
									if(DB.users.get(j) instanceof Student && ((Student)DB.users.get(j)).isRegistered())
									{
										if(DB.users.get(j).getHashPassword().equals(DB.users.get(j).getHash(p)) && DB.users.get(j).getUserName().equals(n))
										{
											Action.this.dispose();
											StudentIntranet student = new StudentIntranet(((Student) DB.users.get(j)));
											student.setVisible(true);
											try {
												DB.WriteLog("Student: " + ((Student) DB.users.get(j)).getName() + " logged in");
											} catch (IOException e1) {
												e1.printStackTrace();
											}
											return;
										}
									}
								}
							}
							else
								if(userint == 4) {
									for(int j = 0; j < DB.users.size(); j++) {
										if(DB.users.get(j) instanceof TechSupportGuy && ((TechSupportGuy)DB.users.get(j)).isRegistered())
										{
											if(DB.users.get(j).getHashPassword().equals(DB.users.get(j).getHash(p)) && DB.users.get(j).getUserName().equals(n))
											{
												Action.this.dispose();
												TechSupportGuyIntranet techSupportGuy = new TechSupportGuyIntranet((TechSupportGuy) DB.users.get(j));
												techSupportGuy.setVisible(true);
												try {
													DB.WriteLog("TechSupportGuy: " + ((TechSupportGuy) DB.users.get(j)).getName() + " logged in");
												} catch (IOException e1) {
													e1.printStackTrace();
												}
												return;
											}
										}
									}
								}
				JOptionPane.showMessageDialog(null, message,"Wrong",JOptionPane.PLAIN_MESSAGE);
			}
		}
//////////------------------------------#TechSupportGuyIntranet#---------------------------------//
		class TechSupportGuyIntranet extends JFrame
		{
			private static final long serialVersionUID = 1L;
			private TechSupportGuy thistechsupportguy;
			private JButton information = new JButton("Information");
			private JButton viewmessages = new JButton("Messages(Orders)");
			private JButton setUserName = new JButton("Set User Name");
			private JButton setPassword = new JButton("Set Password");
			
			public TechSupportGuyIntranet(TechSupportGuy t) {
				super(t.getName());
				thistechsupportguy = t;
				this.setBounds(100,100,400,400);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Container container = new Container();
				container.setLayout(new GridLayout(14,14,4,4));
				information.addActionListener(new Information());
				viewmessages.addActionListener(new messages());
				setPassword.addActionListener(new setPassword());
				setUserName.addActionListener(new setUserName());
				container.add(information);
				container.add(viewmessages);
				container.add(setPassword);
				container.add(setUserName);
				this.setContentPane(container);
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////
			class messages extends JFrame implements ActionListener
			{
				private static final long serialVersionUID = 1L;
				private JLabel messages[];
				private JButton done[];
				private JButton returning;
				
				public messages() {
					super("Messages");
				}
				
				@Override
				public void actionPerformed(ActionEvent e) {
					this.setBounds(100,100,640,480);
					this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					returning = new JButton("Return");
					Container container = new Container();
					container.setLayout(new GridLayout(14,14,4,4));
					messages = new JLabel[thistechsupportguy.messages.size()];
					done = new JButton[thistechsupportguy.messages.size()];
					for(int i = 0; i < thistechsupportguy.messages.size(); i++) 
					{
						if(!thistechsupportguy.read.get(i))
						{
							if(!thistechsupportguy.status.get(i))
							{
								messages[i] = new JLabel("**New!**  " + thistechsupportguy.messages.get(i).toString() + " | " + "Not Done Yet");
								done[i] = new JButton("Done!");
								done[i].addActionListener(new ddone(i));
								container.add(messages[i]);
								container.add(done[i]);
								thistechsupportguy.read.set(i, true);
							}
							else
							{
								messages[i] = new JLabel("**New!**  " + thistechsupportguy.messages.get(i).toString() + " | " + "Done");
								thistechsupportguy.read.set(i, true);
								container.add(messages[i]);
							}
						}
						else
						{
							if(!thistechsupportguy.status.get(i))
							{
								messages[i] = new JLabel(thistechsupportguy.messages.get(i).toString() + " | " + "Not Done Yet");
								done[i] = new JButton("Done!");
								done[i].addActionListener(new ddone(i));
								container.add(messages[i]);
								container.add(done[i]);
							}
							else
							{
								messages[i] = new JLabel(thistechsupportguy.messages.get(i).toString() + " | " + "Done");
								container.add(messages[i]);
							}
						}
					}
					DB.Serialize();
					returning.addActionListener(new Return());
					container.add(returning);
					this.setContentPane(container);
					this.setVisible(true);
				}
				
				class Return implements ActionListener
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						messages.this.dispose();
					}
				}

				class ddone implements ActionListener
				{
					private int i;
					public ddone(int i) {
						this.i = i;
					}
					
					@Override
					public void actionPerformed(ActionEvent e) {
						thistechsupportguy.status.set(i, true);
						try {
							DB.WriteLog("TechSupport Guy " + thistechsupportguy.getName() + " has Done order: " + i);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						DB.Serialize();
						messages.this.dispose();
					}
					
				}
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////
			class Information implements ActionListener
			{
				@Override
				public void actionPerformed(ActionEvent e) {
					String message = thistechsupportguy.toString();
					JOptionPane.showMessageDialog(null, message,"INFORMATION",JOptionPane.PLAIN_MESSAGE);
				}
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////
			class setUserName extends JFrame implements ActionListener
			{
				private static final long serialVersionUID = 1L;
				private JLabel username;
				private JTextField tusername;
				private JButton change;
				
				public setUserName() {
					super("Set User Name:");
				}
				
				@Override
				public void actionPerformed(ActionEvent e) {
					this.setBounds(100,100,400,400);
					this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					username = new JLabel("New User Name to Change:");
					tusername = new JTextField("",5);
					change = new JButton("Change");
					Container container = new Container();
					container.setLayout(new GridLayout(14,14,4,4));
					container.add(username);
					container.add(tusername);
					change.addActionListener(new Change());
					container.add(change);
					this.setContentPane(container);
					this.setVisible(true);
				}
				
				class Change implements ActionListener
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						String message = "Cannot Change!";
						if(thistechsupportguy.setUserName(tusername.getText())) 
						{
							message = "Succesfull!";
						}
						JOptionPane.showMessageDialog(null, message,"Changing",JOptionPane.PLAIN_MESSAGE);
						setUserName.this.dispose();
						DB.Serialize();
					}
				}
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////
			class setPassword extends JFrame implements ActionListener
			{
				private static final long serialVersionUID = 1L;
				private JLabel password;
				private JTextField tpassword;
				private JButton change;
				
				public setPassword() {
					super("Set User Name:");
				}
				
				@Override
				public void actionPerformed(ActionEvent e) {
					this.setBounds(100,100,400,400);
					this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					password = new JLabel("New User Password to Change:");
					tpassword = new JTextField("",5);
					change = new JButton("Change");
					Container container = new Container();
					container.setLayout(new GridLayout(14,14,4,4));
					container.add(password);
					container.add(tpassword);
					change.addActionListener(new Change());
					container.add(change);
					this.setContentPane(container);
					this.setVisible(true);
				}
				
				class Change implements ActionListener
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						String message = "Cannot Change!";
						if(thistechsupportguy.setUserPassword(tpassword.getText())) 
						{
							message = "Succesfull!";
						}
						JOptionPane.showMessageDialog(null, message,"Changing",JOptionPane.PLAIN_MESSAGE);
						setPassword.this.dispose();
						DB.Serialize();
					}
				}
			}
		}
//////////---------------------------------#ManagerIntranet#-------------------------------------//
		class ManagerIntranet extends JFrame
		{
			private static final long serialVersionUID = 1L;
			private Manager thismanager;
			private JButton information = new JButton("Information");
			private JButton openregistr = new JButton("Regisration");
			private JButton viewst = new JButton("View Students & Teachers");
			private JButton setUserName = new JButton("Set User Name");
			private JButton setPassword = new JButton("Set Password");
			
			public ManagerIntranet(Manager m) {
				super(m.getName());
				thismanager = m;
				this.setBounds(100,100,400,400);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Container container = new Container();
				container.setLayout(new GridLayout(14,14,4,4));
				information.addActionListener(new Information());
				openregistr.addActionListener(new openRegistr());
				viewst.addActionListener(new viewAll());
				setPassword.addActionListener(new setPassword());
				setUserName.addActionListener(new setUserName());
				container.add(information);
				container.add(openregistr);
				container.add(viewst);
				container.add(setPassword);
				container.add(setUserName);
				this.setContentPane(container);
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////
			class openRegistr extends JFrame implements ActionListener
			{
				private static final long serialVersionUID = 1L;
				private JCheckBox coursesch[];
				private JLabel labels[];
				private JButton openreg;
				private JButton closereg;
				
				public openRegistr() {
					super("Opening Registration");
				}
				
				@Override
				public void actionPerformed(ActionEvent e) {
					this.setBounds(100,100,400,400);
					this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					openreg = new JButton("Open Registration");
					closereg = new JButton("Close Registration");
					Container container = new Container();
					container.setLayout(new GridLayout(14,14,4,4));
					DB.DeSerialize();
					if(DB.regData.isOpen())
					{
						labels = new JLabel[DB.regData.Courses.size()];
						for(int i = 0; i < DB.regData.Courses.size(); i++)
						{
							labels[i] = new JLabel(DB.regData.Courses.get(i).toString());
							container.add(labels[i]);
						}
						closereg.addActionListener(new close());
						container.add(closereg);
					}
					else
					{
						labels = new JLabel[DB.courses.size()];
						coursesch = new JCheckBox[DB.courses.size()];
						for(int i = 0; i < DB.courses.size(); i++)
						{
							labels[i] = new JLabel(DB.courses.get(i).toString());
							coursesch[i] = new JCheckBox("");
							container.add(labels[i]);
							container.add(coursesch[i]);
						}
						openreg.addActionListener(new open());
						container.add(openreg);
					}
					this.setContentPane(container);
					this.setVisible(true);
				}
				
				class close implements ActionListener
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						String message = "ERROR: ";
						try
						{
							DB.regData.closeRegistrator();
							DB.WriteLog("Manager: " + thismanager.getName() + " closed registration");
							DB.Serialize();
							message = "Succesfull";
						}
						catch(Exception ex)
						{
							message += ex.getMessage();
						}
						JOptionPane.showMessageDialog(null, message,"INFORMATION",JOptionPane.PLAIN_MESSAGE);
						openRegistr.this.dispose();
					}
				}
				
				class open implements ActionListener
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						String message = "ERROR: ";
						try
						{
							Vector<Course> cc = new Vector<Course>();
							for(int i = 0; i < DB.courses.size(); i++)
							{
								if(coursesch[i].isSelected())
									cc.add(DB.courses.get(i));
							}
							DB.regData.openRegistrator(cc);
							DB.WriteLog("Manager: " + thismanager.getName() + " opened registration");
							DB.Serialize();
							message = "Succesfull";
						}
						catch(Exception ex)
						{
							message += ex.getMessage();
						}
						JOptionPane.showMessageDialog(null, message,"INFORMATION",JOptionPane.PLAIN_MESSAGE);
						openRegistr.this.dispose();
					}
				}
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////
			class viewAll extends JFrame implements ActionListener
			{
				private static final long serialVersionUID = 1L;

				@Override
				public void actionPerformed(ActionEvent e) {
					String message = "-------------Teachers:\n";
					int j = 1;
					for(int i = 0; i < DB.users.size(); i++)
					{
						if(DB.users.get(i) instanceof Teacher)
						{
							message += j + " " + DB.users.get(i).toString() + "\n";
							j++;
						}
					}
					message += "-------------Students:\n";
					j = 1;
					for(int i = 0; i < DB.users.size(); i++)
					{
						if(DB.users.get(i) instanceof Student)
						{
							message += j + " " + DB.users.get(i).toString() + "\n";
							j++;
						}
					}
					JOptionPane.showMessageDialog(null, message,"TEACHERS&STUDENTS",JOptionPane.PLAIN_MESSAGE);
				}
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////
			class Information implements ActionListener
			{
				@Override
				public void actionPerformed(ActionEvent e) {
					String message = thismanager.toString();
					JOptionPane.showMessageDialog(null, message,"INFORMATION",JOptionPane.PLAIN_MESSAGE);
				}
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////
			class setUserName extends JFrame implements ActionListener
			{
				private static final long serialVersionUID = 1L;
				private JLabel username;
				private JTextField tusername;
				private JButton change;
				
				public setUserName() {
					super("Set User Name:");
				}
				
				@Override
				public void actionPerformed(ActionEvent e) {
					this.setBounds(100,100,400,400);
					this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					username = new JLabel("New User Name to Change:");
					tusername = new JTextField("",5);
					change = new JButton("Change");
					Container container = new Container();
					container.setLayout(new GridLayout(14,14,4,4));
					container.add(username);
					container.add(tusername);
					change.addActionListener(new Change());
					container.add(change);
					this.setContentPane(container);
					this.setVisible(true);
				}
				
				class Change implements ActionListener
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						String message = "Cannot Change!";
						if(thismanager.setUserName(tusername.getText())) 
						{
							message = "Succesfull!";
						}
						JOptionPane.showMessageDialog(null, message,"Changing",JOptionPane.PLAIN_MESSAGE);
						setUserName.this.dispose();
						DB.Serialize();
					}
				}
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////
			class setPassword extends JFrame implements ActionListener
			{
				private static final long serialVersionUID = 1L;
				private JLabel password;
				private JTextField tpassword;
				private JButton change;
				
				public setPassword() {
					super("Set User Name:");
				}
				
				@Override
				public void actionPerformed(ActionEvent e) {
					this.setBounds(100,100,400,400);
					this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					password = new JLabel("New User Password to Change:");
					tpassword = new JTextField("",5);
					change = new JButton("Change");
					Container container = new Container();
					container.setLayout(new GridLayout(14,14,4,4));
					container.add(password);
					container.add(tpassword);
					change.addActionListener(new Change());
					container.add(change);
					this.setContentPane(container);
					this.setVisible(true);
				}
				
				class Change implements ActionListener
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						String message = "Cannot Change!";
						if(thismanager.setUserPassword(tpassword.getText())) 
						{
							message = "Succesfull!";
						}
						JOptionPane.showMessageDialog(null, message,"Changing",JOptionPane.PLAIN_MESSAGE);
						setPassword.this.dispose();
						DB.Serialize();
					}
				}
			}
		}
//////////---------------------------------#StudentIntranet#-------------------------------------//
		class StudentIntranet extends JFrame
		{
			private static final long serialVersionUID = 1L;
			private Student thisstudent;
			private JButton information = new JButton("Information");
			private JButton icourses = new JButton("Courses");
			private JButton setUserName = new JButton("Set User Name");
			private JButton setPassword = new JButton("Set Password");
			
			public StudentIntranet(Student s) {
				super(s.getName());
				thisstudent = s;
				this.setBounds(100,100,400,400);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Container container = new Container();
				container.setLayout(new GridLayout(14,14,4,4));
				information.addActionListener(new Information());
				icourses.addActionListener(new ICourses());
				setPassword.addActionListener(new setPassword());
				setUserName.addActionListener(new setUserName());
				container.add(information);
				container.add(icourses);
				container.add(setPassword);
				container.add(setUserName);
				this.setContentPane(container);
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////
			class Information implements ActionListener
			{
				@Override
				public void actionPerformed(ActionEvent e) {
					String message = thisstudent.toString();
					JOptionPane.showMessageDialog(null, message,"INFORMATION",JOptionPane.PLAIN_MESSAGE);
				}
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////
			class ICourses extends JFrame implements ActionListener
			{
				private static final long serialVersionUID = 1L;
				private JLabel lcourses[];
				private JButton buttons[];
				private JButton registercourse;
				
				public ICourses() {
					super("All Courses");
				}
				
				@Override
				public void actionPerformed(ActionEvent e) {
					this.setBounds(100,100,400,400);
					this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					registercourse = new JButton("Register to new Course");
					Container container = new Container();
					container.setLayout(new GridLayout(14,14,4,4));
					lcourses = new JLabel[thisstudent.courses.size()];
					buttons = new JButton[thisstudent.courses.size()];
					for(int i = 0; i < thisstudent.courses.size(); i++) {
						lcourses[i] = new JLabel(thisstudent.courses.get(i).getName() + " Credits: " + thisstudent.courses.get(i).getCredits());
						buttons[i] = new JButton("View Schedule & Marks");
						buttons[i].addActionListener(new view(i));
						container.add(lcourses[i]);
						container.add(buttons[i]);
					}
					if(DB.regData.isOpen())
					{
						registercourse.addActionListener(new register());
						container.add(registercourse);
					}
					else
					{
						registercourse.addActionListener(new regisnotopen());
						container.add(registercourse);
					}
					this.setContentPane(container);
					this.setVisible(true);
				}
				
				class regisnotopen implements ActionListener
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Registration is Not open","Warning",JOptionPane.PLAIN_MESSAGE);
						ICourses.this.dispose();
					}
				}
				
				class register extends JFrame implements ActionListener
				{
					private static final long serialVersionUID = 1L;
					private JLabel courses[];
					private JButton regs[];
					private JButton returning;
					
					public register() {
						super("Registration");
					}
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ICourses.this.dispose();
						this.setBounds(100,100,400,400);
						this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						returning = new JButton("Return");
						Container container = new Container();
						container.setLayout(new GridLayout(14,14,4,4));
						courses = new JLabel[DB.regData.getRegistrationCourses().size()];
						regs = new JButton[DB.regData.getRegistrationCourses().size()];
						for(int i = 0; i < DB.regData.getRegistrationCourses().size(); i++)
						{
							courses[i] = new JLabel(DB.regData.getRegistrationCourses().get(i).toString());
							regs[i] = new JButton("Registr");
							regs[i].addActionListener(new regc(i));
							container.add(courses[i]);
							container.add(regs[i]);
						}
						container.add(returning);
						returning.addActionListener(new Return());
						this.setContentPane(container);
						this.setVisible(true);
					}
					
					class Return implements ActionListener
					{
						@Override
						public void actionPerformed(ActionEvent e) {
							register.this.dispose();
						}
					}
					
					class regc implements ActionListener
					{
						private int cr;
						
						public regc(int cr) {
							this.cr = cr;
						}
						
						@Override
						public void actionPerformed(ActionEvent e) {
							try
							{
								boolean have = false;
								for(int i = 0; i < thisstudent.courses.size(); i++) 
								{
									if(thisstudent.courses.get(i).getID().equals(DB.regData.getRegistrationCourses().get(cr).getID()) && thisstudent.courses.get(i).getName().equals(DB.regData.getRegistrationCourses().get(cr).getName()) && thisstudent.courses.get(i).getCredits() == DB.regData.getRegistrationCourses().get(cr).getCredits())
									{
										have = true;
										break;
									}
								}
								if(!have) 
								{
									Mark m = new Mark();
									m.student = thisstudent;
									DB.regData.getRegistrationCourses().get(cr).studentmarks.add(m);
									thisstudent.courses.add(DB.regData.getRegistrationCourses().get(cr));
									DB.WriteLog("Student " + thisstudent.getName() + " registered for course: " + DB.regData.Courses.get(cr).getName());
								}
								else
									JOptionPane.showMessageDialog(null, "You Have already registered to this course","Warning",JOptionPane.PLAIN_MESSAGE);
							}
							catch(Exception ex)
							{
								JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.PLAIN_MESSAGE);
							}
							
							register.this.dispose();
							DB.Serialize();
						}
					}
				}
				
				class view implements ActionListener
				{
					private Course scourse;
					
					public view(int i) {
						scourse = thisstudent.courses.get(i);
					}
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String message = "ERROR: ";
						try
						{
							message = scourse.toString();
							message += "\nFiles: " + scourse.courseFiles;
							message += "\n" + scourse.schedule.toString();

							for(int i = 0; i < scourse.studentmarks.size(); i++)
							{
								if(scourse.studentmarks.get(i).student.equals(thisstudent))
								{
									message += "\nMarks: " + scourse.studentmarks.get(i).toString();
									break;
								}
							}
						}
						catch(Exception ex)
						{
							message += ex.getMessage();
						}
						JOptionPane.showMessageDialog(null, message,"INFO",JOptionPane.PLAIN_MESSAGE);
						ICourses.this.dispose();
					}
					
				}
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////
			class setUserName extends JFrame implements ActionListener
			{
				private static final long serialVersionUID = 1L;
				private JLabel username;
				private JTextField tusername;
				private JButton change;
				
				public setUserName() {
					super("Set User Name:");
				}
				
				@Override
				public void actionPerformed(ActionEvent e) {
					this.setBounds(100,100,400,400);
					this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					username = new JLabel("New User Name to Change:");
					tusername = new JTextField("",5);
					change = new JButton("Change");
					Container container = new Container();
					container.setLayout(new GridLayout(14,14,4,4));
					container.add(username);
					container.add(tusername);
					change.addActionListener(new Change());
					container.add(change);
					this.setContentPane(container);
					this.setVisible(true);
				}
				
				class Change implements ActionListener
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						String message = "Cannot Change!";
						if(thisstudent.setUserName(tusername.getText())) 
						{
							message = "Succesfull!";
						}
						JOptionPane.showMessageDialog(null, message,"Changing",JOptionPane.PLAIN_MESSAGE);
						setUserName.this.dispose();
						DB.Serialize();
					}
				}
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////
			class setPassword extends JFrame implements ActionListener
			{
				private static final long serialVersionUID = 1L;
				private JLabel password;
				private JTextField tpassword;
				private JButton change;
				
				public setPassword() {
					super("Set User Name:");
				}
				
				@Override
				public void actionPerformed(ActionEvent e) {
					this.setBounds(100,100,400,400);
					this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					password = new JLabel("New User Password to Change:");
					tpassword = new JTextField("",5);
					change = new JButton("Change");
					Container container = new Container();
					container.setLayout(new GridLayout(14,14,4,4));
					container.add(password);
					container.add(tpassword);
					change.addActionListener(new Change());
					container.add(change);
					this.setContentPane(container);
					this.setVisible(true);
				}
				
				class Change implements ActionListener
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						String message = "Cannot Change!";
						if(thisstudent.setUserPassword(tpassword.getText())) 
						{
							message = "Succesfull!";
						}
						JOptionPane.showMessageDialog(null, message,"Changing",JOptionPane.PLAIN_MESSAGE);
						setPassword.this.dispose();
						DB.Serialize();
					}
				}
			}
		}
//////////---------------------------------#TeacherIntranet#-------------------------------------//
		class TeacherIntranet extends JFrame
		{
			private static final long serialVersionUID = 1L;
			private Teacher thisteacher;
			private JButton information = new JButton("Information");
			private JButton icourses = new JButton("Courses");
			private JButton sendmessage = new JButton("Send Message to TechSupportGuy");
			private JButton setUserName = new JButton("Set User Name");
			private JButton setPassword = new JButton("Set Password");
			
			public TeacherIntranet(Teacher t) {
				super(t.getName());
				thisteacher = t;
				this.setBounds(100,100,400,400);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Container container = new Container();
				container.setLayout(new GridLayout(14,14,4,4));
				information.addActionListener(new Information());
				icourses.addActionListener(new ICourses());
				sendmessage.addActionListener(new sendMessage());
				setPassword.addActionListener(new setPassword());
				setUserName.addActionListener(new setUserName());
				container.add(information);
				container.add(icourses);
				container.add(sendmessage);
				container.add(setPassword);
				container.add(setUserName);
				this.setContentPane(container);
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////
			class sendMessage extends JFrame implements ActionListener
			{
				private static final long serialVersionUID = 1L;
				private JTextField mess;
				private JButton smess;
				
				public sendMessage() {
					super("Message:");
				}
				
				@Override
				public void actionPerformed(ActionEvent e) {
					this.setBounds(100,100,400,400);
					this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					mess = new JTextField("",5);
					smess = new JButton("Send Message");
					Container container = new Container();
					container.setLayout(new GridLayout(14,14,4,4));
					container.add(mess);
					smess.addActionListener(new send());
					container.add(smess);
					this.setContentPane(container);
					this.setVisible(true);
				}
				
				class send implements ActionListener
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						try
						{
							for(int i = 0; i < DB.users.size(); i++) {
								if(DB.users.get(i) instanceof TechSupportGuy)
								{
									((TechSupportGuy) DB.users.get(i)).addMessage( " \"" + mess.getText() + "\" " + ": from Teacher: " + thisteacher.getName());
									DB.WriteLog("Teacher: " + thisteacher.getName() + " sent message to TechGuys");
									DB.Serialize();
								}
							}
						}
						catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null, ex.getLocalizedMessage(),"Warning!",JOptionPane.PLAIN_MESSAGE);
						}
						sendMessage.this.dispose();
					}
				}
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////
			class Information implements ActionListener
			{
				@Override
				public void actionPerformed(ActionEvent e) {
					String message = thisteacher.toString();
					JOptionPane.showMessageDialog(null, message,"INFORMATION",JOptionPane.PLAIN_MESSAGE);
				}
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////
			class setUserName extends JFrame implements ActionListener
			{
				private static final long serialVersionUID = 1L;
				private JLabel username;
				private JTextField tusername;
				private JButton change;
				
				public setUserName() {
					super("Set User Name:");
				}
				
				@Override
				public void actionPerformed(ActionEvent e) {
					this.setBounds(100,100,400,400);
					this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					username = new JLabel("New User Name to Change:");
					tusername = new JTextField("",5);
					change = new JButton("Change");
					Container container = new Container();
					container.setLayout(new GridLayout(14,14,4,4));
					container.add(username);
					container.add(tusername);
					change.addActionListener(new Change());
					container.add(change);
					this.setContentPane(container);
					this.setVisible(true);
				}
				
				class Change implements ActionListener
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						String message = "Cannot Change!";
						if(thisteacher.setUserName(tusername.getText())) 
						{
							message = "Succesfull!";
						}
						JOptionPane.showMessageDialog(null, message,"Changing",JOptionPane.PLAIN_MESSAGE);
						setUserName.this.dispose();
						DB.Serialize();
					}
				}
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////
			class setPassword extends JFrame implements ActionListener
			{
				private static final long serialVersionUID = 1L;
				private JLabel password;
				private JTextField tpassword;
				private JButton change;
				
				public setPassword() {
					super("Set User Name:");
				}
				
				@Override
				public void actionPerformed(ActionEvent e) {
					this.setBounds(100,100,400,400);
					this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					password = new JLabel("New User Password to Change:");
					tpassword = new JTextField("",5);
					change = new JButton("Change");
					Container container = new Container();
					container.setLayout(new GridLayout(14,14,4,4));
					container.add(password);
					container.add(tpassword);
					change.addActionListener(new Change());
					container.add(change);
					this.setContentPane(container);
					this.setVisible(true);
				}
				
				class Change implements ActionListener
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						String message = "Cannot Change!";
						if(thisteacher.setUserPassword(tpassword.getText())) 
						{
							message = "Succesfull!";
						}
						JOptionPane.showMessageDialog(null, message,"Changing",JOptionPane.PLAIN_MESSAGE);
						setPassword.this.dispose();
						DB.Serialize();
					}
				}
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////
			class ICourses extends JFrame implements ActionListener
			{
				private JLabel infocourse;
				private JLabel infocoursestudents;
				private JButton addCourse;
				private JButton mcourse[];
				private JButton mstudent[];
				private static final long serialVersionUID = 1L;
				
				public ICourses() {
					super("Information about Courses");
				}
				
				@Override
				public void actionPerformed(ActionEvent e) {
					this.setBounds(100,100,400,600);
					this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					addCourse = new JButton("Add New Course");
					Container container = new Container();
					container.setLayout(new GridLayout(28,1));
					addCourse.addActionListener(new AddCourse());
					mcourse = new JButton[thisteacher.courses.size()];
					mstudent = new JButton[thisteacher.courses.size()];
					for(int index = 0; index < thisteacher.courses.size(); index++)
					{
						ButtonGroup group = new ButtonGroup();
						mstudent[index] = new JButton("Students");
						mcourse[index] = new JButton("Manage");
						group.add(mstudent[index]);
						group.add(mcourse[index]);
						infocourse = new JLabel(thisteacher.courses.get(index).toString());
						container.add(infocourse);
						for(int jndex = 0; jndex < DB.users.size();jndex++) {
							if(DB.users.get(jndex) instanceof Student)
							{
								for(int c = 0; c < ((Student) DB.users.get(jndex)).courses.size(); c++) {
									if(DB.courses.get(index).getID().equals(((Student) DB.users.get(jndex)).courses.get(c).getID())) {
										
										infocoursestudents = new JLabel("* " + ((Student) DB.users.get(jndex)).getName() + "  " + ((Student) DB.users.get(jndex)).getID() + "  " + ((Student) DB.users.get(jndex)).getSpecialty());
										container.add(infocoursestudents);
										break;
									}
								}
							}
						}
						mcourse[index].addActionListener(new ManageCourse(thisteacher.courses.get(index)));
						mstudent[index].addActionListener(new ManageStudent(thisteacher.courses.get(index)));
						container.add(mstudent[index]);
						container.add(mcourse[index]);
					}
					container.add(addCourse);
					this.setContentPane(container);
					this.setVisible(true);
				}

				class ManageStudent extends JFrame implements ActionListener
				{
					private static final long serialVersionUID = 1L;
					private Course thisCourse;
					private JLabel infos[];
					private JButton buttons[];
					private JButton returning;
					private Vector<Student> students;
					
					public ManageStudent(Course c) {
						super("Students");
						thisCourse = c;
					}
					
					@Override
					public void actionPerformed(ActionEvent e) {
						this.setBounds(100,100,600,600);
						this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						students = new Vector<Student>();
						returning = new JButton("Return");
						Container container = new Container();
						container.setLayout(new GridLayout(28,1));
						for(int i = 0; i < DB.users.size(); i++)
						{
							if(DB.users.get(i) instanceof Student)
							{
								for(int j = 0; j < ((Student) DB.users.get(i)).courses.size(); j++)
								{
									if(((Student) DB.users.get(i)).courses.get(j).getID().equals(thisCourse.getID()))
									{
										students.add(((Student) DB.users.get(i)));
									}
								}
							}
						}
						infos = new JLabel[students.size()];
						buttons = new JButton[students.size()];
						for(int i = 0; i < students.size(); i++) {
							infos[i] = new JLabel(students.get(i).toString());
							buttons[i] = new JButton("Marks");
							buttons[i].addActionListener(new Marks(students.get(i)));
							container.add(infos[i]);
							container.add(buttons[i]);	
						}
						returning.addActionListener(new Return());
						container.add(returning);
						this.setContentPane(container);
						this.setVisible(true);
					}
					
					class Marks extends JFrame implements ActionListener
					{
						private static final long serialVersionUID = 1L;
						private JLabel markstudent;
						private JButton addmark;
						private JButton returning;
						private Student thisstudent;
						
						public Marks(Student s) {
							super(s.getName());
							thisstudent = s;
						}
						
						@Override
						public void actionPerformed(ActionEvent e) {
							this.setBounds(100,100,256,128);
							this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							addmark = new JButton("Add Mark");
							returning = new JButton("Return");
							Container container = new Container();
							container.setLayout(new GridLayout(3,1));
							for(int i = 0; i < thisstudent.courses.size(); i++) {
								if(thisCourse.getID().equals(thisstudent.courses.get(i).getID()))
								{
									for(int j = 0; j < thisstudent.courses.get(i).studentmarks.size(); j++) 
									{
										if(thisstudent.courses.get(i).studentmarks.get(j).student.getID().equals(thisstudent.getID()))
										{
											markstudent = new JLabel(thisstudent.courses.get(i).studentmarks.get(j).toString());
											addmark.addActionListener(new AddMark(thisstudent.courses.get(i).studentmarks.get(j)));
											break;
										}
									}
								}
							}
							returning.addActionListener(new Returnit());
							container.add(markstudent);
							container.add(addmark);
							container.add(returning);
							this.setContentPane(container);
							this.setVisible(true);
						}
						
						class Returnit implements ActionListener
						{
							@Override
							public void actionPerformed(ActionEvent e) {
								ManageStudent.this.dispose();
								Marks.this.dispose();
							}
							
						}
						
						class AddMark extends JFrame implements ActionListener
						{
							private static final long serialVersionUID = 1L;
							private JTextField inmark;
							private JButton binmark;
							private Mark thismark;
							
							public AddMark(Mark m) {
								thismark = m;
							}

							@Override
							public void actionPerformed(ActionEvent e) {
								this.setBounds(100,100,128,128);
								this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
								inmark = new JTextField("",5);
								binmark = new JButton("Add");
								Container container = new Container();
								container.setLayout(new GridLayout(2,1));
								container.add(inmark);
								binmark.addActionListener(new Add());
								container.add(binmark);
								this.setContentPane(container);
								this.setVisible(true);
							}
														
							class Add implements ActionListener
							{
								@Override
								public void actionPerformed(ActionEvent e) {
									try
									{
										thismark.marks.add(Integer.parseInt(inmark.getText()));
										DB.WriteLog("Teacher: " + thisteacher.getName() + " added mark for Course: " + thisCourse.getName() + "  to Student" + thismark.student.getName() + " : " + inmark.getText());
									}
									catch(Exception ex)
									{
										JOptionPane.showMessageDialog(null, ex.getMessage(),"Error!",JOptionPane.PLAIN_MESSAGE);
									}
									AddMark.this.dispose();
									Marks.this.dispose();
									DB.Serialize();
								}
							}
						}
					}
					
					class Return implements ActionListener
					{
						@Override
						public void actionPerformed(ActionEvent e) {
							ManageStudent.this.dispose();
							students.removeAllElements();
						}
						
					}
				}

				class ManageCourse extends JFrame implements ActionListener
				{
					private static final long serialVersionUID = 1L;
					private Course thisCourse;
					private JLabel info;
					private JLabel files;
					private JButton addfiles;
					private JButton removefiles;
					
					public ManageCourse(Course c) {
						super(c.getName());
						thisCourse = c;
					}
					
					@Override
					public void actionPerformed(ActionEvent e) {
						this.setBounds(100,100,400,400);
						this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						addfiles = new JButton("Add Files");
						removefiles = new JButton("Remove Files");
						ICourses.this.dispose();
						Container container = new Container();
						container.setLayout(new GridLayout(16,1,1,1));
						info = new JLabel(thisCourse.toString());
						files = new JLabel("Files: " + thisCourse.courseFiles.toString());
						container.add(info);
						container.add(files);
						addfiles.addActionListener(new AddFiles());
						removefiles.addActionListener(new RemoveFiles());
						container.add(addfiles);
						container.add(removefiles);
						this.setContentPane(container);
						this.setVisible(true);
					}
					
					class AddFiles extends JFrame implements ActionListener
					{
						private static final long serialVersionUID = 1L;
						private JLabel name;
						private JTextField tname;
						private JLabel fpath;
						private JTextField tfpath;
						private JButton addfile;
						
						public AddFiles() {
							super("New File");
						}
						
						@Override
						public void actionPerformed(ActionEvent e) {
							this.setBounds(100,100,400,400);
							this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							name = new JLabel("Name of the File");
							tname = new JTextField("",5);
							fpath = new JLabel("Path for File");
							tfpath = new JTextField("",5);
							addfile = new JButton("Add a File");
							ManageCourse.this.dispose();
							Container container = new Container();
							container.setLayout(new GridLayout(16,1,1,1));
							container.add(name);
							container.add(tname);
							container.add(fpath);
							container.add(tfpath);
							addfile.addActionListener(new adf());
							container.add(addfile);
							this.setContentPane(container);
							this.setVisible(true);
						}
						
						class adf implements ActionListener
						{
							@Override
							public void actionPerformed(ActionEvent e) {
								try
								{
									File file = new File(tfpath.getText());
									CourseFile c = new CourseFile();
									c.setFile(file);
									c.setName(tname.getText());
									for(int i = 0; i < thisteacher.courses.size();i++) {
										if(thisteacher.courses.get(i).equals(thisCourse)) {
											thisteacher.courses.get(i).courseFiles.add(c);
											for(int j = 0; j < DB.users.size(); j++) 
											{
												if(DB.users.get(j) instanceof Student)
												{
													for(int k = 0; k < ((Student)DB.users.get(j)).courses.size(); k++)
													{
														if(((Student)DB.users.get(j)).courses.get(k).getID().equals(thisCourse.getID()) && ((Student)DB.users.get(j)).courses.get(k).getName().equals(thisCourse.getName()))
														{
															((Student)DB.users.get(j)).courses.get(k).courseFiles.add(c);
														}
													}
												}
											}
											DB.WriteLog("Teacher: " + thisteacher.getName() + " Added a New File " + tname.getText() + " for a course -> " + thisCourse.getName());
											break;
										}
									}
								}
								catch(Exception ex)
								{
									JOptionPane.showMessageDialog(null, ex.getMessage(),"Warning!",JOptionPane.PLAIN_MESSAGE);
								}
								DB.Serialize();
								AddFiles.this.dispose();
							}
						}
					}
					class RemoveFiles extends JFrame implements ActionListener
					{
						private static final long serialVersionUID = 1L;
						private JLabel labels[];
						private JButton buttons[];
						
						public RemoveFiles() {
							super("Remove files");
						}
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(thisCourse.courseFiles.size() > 0)
							{
								this.setBounds(100,100,400,400);
								this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
								ManageCourse.this.dispose();
								Container container = new Container();
								container.setLayout(new GridLayout(16,1,1,1));
								labels = new JLabel[thisCourse.courseFiles.size()];
								buttons = new JButton[thisCourse.courseFiles.size()];
								for(int index = 0; index < thisCourse.courseFiles.size(); index++)
								{
									labels[index] = new JLabel(thisCourse.courseFiles.get(index).toString());
									buttons[index] = new JButton("Remove");
									buttons[index].addActionListener(new remove(index));
									container.add(labels[index]);
									container.add(buttons[index]);
								}
								this.setContentPane(container);
								this.setVisible(true);
							}
							else
								this.dispose();
						}
						
						class remove implements ActionListener
						{
							private int indexof;
							
							public remove(int i) {
								indexof = i;
							}
							
							@Override
							public void actionPerformed(ActionEvent e) {
								String message = "Error: ";
								try 
								{
									DB.WriteLog("Teacher: " + thisteacher.getName() + " Removed File " + thisCourse.courseFiles.get(indexof).getName() + " from course -> " + thisCourse.getName());
									thisCourse.courseFiles.remove(indexof);
									for(int j = 0; j < DB.users.size(); j++) 
									{
										if(DB.users.get(j) instanceof Student)
										{
											for(int k = 0; k < ((Student)DB.users.get(j)).courses.size(); k++)
											{
												if(((Student)DB.users.get(j)).courses.get(k).getID().equals(thisCourse.getID()) && ((Student)DB.users.get(j)).courses.get(k).getName().equals(thisCourse.getName()))
												{
													((Student)DB.users.get(j)).courses.get(k).courseFiles.remove(indexof);
												}
											}
										}
									}
									message = "Succesfull";
								}
								catch(Exception ex) 
								{
									message += ex.getMessage();
								}
								JOptionPane.showMessageDialog(null, message,"Removing",JOptionPane.PLAIN_MESSAGE);
								RemoveFiles.this.dispose();
								DB.Serialize();
							}
						}
					}
				}

				class AddCourse extends JFrame implements ActionListener
				{
					private static final long serialVersionUID = 1L;
					private JLabel lcname;
					private JTextField cname;
					private JLabel lcid;
					private JTextField cid;
					private JLabel sch;
					private JButton addc;
					private JCheckBox checks1[];
					private JCheckBox checks2[];
					
					public AddCourse() {
						super("New Course");
					}
					
					@Override
					public void actionPerformed(ActionEvent e) {
						this.setBounds(100,100,400,400);
						this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						lcname = new JLabel("Name of Course");
						cname = new JTextField("",5);
						lcid = new JLabel("ID of Course");
						cid = new JTextField("",5);
						sch = new JLabel(" ");
						addc = new JButton("Add New Course");
						ICourses.this.dispose();
						Container container = new Container();
						container.setLayout(new GridLayout(14,10));
						checks1 = new JCheckBox[7];
						checks2 = new JCheckBox[12];
						checks1[0] = new JCheckBox("Monday",false);
						checks1[1] = new JCheckBox("Tuesday",false);
						checks1[2] = new JCheckBox("Wednesday",false);
						checks1[3] = new JCheckBox("Thursday",false);
						checks1[4] = new JCheckBox("Friday",false);
						checks1[5] = new JCheckBox("Saturday",false);
						checks1[6] = new JCheckBox("Sunday",false);
						checks2[0] = new JCheckBox("8:00-9:00",false);
						checks2[1] = new JCheckBox("9:00-10:00",false);
						checks2[2] = new JCheckBox("10:00-11:00",false);
						checks2[3] = new JCheckBox("11:00-12:00",false);
						checks2[4] = new JCheckBox("12:00-13:00",false);
						checks2[5] = new JCheckBox("13:00-14:00",false);
						checks2[6] = new JCheckBox("14:00-15:00",false);
						checks2[7] = new JCheckBox("15:00-16:00",false);
						checks2[8] = new JCheckBox("16:00-17:00",false);
						checks2[9] = new JCheckBox("17:00-18:00",false);
						checks2[10] = new JCheckBox("18:00-19:00",false);
						checks2[11] = new JCheckBox("19:00-20:00",false);
						container.add(lcname);
						container.add(cname);
						container.add(lcid);
						container.add(cid);
						for(int i = 0; i < 7; i++) 
							container.add(checks1[i]);
						container.add(sch);
						for(int i = 0; i < 12; i++) 
							container.add(checks2[i]);
						addc.addActionListener(new AddNewCourse());
						container.add(addc);
						this.setContentPane(container);
						this.setVisible(true);
					}
					
					class AddNewCourse implements ActionListener
					{
						@Override
						public void actionPerformed(ActionEvent e) {
							Schedule sched = new Schedule();
							for(int i = 0; i < 7; i++) {
								for(int j = 0; j < 12; j++) {
									if(checks1[i].isSelected() && checks2[j].isSelected())
										sched.setDay(i, j);
								}
							}
							
							try 
							{
								boolean alreadyhave = false;
								
								for(int i = 0; i < thisteacher.courses.size(); i++)
								{
									if(thisteacher.courses.get(i).getName().equals(cname.getText()) && thisteacher.courses.get(i).getID().equals(cid.getText()))
									{
										alreadyhave = true;
										break;
									}
								}
								if(!alreadyhave)
								{
									if(sched.timeCount() < 5 && sched.timeCount() > 0) 
									{
										Course c = new Course(cname.getText(), cid.getText(), sched);
										DB.courses.add(c);
										thisteacher.courses.add(c);
										DB.WriteLog("Teacher: " + thisteacher.getName() + " Added a New Course : " + cname.getText());
									}
									else
										JOptionPane.showMessageDialog(null, "Wrong time count(Min 1h : Max 4h)","Warning!",JOptionPane.PLAIN_MESSAGE);
								}
								else
									JOptionPane.showMessageDialog(null, "The same Course already added","Warning!",JOptionPane.PLAIN_MESSAGE);
							}
							catch(Exception ex)
							{
								JOptionPane.showMessageDialog(null, ex.getMessage(),"Warning!",JOptionPane.PLAIN_MESSAGE);
							}
							AddCourse.this.dispose();
							DB.Serialize();
						}
					}
				}
			}
		}
//////////---------------------------------#AdminIntranet#-------------------------------------//
		class AdminIntranet extends JFrame
		{
			private static final long serialVersionUID = 1L;
			private Admin thisadmin;
			private JButton information = new JButton("Information");
			private JButton addUser = new JButton("Add User");
			private JButton removeUser = new JButton("Remove User");
			private JButton seelog = new JButton("See Log");
			private JButton updateinfo = new JButton("Update User Information");
			private JButton setPassword = new JButton("Set Password");
			private JButton setUserName = new JButton("Set User Name");
			
			
			public AdminIntranet(Admin a) {
				super(a.getName());
				thisadmin = a;
				this.setBounds(100,100,400,400);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Container container = new Container();
				container.setLayout(new GridLayout(14,14,4,4));
				information.addActionListener(new Information());
				addUser.addActionListener(new AddUser());
				removeUser.addActionListener(new removeUser());
				seelog.addActionListener(new ViewLog());
				setPassword.addActionListener(new setPassword());
				setUserName.addActionListener(new setUserName());
				updateinfo.addActionListener(new UpdateInfo());
				container.add(information);
				container.add(addUser);
				container.add(removeUser);
				container.add(seelog);
				container.add(updateinfo);
				container.add(setPassword);
				container.add(setUserName);
				this.setContentPane(container);
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////
			class UpdateInfo extends JFrame implements ActionListener
			{
				private static final long serialVersionUID = 1L;
				private JTextField search;
				private JRadioButton r1;
				private JRadioButton r2;
				private JRadioButton r3;
				private JRadioButton r4;
				private JRadioButton r5;
				private JButton bb;
				
				public UpdateInfo() {
					super("Update User");
				}
				
				@Override
				public void actionPerformed(ActionEvent e) {
					this.setBounds(100,100,400,400);
					this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					search = new JTextField("ID@",5);
					r1 = new JRadioButton("Admin");
					r2 = new JRadioButton("Teacher");
					r3 = new JRadioButton("Manager");
					r4 = new JRadioButton("Student");
					r5 = new JRadioButton("TechSupportGuy");
					bb = new JButton("Search");
					Container container = new Container();
					container.setLayout(new GridLayout(14,14,4,4));
					ButtonGroup g = new ButtonGroup();
					g.add(r1);
					r1.setSelected(true);
					g.add(r2);
					g.add(r3);
					g.add(r4);
					g.add(r5);
					container.add(search);
					container.add(r1);
					container.add(r2);
					container.add(r3);
					container.add(r4);
					container.add(r5);
					bb.addActionListener(new update());
					container.add(bb);
					this.setContentPane(container);
					this.setVisible(true);
				}
				
				class update extends JFrame implements ActionListener
				{
					private static final long serialVersionUID = 1L;
					private JButton updateuser;
					private JLabel uname;
					private JTextField tuname;
					private JLabel udep;
					private JTextField tudep;
					private JLabel usal;
					private JTextField tusal;
					private JLabel unum;
					private JTextField tunum;
					private JLabel uspec;
					private JTextField tuspec;
					private User u;
					
					public update() {
						super("Update");
						u = null;
					}
					
					@Override
					public void actionPerformed(ActionEvent e) {
						updateuser = new JButton("Update");
						uname = new JLabel("New User Name: ");
						udep = new JLabel("New User Department: ");
						usal = new JLabel("New User Salary: ");
						unum = new JLabel("New User PhoneNumber: ");
						uspec = new JLabel("New User Specialty: ");
						for(int i = 0; i < DB.users.size(); i++)
						{
							if(r1.isSelected() && DB.users.get(i) instanceof Admin)
							{
								if(((Admin) DB.users.get(i)).getID().equals(search.getText()))
								{
									u = ((Admin) DB.users.get(i));
									break;
								}
							}
							if(r2.isSelected() && DB.users.get(i) instanceof Teacher)
							{
								if(((Teacher) DB.users.get(i)).getID().equals(search.getText()))
								{
									u = ((Teacher) DB.users.get(i));
									break;
								}
							}
							if(r3.isSelected() && DB.users.get(i) instanceof Manager)
							{
								if(((Manager) DB.users.get(i)).getID().equals(search.getText()))
								{
									u = ((Manager) DB.users.get(i));
									break;
								}
							}
							if(r4.isSelected() && DB.users.get(i) instanceof Student)
							{
								if(((Student) DB.users.get(i)).getID().equals(search.getText()))
								{
									u = ((Student) DB.users.get(i));
									break;
								}
							}
							if(r5.isSelected() && DB.users.get(i) instanceof TechSupportGuy)
							{
								if(((TechSupportGuy) DB.users.get(i)).getID().equals(search.getText()))
								{
									u = ((TechSupportGuy) DB.users.get(i));
									break;
								}
							}
						}
						if(u != null)
						{
							this.setBounds(100,100,400,400);
							this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							UpdateInfo.this.dispose();
							Container container = new Container();
							container.setLayout(new GridLayout(14,14,4,4));
							if(r1.isSelected())
							{
								tuname = new JTextField(((Admin) u).getName());
								tudep = new JTextField(((Admin) u).getDepartment());
								tusal = new JTextField(((Admin) u).getSalary() + "");
								container.add(uname);
								container.add(tuname);
								container.add(udep);
								container.add(tudep);
								container.add(usal);
								container.add(tusal);
							}
							if(r2.isSelected())
							{
								tuname = new JTextField(((Teacher) u).getName());
								tudep = new JTextField(((Teacher) u).getDepartment());
								tusal = new JTextField(((Teacher) u).getSalary() + "");
								container.add(uname);
								container.add(tuname);
								container.add(udep);
								container.add(tudep);
								container.add(usal);
								container.add(tusal);
							}
							if(r3.isSelected())
							{
								tuname = new JTextField(((Manager) u).getName());
								tudep = new JTextField(((Manager) u).getDepartment());
								tusal = new JTextField(((Manager) u).getSalary() + "");
								tunum = new JTextField(((Manager) u).getPhoneNumber() + "");
								container.add(uname);
								container.add(tuname);
								container.add(udep);
								container.add(tudep);
								container.add(usal);
								container.add(tusal);
								container.add(unum);
								container.add(tunum);
							}
							if(r4.isSelected())
							{
								tuname = new JTextField(((Student) u).getName());
								tuspec = new JTextField(((Student) u).getSpecialty());
								container.add(uname);
								container.add(tuname);
								container.add(uspec);
								container.add(tuspec);
							}
							if(r5.isSelected())
							{
								tuname = new JTextField(((TechSupportGuy) u).getName());
								tudep = new JTextField(((TechSupportGuy) u).getDepartment());
								tusal = new JTextField(((TechSupportGuy) u).getSalary() + "");
								container.add(uname);
								container.add(tuname);
								container.add(udep);
								container.add(tudep);
								container.add(usal);
								container.add(tusal);
							}
							updateuser.addActionListener(new upd());
							container.add(updateuser);
							this.setContentPane(container);
							this.setVisible(true);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "User Not Found");
							UpdateInfo.this.dispose();
							this.dispose();
						}
					}
					
					class upd implements ActionListener
					{
						@Override
						public void actionPerformed(ActionEvent e) {
							try
							{
								if(r1.isSelected())
								{
									((Admin) u).setName(tuname.getText());
									((Admin) u).setDepartment(tudep.getText());
									((Admin) u).setSalary(Float.parseFloat(tusal.getText()));
								}
								if(r2.isSelected())
								{
									((Teacher) u).setName(tuname.getText());
									((Teacher) u).setDepartment(tudep.getText());
									((Teacher) u).setSalary(Float.parseFloat(tusal.getText()));
								}
								if(r3.isSelected())
								{
									((Manager) u).setName(tuname.getText());
									((Manager) u).setDepartment(tudep.getText());
									((Manager) u).setSalary(Float.parseFloat(tusal.getText()));
									((Manager) u).setPhoneNumber(Integer.parseInt(tunum.getText()));
								}
								if(r4.isSelected())
								{
									((Student) u).setName(tuname.getText());
									((Student) u).setSpecialty(tuspec.getText());
								}
								if(r5.isSelected())
								{
									((TechSupportGuy) u).setName(tuname.getText());
									((TechSupportGuy) u).setDepartment(tudep.getText());
									((TechSupportGuy) u).setSalary(Float.parseFloat(tusal.getText()));
								}
								UpdateInfo.this.dispose();
								update.this.dispose();
								DB.Serialize();
							}
							catch(Exception ex)
							{
								JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
							}
						}
					}
				}
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////
			class Information implements ActionListener
			{
				@Override
				public void actionPerformed(ActionEvent e) {
					String message = thisadmin.toString();
					JOptionPane.showMessageDialog(null, message,"INFORMATION",JOptionPane.PLAIN_MESSAGE);
				}
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////
			class ViewLog implements ActionListener
			{
				@Override
				public void actionPerformed(ActionEvent e) {
					String message = "";
					try 
					{
						BufferedReader bR = new BufferedReader(new FileReader("log.FileL"));
						String s = bR.readLine();
						while(s != null)
						{
							message += s +"\n";
							s = bR.readLine();
						}
						bR.close();
					} 
					catch (Exception e1) 
					{
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, message,"INFORMATION",JOptionPane.PLAIN_MESSAGE);
				}
				
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////	
			class AddUser extends JFrame implements ActionListener
			{
				private static final long serialVersionUID = 1L;
				private JButton addadmin;
				private JButton addteacher;
				private JButton addmanager;
				private JButton addstudent;
				private JButton addtechsupportguy;
				
				public AddUser() {
					super("Select User");
				}
				
				@Override
				public void actionPerformed(ActionEvent e) {
					this.setBounds(100,100,400,400);
					this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					addadmin = new JButton("New Admin");
					addteacher = new JButton("New Teacher");
					addmanager = new JButton("New Manager");
					addstudent = new JButton("New Student");
					addtechsupportguy = new JButton("New TechSupportGuy");
					Container container = new Container();
					container.setLayout(new GridLayout(14,14,4,4));
					addadmin.addActionListener(new AddAdmin());
					addmanager.addActionListener(new AddManager());
					addstudent.addActionListener(new AddStudent());
					addteacher.addActionListener(new AddTeacher());
					addtechsupportguy.addActionListener(new AddTechSupportGuy());
					container.add(addadmin);
					container.add(addmanager);
					container.add(addstudent);
					container.add(addteacher);
					container.add(addtechsupportguy);
					this.setContentPane(container);
					this.setVisible(true);
				}
///////////////////////////////////////////////////////////////////////////////////////////////////////
				class AddTechSupportGuy extends JFrame implements ActionListener
				{
					private static final long serialVersionUID = 1L;
					private JLabel username;
					private JTextField tusername;
					private JLabel userpassword;
					private JTextField tuserpassword;
					private JLabel name;
					private JTextField tname;
					private JLabel department;
					private JTextField tdepartment;
					private JLabel salary;
					private JTextField tsalary;
					private JButton create;
					
					public AddTechSupportGuy() {
						super("Add New TechSupportGuy");
					}
					
					@Override
					public void actionPerformed(ActionEvent e) {
						AddUser.this.dispose();
						this.setBounds(100,100,400,400);
						this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						username = new JLabel("User Name For Authorize:");
						tusername = new JTextField("",5);
						userpassword = new JLabel("User Password For Authorize::");
						tuserpassword = new JTextField("",5);
						name = new JLabel("Name:");
						tname = new JTextField("",5);
						department = new JLabel("Department:");
						tdepartment = new JTextField("",5);
						salary = new JLabel("Salary:");
						tsalary = new JTextField("",5);
						create = new JButton("Create User");
						Container container = new Container();
						container.setLayout(new GridLayout(14,14,4,4));
						container.add(username);
						container.add(tusername);
						container.add(userpassword);
						container.add(tuserpassword);
						container.add(name);
						container.add(tname);
						container.add(department);
						container.add(tdepartment);
						container.add(salary);
						container.add(tsalary);
						create.addActionListener(new Create());
						container.add(create);
						this.setContentPane(container);
						this.setVisible(true);
					}
					
					class Create implements ActionListener
					{
						@Override
						public void actionPerformed(ActionEvent e) {
							try 
							{
								DB.users.add(new TechSupportGuy(tusername.getText(), tuserpassword.getText(),tname.getText(), tdepartment.getText(),Float.parseFloat(tsalary.getText())));
								DB.WriteLog("Admin: " + thisadmin.getName() + " Added a New TechSupportGuy : " + tname.getText());
							}
							catch(Exception ex)
							{
								JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR!",JOptionPane.PLAIN_MESSAGE);
							}
							AddTechSupportGuy.this.dispose();						
							DB.Serialize();
						}
					}
				}
///////////////////////////////////////////////////////////////////////////////////////////////////////
				class AddAdmin extends JFrame implements ActionListener
				{
					private static final long serialVersionUID = 1L;
					private JLabel username;
					private JTextField tusername;
					private JLabel userpassword;
					private JTextField tuserpassword;
					private JLabel name;
					private JTextField tname;
					private JLabel department;
					private JTextField tdepartment;
					private JLabel salary;
					private JTextField tsalary;
					private JButton create;
					
					public AddAdmin() {
						super("Add New Admin");
					}
					
					@Override
					public void actionPerformed(ActionEvent e) {
						AddUser.this.dispose();
						this.setBounds(100,100,400,400);
						this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						username = new JLabel("User Name For Authorize:");
						tusername = new JTextField("",5);
						userpassword = new JLabel("User Password For Authorize::");
						tuserpassword = new JTextField("",5);
						name = new JLabel("Name:");
						tname = new JTextField("",5);
						department = new JLabel("Department:");
						tdepartment = new JTextField("",5);
						salary = new JLabel("Salary:");
						tsalary = new JTextField("",5);
						create = new JButton("Create User");
						Container container = new Container();
						container.setLayout(new GridLayout(14,14,4,4));
						container.add(username);
						container.add(tusername);
						container.add(userpassword);
						container.add(tuserpassword);
						container.add(name);
						container.add(tname);
						container.add(department);
						container.add(tdepartment);
						container.add(salary);
						container.add(tsalary);
						create.addActionListener(new Create());
						container.add(create);
						this.setContentPane(container);
						this.setVisible(true);
					}
					
					class Create implements ActionListener
					{
						@Override
						public void actionPerformed(ActionEvent e) {
							try 
							{
								DB.users.add(new Admin(tusername.getText(), tuserpassword.getText(),tname.getText(), tdepartment.getText(),Float.parseFloat(tsalary.getText())));
								DB.WriteLog("Admin: " + thisadmin.getName() + " Added a New Admin : " + tname.getText());
							}
							catch(Exception ex)
							{
								JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR!",JOptionPane.PLAIN_MESSAGE);
							}
							AddAdmin.this.dispose();
							DB.Serialize();
						}
					}
				}
///////////////////////////////////////////////////////////////////////////////////////////////////////
				class AddTeacher extends JFrame implements ActionListener
				{
					private static final long serialVersionUID = 1L;
					private JLabel username;
					private JTextField tusername;
					private JLabel userpassword;
					private JTextField tuserpassword;
					private JLabel name;
					private JTextField tname;
					private JLabel department;
					private JTextField tdepartment;
					private JLabel salary;
					private JTextField tsalary;
					private JButton create;
					private JRadioButton radio1;
					private JRadioButton radio2;
					private JRadioButton radio3;
					private JRadioButton radio4;
					
					public AddTeacher() {
						super("Add New Teacher");
					}
					
					@Override
					public void actionPerformed(ActionEvent e) {
						AddUser.this.dispose();
						this.setBounds(100,100,400,400);
						this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						username = new JLabel("User Name For Authorize:");
						tusername = new JTextField("",5);
						userpassword = new JLabel("User Password For Authorize::");
						tuserpassword = new JTextField("",5);
						name = new JLabel("Name:");
						tname = new JTextField("",5);
						department = new JLabel("Department:");
						tdepartment = new JTextField("",5);
						salary = new JLabel("Salary:");
						tsalary = new JTextField("",5);
						create = new JButton("Create User");
						radio1 = new JRadioButton("Lector");
						radio2 = new JRadioButton("Senior Lector");
						radio3 = new JRadioButton("Professor");
						radio4 = new JRadioButton("Tutor");
						Container container = new Container();
						container.setLayout(new GridLayout(14,14,4,4));
						ButtonGroup group = new ButtonGroup();
						group.add(radio1);
						group.add(radio2);
						group.add(radio3);
						group.add(radio4);
						radio1.setSelected(true);
						container.add(username);
						container.add(tusername);
						container.add(userpassword);
						container.add(tuserpassword);
						container.add(name);
						container.add(tname);
						container.add(department);
						container.add(tdepartment);
						container.add(salary);
						container.add(tsalary);
						container.add(radio1);
						container.add(radio2);
						container.add(radio3);
						container.add(radio4);
						create.addActionListener(new Create());
						container.add(create);
						this.setContentPane(container);
						this.setVisible(true);
					}
					
					class Create implements ActionListener
					{
						@Override
						public void actionPerformed(ActionEvent e) {
							TeachersTitle t = TeachersTitle.LECTOR;
							if(radio2.isSelected())
								t = TeachersTitle.SENIORLECTOR;
							if(radio3.isSelected())
								t = TeachersTitle.PROFESSOR;
							if(radio4.isSelected())
								t = TeachersTitle.TUTOR;
							try 
							{
								DB.users.add(new Teacher(tusername.getText(), tuserpassword.getText(),tname.getText(), t, tdepartment.getText(),Float.parseFloat(tsalary.getText())));
								DB.WriteLog("Admin: " + thisadmin.getName() + " Added a New Teacher : " + tname.getText());
							}
							catch(Exception ex)
							{
								JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR!",JOptionPane.PLAIN_MESSAGE);
							}
							AddTeacher.this.dispose();
							DB.Serialize();
						}
					}
				}
///////////////////////////////////////////////////////////////////////////////////////////////////////
				class AddManager extends JFrame implements ActionListener
				{
					private static final long serialVersionUID = 1L;
					private JLabel username;
					private JTextField tusername;
					private JLabel userpassword;
					private JTextField tuserpassword;
					private JLabel name;
					private JTextField tname;
					private JLabel department;
					private JTextField tdepartment;
					private JLabel salary;
					private JTextField tsalary;
					private JLabel phonenumber;
					private JTextField tphonenumber;
					private JButton create;
					
					public AddManager() {
						super("Add New Manager");
					}
					
					@Override
					public void actionPerformed(ActionEvent e) {
						AddUser.this.dispose();
						this.setBounds(100,100,400,400);
						this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						username = new JLabel("User Name For Authorize:");
						tusername = new JTextField("",5);
						userpassword = new JLabel("User Password For Authorize::");
						tuserpassword = new JTextField("",5);
						name = new JLabel("Name:");
						tname = new JTextField("",5);
						department = new JLabel("Department:");
						tdepartment = new JTextField("",5);
						salary = new JLabel("Salary:");
						tsalary = new JTextField("",5);
						phonenumber = new JLabel("Phone Number:");
						tphonenumber = new JTextField("",5);
						create = new JButton("Create User");
						Container container = new Container();
						container.setLayout(new GridLayout(14,14,4,4));
						container.add(username);
						container.add(tusername);
						container.add(userpassword);
						container.add(tuserpassword);
						container.add(name);
						container.add(tname);
						container.add(department);
						container.add(tdepartment);
						container.add(salary);
						container.add(tsalary);
						container.add(phonenumber);
						container.add(tphonenumber);
						create.addActionListener(new Create());
						container.add(create);
						this.setContentPane(container);
						this.setVisible(true);
					}
					
					class Create implements ActionListener
					{
						@Override
						public void actionPerformed(ActionEvent e) {
							try 
							{
								DB.users.add(new Manager(tusername.getText(), tuserpassword.getText(),tname.getText(), tdepartment.getText(),Float.parseFloat(tsalary.getText()), Integer.parseInt(tphonenumber.getText())));
								DB.WriteLog("Admin: " + thisadmin.getName() + " Added a New Manager : " + tname.getText());
							}
							catch(Exception ex)
							{
								JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR!",JOptionPane.PLAIN_MESSAGE);
							}
							AddManager.this.dispose();
							DB.Serialize();
						}
					}
				}
///////////////////////////////////////////////////////////////////////////////////////////////////////
				class AddStudent extends JFrame implements ActionListener
				{
					private static final long serialVersionUID = 1L;
					private JLabel username;
					private JTextField tusername;
					private JLabel userpassword;
					private JTextField tuserpassword;
					private JLabel name;
					private JTextField tname;
					private JLabel specilty;
					private JTextField tspecilty;
					private JButton create;
					private JRadioButton radio1;
					private JRadioButton radio2;
					private JRadioButton radio3;
					private JRadioButton radio4;
					private JRadioButton radio5;
					private JRadioButton radio6;
					private JRadioButton radio7;
					private JRadioButton radio8;
					private JRadioButton radio9;
					private JRadioButton radio10;
					
					public AddStudent() {
						super("Add New Student");
					}
					
					@Override
					public void actionPerformed(ActionEvent e) {
						AddUser.this.dispose();
						this.setBounds(100,100,400,400);
						this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						username = new JLabel("User Name For Authorize:");
						tusername = new JTextField("",5);
						userpassword = new JLabel("User Password For Authorize::");
						tuserpassword = new JTextField("",5);
						name = new JLabel("Name:");
						tname = new JTextField("",5);
						specilty = new JLabel("Specilty:");
						tspecilty = new JTextField("",5);
						create = new JButton("Create User");
						radio1 = new JRadioButton("FIT");
						radio2 = new JRadioButton("BS");
						radio3 = new JRadioButton("FGGE");
						radio4 = new JRadioButton("FEOGI");
						radio5 = new JRadioButton("FGE");
						radio6 = new JRadioButton("ISE");
						radio7 = new JRadioButton("KMA");
						radio8 = new JRadioButton("SMC");
						radio9 = new JRadioButton("CCE");
						radio10 = new JRadioButton("CAE");
						Container container = new Container();
						container.setLayout(new GridLayout(14,14,4,4));
						ButtonGroup group = new ButtonGroup();
						group.add(radio1);
						group.add(radio2);
						group.add(radio3);
						group.add(radio4);
						group.add(radio5);
						group.add(radio6);
						group.add(radio7);
						group.add(radio8);
						group.add(radio9);
						group.add(radio10);
						radio1.setSelected(true);
						container.add(username);
						container.add(tusername);
						container.add(userpassword);
						container.add(tuserpassword);
						container.add(name);
						container.add(tname);
						container.add(specilty);
						container.add(tspecilty);
						container.add(radio1);
						container.add(radio2);
						container.add(radio3);
						container.add(radio4);
						container.add(radio5);
						container.add(radio6);
						container.add(radio7);
						container.add(radio8);
						container.add(radio9);
						container.add(radio10);
						create.addActionListener(new Create());
						container.add(create);
						this.setContentPane(container);
						this.setVisible(true);
					}
					
					class Create implements ActionListener
					{
						@Override
						public void actionPerformed(ActionEvent e) {
							Faculty t = Faculty.FIT;
							if(radio2.isSelected())
								t = Faculty.BS;
							if(radio3.isSelected())
								t = Faculty.FGGE;
							if(radio4.isSelected())
								t = Faculty.FEOGI;
							if(radio5.isSelected())
								t = Faculty.FGE;
							if(radio6.isSelected())
								t = Faculty.ISE;
							if(radio7.isSelected())
								t = Faculty.KMA;
							if(radio8.isSelected())
								t = Faculty.SMC;
							if(radio9.isSelected())
								t = Faculty.CCE;
							if(radio10.isSelected())
								t = Faculty.CAE;
							try 
							{
								DB.users.add(new Student(tusername.getText(), tuserpassword.getText(),tname.getText(), t,tspecilty.getText()));
								DB.WriteLog("Admin: " + thisadmin.getName() + " Added a New Student : " + tname.getText());
							}
							catch(Exception ex)
							{
								JOptionPane.showMessageDialog(null, ex.getMessage(),"Information",JOptionPane.PLAIN_MESSAGE);
							}
							AddStudent.this.dispose();
							DB.Serialize();
						}
					}
				}
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////
			class removeUser extends JFrame implements ActionListener
			{
				private static final long serialVersionUID = 1L;
				private JLabel userID;
				private JTextField tuid;
				private JButton remove;
				
				public removeUser() {
					super("Remove User:");
				}
				
				@Override
				public void actionPerformed(ActionEvent e) {
					this.setBounds(100,100,400,400);
					this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					userID = new JLabel("User ID For Delete:");
					tuid = new JTextField("ID@",5);
					remove = new JButton("Remove");
					Container container = new Container();
					container.setLayout(new GridLayout(14,14,4,4));
					container.add(userID);
					container.add(tuid);
					remove.addActionListener(new Remove());
					container.add(remove);
					this.setContentPane(container);
					this.setVisible(true);
				}
				
				class Remove implements ActionListener
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						String message = "User Not Found";
						for(int index = 0; index < DB.users.size(); index++)
						{
							if(DB.users.get(index) instanceof Student && ((Student)DB.users.get(index)).getID().contentEquals(tuid.getText())) {
								try 
								{
									DB.WriteLog("Admin: " + thisadmin.getName() + " Removed a Student : " + ((Student)DB.users.get(index)).getName());
								} 
								catch (IOException e1) 
								{
									e1.printStackTrace();
								}
								message = DB.users.get(index).toString() + "\n ----> Removed";
								DB.users.remove(index);
								break;
							}
							if(DB.users.get(index) instanceof Manager && ((Manager)DB.users.get(index)).getID().contentEquals(tuid.getText())) {
								try 
								{
									DB.WriteLog("Admin: " + thisadmin.getName() + " Removed a Manager : " + ((Manager)DB.users.get(index)).getName());
								} 
								catch (IOException e1) 
								{
									e1.printStackTrace();
								}
								message = DB.users.get(index).toString() + "\n ----> Removed";
								DB.users.remove(index);
								break;
							}
							if(DB.users.get(index) instanceof Teacher && ((Teacher)DB.users.get(index)).getID().contentEquals(tuid.getText())) {
								try 
								{
									DB.WriteLog("Admin: " + thisadmin.getName() + " Removed a Teacher : " + ((Teacher)DB.users.get(index)).getName());
								} 
								catch (IOException e1) 
								{
									e1.printStackTrace();
								}
								message = DB.users.get(index).toString() + "\n ----> Removed";
								DB.users.remove(index);
								break;
							}
							if(DB.users.get(index) instanceof Admin && ((Admin)DB.users.get(index)).getID().contentEquals(tuid.getText())) {
								try 
								{
									DB.WriteLog("Admin: " + thisadmin.getName() + " Removed an Admin : " + ((Admin)DB.users.get(index)).getName());
								} 
								catch (IOException e1) 
								{
									e1.printStackTrace();
								}
								message = DB.users.get(index).toString() + "\n ----> Removed";
								DB.users.remove(index);
								break;
							}
							if(DB.users.get(index) instanceof Student && ((Student)DB.users.get(index)).getID().contentEquals(tuid.getText())) {
								try 
								{
									DB.WriteLog("Admin: " + thisadmin.getName() + " Removed a Student : " + ((Student)DB.users.get(index)).getName());
								} 
								catch (IOException e1) 
								{
									e1.printStackTrace();
								}
								message = DB.users.get(index).toString() + "\n ----> Removed";
								DB.users.remove(index);
								break;
							}
							if(DB.users.get(index) instanceof TechSupportGuy && ((TechSupportGuy)DB.users.get(index)).getID().contentEquals(tuid.getText())) {
								try 
								{
									DB.WriteLog("Admin: " + thisadmin.getName() + " Removed a TechSupportGuy : " + ((TechSupportGuy)DB.users.get(index)).getName());
								} 
								catch (IOException e1) 
								{
									e1.printStackTrace();
								}
								message = DB.users.get(index).toString() + "\n ----> Removed";
								DB.users.remove(index);
								break;
							}
						}
						JOptionPane.showMessageDialog(null, message,"Removing",JOptionPane.PLAIN_MESSAGE);
						removeUser.this.dispose();
						DB.Serialize();
					}
				}
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////
			class setUserName extends JFrame implements ActionListener
			{
				private static final long serialVersionUID = 1L;
				private JLabel username;
				private JTextField tusername;
				private JButton change;
				
				public setUserName() {
					super("Set User Name:");
				}
				
				@Override
				public void actionPerformed(ActionEvent e) {
					this.setBounds(100,100,400,400);
					this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					username = new JLabel("New User Name to Change:");
					tusername = new JTextField("",5);
					change = new JButton("Change");
					Container container = new Container();
					container.setLayout(new GridLayout(14,14,4,4));
					container.add(username);
					container.add(tusername);
					change.addActionListener(new Change());
					container.add(change);
					this.setContentPane(container);
					this.setVisible(true);
				}
				
				class Change implements ActionListener
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						String message = "Cannot Change!";
						if(thisadmin.setUserName(tusername.getText())) 
						{
							message = "Succesfull!";
						}
						JOptionPane.showMessageDialog(null, message,"Changing",JOptionPane.PLAIN_MESSAGE);
						setUserName.this.dispose();
						DB.Serialize();
					}
				}
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////
			class setPassword extends JFrame implements ActionListener
			{
				private static final long serialVersionUID = 1L;
				private JLabel password;
				private JTextField tpassword;
				private JButton change;
				
				public setPassword() {
					super("Set User Name:");
				}
				
				@Override
				public void actionPerformed(ActionEvent e) {
					this.setBounds(100,100,400,400);
					this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					password = new JLabel("New User Password to Change:");
					tpassword = new JTextField("",5);
					change = new JButton("Change");
					Container container = new Container();
					container.setLayout(new GridLayout(14,14,4,4));
					container.add(password);
					container.add(tpassword);
					change.addActionListener(new Change());
					container.add(change);
					this.setContentPane(container);
					this.setVisible(true);
				}
				
				class Change implements ActionListener
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						String message = "Cannot Change!";
						if(thisadmin.setUserPassword(tpassword.getText())) 
						{
							message = "Succesfull!";
						}
						JOptionPane.showMessageDialog(null, message,"Changing",JOptionPane.PLAIN_MESSAGE);
						setPassword.this.dispose();
						DB.Serialize();
					}
				}
			}
		}
	}
}
