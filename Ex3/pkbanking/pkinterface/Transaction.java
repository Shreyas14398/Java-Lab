package pkbanking.pkinterface;
public interface Transaction
{
	public double min_balance=500;
	public void withdraw(double a);
	public void deposit(double a);

}
