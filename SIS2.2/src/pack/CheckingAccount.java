package pack;

public class CheckingAccount extends Account{
	private int counter;
	private int free_transactions;
	public CheckingAccount(int a) {
		super(a);
		counter = 0;
		free_transactions = 0;
	}
	public boolean deductFee() {
		if(withdraw(0.02))
		{
			counter++;
			return true;
		}
		return false;
	}
	public int getCounter() {
		return counter;
	}
	public int getFree_transaction() {
		return free_transactions;
	}
}