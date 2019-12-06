package pack;

public class problem2 {
	public static void main(String args[]) {
		Bank a = new Bank();
		a.addAccount(123,"SavingsAccount");
		a.addAccount(456,"CheckingAccount");
		a.Update(100.0,123);
		a.Deposit(500, 456);
		a.Update(10,456);
		//a.Transfer(25.0, 123, 456);
		System.out.println(a.getAccounts());
	}
}
