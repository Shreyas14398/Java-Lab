package pkbanking.pkaccount.fd;

import pkbanking.pkinterface.InterestRate;
import pkbanking.pkaccount.Account;

public class FDAccount extends Account implements InterestRate
{
	int period;
	public FDAccount()
	{
		super();
	}
	public FDAccount(int p,double dep,int acc)
	{
		super(acc,dep);
		period=p;
	}
	public int acc_ret()
	{
		return accnumber;
	}
	double calc_interest()
	{
		return balance*fdrate*period;
	}
	public void close()
	{
		balance+=calc_interest();
		System.out.println("Updated Balance = "+balance);
	}
}
