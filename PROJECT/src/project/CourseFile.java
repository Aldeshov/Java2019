package project;

import java.io.*;

public class CourseFile implements Serializable,Cloneable 
{
	private static final long serialVersionUID = 1L;
	private String name;
	private File file;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String toString() {
		return getName() + " " + getFile().getPath();
	}
}
