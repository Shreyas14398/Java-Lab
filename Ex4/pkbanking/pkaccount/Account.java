package pkbanking.pkaccount;
public abstract class Account
{
	protected int accnumber;
	protected double balance;

	public Account()
	{
    accnumber=0;
		balance=0.0;
	}

	public Account(int a, double b)
	{
		accnumber=a;
		balance=b;
	}
}
