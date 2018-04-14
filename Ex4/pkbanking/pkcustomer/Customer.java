package pkbanking.pkcustomer;
import java.util.Scanner;
import pkbanking.pkaccount.sb.*;
import pkbanking.pkaccount.fd.*;

public class Customer
{
	int cust_id;
	String name;
	String address;
	static SBAccount s1[]=new SBAccount[5];
	static FDAccount f1[]=new FDAccount[5];
	static int scount=0;
	static int fcount=0;
	Scanner s = new Scanner(System.in);

	public Customer(int c,String n, String a)
	{
		cust_id=c;
		name=n;
		address=a;
	}

	public void display()
	{
		System.out.println("\nName    : "+name);
		System.out.println("Address : "+address);
		System.out.println("ID      : "+cust_id);
		System.out.println("Account Type : 1.SB 2.FD \nEnter : ");
		int a=s.nextInt();
		display1(a);
	}

	void display1(int type)
	{
		System.out.println("Account Numbers : \n");
		if(type==1)
		{
			if(scount>0)
			{
				System.out.println("Savings Account");
				for(int i=0;i<scount;i++)
				{
					System.out.print("\n"+(i+1)+".Account Number : "+s1[i].acc_ret()+" ");
				}
				System.out.print("\n\nEnter the Number : ");
				int b=s.nextInt();
				System.out.print("\n 1.Withdraw\n 2.Deposit\n 3.Interest\n Enter : ");
				int a=s.nextInt();
				transaction(a,0,b);
			}
			else
				System.out.println("No Savings Accounts for this Customer");
		}

		else if(type==2)
		{
			if(fcount>0)
			{
				System.out.println("Fixed Deposit\n");
				for(int i=0;i<fcount;i++)
				{
					System.out.print((i+1)+".Account Number : "+f1[i].acc_ret()+" ");
				}
			System.out.print("\n\nEnter the Number : ");
			int b=s.nextInt();
			System.out.print("\n\n 1.Close\n Enter : ");
	    int a=s.nextInt();
		  transaction(a,1,b-1);
		 }
			else
				System.out.println("No Fixed Deposits for this Customer");
		}

		else
			System.out.println("Invalid Type");
	}

	public void createAccount(int type)
	{
		if(type==1)
		{
			do
			{
				System.out.print("\nEnter the Account Number : ");
				int a= s.nextInt();
				System.out.print("Enter the Balance        : ");
				double b= s.nextDouble();
				s1[scount] = new SBAccount(a,b);
				scount++;
				System.out.print("\nCreate Another Savings Account(1/0) ? ");
				int c1= s.nextInt();
				if(c1==0)
					break;
		    }while(true);
		}
		else if(type==2)
		{
			do
			{
				System.out.print("\nEnter the Account Number : ");
				int a= s.nextInt();
				System.out.print("Enter the Deposit Amount   : ");
				double b= s.nextDouble();
				System.out.print("Enter the Period           : ");
				int c2 = s.nextInt();
				f1[fcount] = new FDAccount(c2,b,a);
				fcount++;
				System.out.print("\nCreate Another Fixed Deposit Account(1/0) ? ");
				c2= s.nextInt();
				if(c2==0)
					break;
		    }while(true);
		}
		else
			System.out.println("Invalid Operation");
	}

	void transaction(int type, int acc_type, int op)
	{
		if(acc_type==0)
		{
			if(type==1)
			{
				System.out.print("Enter the Withdraw Amount : ");
				double wd= s.nextDouble();
				s1[op].withdraw(wd);
			}
			else if(type==2)
			{
				System.out.print("Enter the Deposit Amount : ");
				double dep= s.nextDouble();
				s1[op].deposit(dep);
			}
			else if(type==3)
			{
				s1[op].calc_interest();
			}
			else
				System.out.println("Invalid Operation");
		}
		else
		{
			if(type==1)
			{
				f1[op].close();
			}
			else
				System.out.println("Invalid Operation");
		}
	}
}
