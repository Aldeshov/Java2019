package pack;

public class Account {
	private double balance;
	protected int accNumber;

	public Account(int a) {
		balance = 0.0;
		accNumber = a;
	}
	public void deposit(double sum) {
		balance += sum;
	}
	public boolean withdraw(double sum) {
		if(getBalance() >= sum)
		{
			balance -= sum;
			return true;
		}
		return false;
	}
	public double getBalance() {
		return balance;
	}
	public int getAccountNumber() {
		return accNumber;
	}
	public boolean transfer(double amount, Account other) {
		if(balance >= amount) 
		{
			balance -= amount;
			other.deposit(amount);
			return true;
		}
		return false;
	}
	public String toString() {
		return accNumber + ": " + getBalance();
	}
	public final void print() {
		System.out.println(toString()); 
	}
}
