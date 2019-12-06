package project;

import java.io.*;

public abstract class User implements Serializable,Cloneable 
{
	private static final long serialVersionUID = 1L;
	protected String userName;
	protected String userPassword;
	protected boolean isRegistered;
	
	public abstract String getUserName();
	public abstract boolean setUserName(String userName);
	public abstract String getHashPassword();
	public abstract boolean setUserPassword(String userPassword);
	public abstract String getHash(String userPassword);
	public abstract String toString();
	public boolean isRegistered(){
		return isRegistered;
	};
}
