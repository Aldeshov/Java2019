package pack;

public class SavingsAccount extends Account{
	
	private double per;
	
	public SavingsAccount(int a) {
		super(a);
		per = 0.01;
	}
	public SavingsAccount(int a,int per) {
		super(a);
		this.per = per;
	}
	public void addInterest() {
		deposit(getBalance() * per);
	}
}