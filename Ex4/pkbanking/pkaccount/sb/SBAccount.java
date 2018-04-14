package pkbanking.pkaccount.sb;

import pkbanking.pkexception.*;
import pkbanking.pkinterface.*;
import pkbanking.pkaccount.Account;

public class SBAccount extends Account implements Transaction, InterestRate
{
	public SBAccount()
	{
		super();
	}

	public SBAccount(int a, double b)
	{
		super(a,b);
	}

  public int acc_ret()
	{
		return accnumber;
	}

	public void deposit(double dep)
	{
		try
		{
			if(balance>=0)
			{
				balance+=dep;
				System.out.println(dep+" has been deposited ");
				System.out.println("Updated Balance = "+balance);
			}
			else
			throw new IllegalArgumentException();
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("IllegalArgumentException:Negative Balance");
		}
	}

	public void withdraw(double wd)
	{
		try
		{
			if(balance-wd>min_balance)
			{
				balance-=wd;
				System.out.println(wd+" has been withdrawn");
				System.out.println("Updated Balance = "+balance);
			}
			else
			{
				throw new InsufficientFundsException();
			}
		}
		catch(InsufficientFundsException e)
		{
			System.out.println(e);
		}
	}

	public void calc_interest()
	{
		double temp;
		temp=sbrate*balance;
		balance+=temp;
		System.out.println("Updated Balance = "+balance);
	}
}
