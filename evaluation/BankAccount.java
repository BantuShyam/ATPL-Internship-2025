

//Section-B question 4

package evaluation;
class InsufficientBalance extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	InsufficientBalance(){
	super("Insufficient Balance pls check...");
	}
}
class NegativeDepositException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	NegativeDepositException(){
	super("Negative deposit pls check...");
	}
}
public class BankAccount{
	int balance=0;
	public void deposit(int money) throws NegativeDepositException {
		if(money<0) {
			throw new NegativeDepositException();
		}
		balance = money;
	}
	public void withdraw(int money) {
		balance-=money;
	}
	public int getBalance() throws InsufficientBalance{
		if(balance<0) {
			throw new InsufficientBalance();
		}
		return balance;
	}

	public static void main(String[] args) throws InsufficientBalance, NegativeDepositException {
		// TODO Auto-generated method stub
		BankAccount transaction=new BankAccount();
		transaction.deposit(1500);
		transaction.withdraw(1100);
		System.out.println("Balance is "+transaction.getBalance());
	}

}
