package pack;

import java.util.Vector;

public class Bank{
	private Vector<Account> accs;
	public Bank() {
		accs = new Vector<Account>();
	}
	public void Deposit(double sum, int ID) {
		for(int i = 0; i < accs.size();i++) {
			if(accs.get(i).getAccountNumber() == ID)
			{
				accs.get(i).deposit(sum);
			}
		}
	}
	public void Withdraw(double sum, int ID) {
		for(int i = 0; i < accs.size();i++) {
			if(accs.get(i).getAccountNumber() == ID)
			{
				if(accs.get(i).withdraw(sum)) 
				{
					System.out.println("-->OK");
				}
				else
					System.out.println("-->ERROR: Have no enough money");
			}
		}
	}
	public void Transfer(double sum, int toID, int fromID) {
		for(int i = 0; i < accs.size();i++) {
			for(int j = 0; j < accs.size();j++) {
				if(accs.elementAt(i).getAccountNumber() == toID && accs.elementAt(j).getAccountNumber() == fromID) {
					if(accs.elementAt(j).transfer(sum,accs.elementAt(i)))
						accs.elementAt(i).deposit(sum);
					else
						System.out.println("-->ERROR: Have no enough money to Transfer");
					break;
				}
			}
		}
	}
	public void Update(double sum, int ID) {
		for(int i = 0; i < accs.size();i++) {
			if(accs.get(i).getAccountNumber() == ID)
			{
				if(accs.elementAt(i) instanceof SavingsAccount)
				{
					accs.get(i).deposit(sum);
					
					SavingsAccount a = (SavingsAccount) accs.elementAt(i);
					accs.remove(i);
					a.addInterest();
					accs.add((Account) a);
					System.out.println( " SA " + a.getAccountNumber() + ":  " + a.getBalance());
					break;
				}else
				if(accs.elementAt(i) instanceof CheckingAccount)
				{
					if(accs.get(i).withdraw(sum)) 
					{
						System.out.println("-->OK");
					}
					else
						System.out.println("-->ERROR: Have no enough money");
					
					CheckingAccount a = (CheckingAccount) accs.elementAt(i);
					accs.remove(i);
					a.deductFee();
					accs.add((Account) a);
					System.out.println( " CA " + a.getAccountNumber() + ":  " + a.getBalance());
					break;
				}
				break;
			}
		}
	}
	public void removeAccount(int ID) {
		for(int i = 0; i < accs.size();i++) {
			if(accs.get(i).getAccountNumber() == ID)
			{
				accs.remove(i);
				break;
			}
		}
	}
	public void addAccount(int ID,String Type){
		if(Type.equals("SavingsAccount")) 
		{
			accs.add(new SavingsAccount(ID));
		}
		if(Type.equals("CheckingAccount")) 
		{
			accs.add(new CheckingAccount(ID));
		}
		if(Type.equals("Account"))
		{
			accs.add(new Account(ID));
		}
	}
	public String getAccounts(){
		return accs.toString();
	}
}
