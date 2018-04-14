import java.util.Scanner;
class Account
{
	protected int accno;
	protected double balance;
	Account()
	{
		accno=0;
		balance=0.0;
	}

	Account(int a, double b)
	{
		accno=a;
		balance=b;
	}
}
class SBAccount extends Account
{
	SBAccount()
	{
		super();
	}
	SBAccount(int acc, double bal)
	{
		super(acc,bal);
	}
	void deposit(double d)
	{
		if(balance>=0)
		{
			balance+=d;
		}
		else
			System.out.println("Negative Balance");
	}
	void withdraw(double w)
	{
		if(balance>1000)
		{
			balance-=w;
			System.out.println(w+" has been withdrawn");
			System.out.println("Updated Balance = "+balance);
		}
		else
		{
			System.out.println("Error: Insufficient Balance");
		}
	}
	void calc_interest()
	{
		double temp;
		temp=0.04*balance;
		balance+=temp;
		System.out.println("Updated Balance = "+balance);
	}
}
class FDAccount extends Account
{
	int period;
	FDAccount()
	{
		super();
	}
	FDAccount(int p,double dep,int acc)
	{
		super(acc,dep);
		period=p;
	}
	double calc_interest()
	{
		double temp;
		return temp=balance*0.0825*period;
	}
	void close()
	{
		balance+=calc_interest();
		System.out.println("Updated Balance = "+balance);
	}
}
class Customer
{
	int cust_id;
	int acc_type;
	String name;
	String address;
	SBAccount sb;
	FDAccount fd;
	Scanner s = new Scanner(System.in);
	Customer(int c,String n, String a)
	{
		cust_id=c;
		name=n;
		address=a;
	}
	void display()
	{
		System.out.println("\nName    : "+name);
		System.out.println("Address : "+address);
		System.out.println("ID      : "+cust_id);
	}
	void createAccount(int type)
	{
		if(type==1)
		{
			System.out.print("\nEnter the Account Number : ");
			int a= s.nextInt();
			System.out.print("Enter the Balance        : ");
			double b= s.nextDouble();
			sb = new SBAccount(a,b);
			acc_type=0;
		}
		else if(type==2)
		{
			System.out.print("\nEnter the Account Number : ");
			int a= s.nextInt();
			System.out.print("Enter the Deposit Amount   : ");
			double b= s.nextDouble();
			System.out.print("Enter the Period           : ");
			int c = s.nextInt();
			fd = new FDAccount(c,b,a);
			acc_type=1;
		}
		else
			System.out.println("Invalid Operation");
	}
	void transaction(int type)
	{
		if(acc_type==0)
		{
			if(type==1)
			{
				System.out.print("Enter the Withdraw Amount : ");
				double wd= s.nextDouble();
				sb.withdraw(wd);
			}
			else if(type==2)
			{
				System.out.print("Enter the Deposit Amount : ");
				double dep= s.nextDouble();
				sb.deposit(dep);
			}
			else if(type==3)
			{
				sb.calc_interest();
			}
			else
				System.out.println("Invalid Operation");
		}
		else
		{
			if(type==1)
			{
				fd.close();
			}
			else
				System.out.println("Invalid Operation");
		}
	}
}
public class BankDemo
{
	public static void main(String args[])
	{
		Customer c[]= new Customer[5];
		Scanner s= new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		int i=0;
		char rep='y';
		while(rep=='y'){
			System.out.print("\nEnter the Customer ID : ");
			int a= s.nextInt();
			s.nextLine();
			System.out.print("Enter the Name    : ");
			String b= s.nextLine();
			System.out.print("Enter the Address : ");
			String d= s.nextLine();
			c[i]=new Customer(a,b,d);
			System.out.print("Account Type\n1.SB\n2.FD\nEnter : ");
			a= s.nextInt();
			c[i].createAccount(a);
		i=0;
		do
		{
			if(c[i].acc_type==0)
			{
				c[i].display();
				System.out.print("Account Type : Savings Account \n1.Withdraw\n2.Deposit\n3.Interest\nEnter: ");
				int x=s.nextInt();
				c[i].transaction(x);
			}
			else
			{
				c[i].display();
				System.out.print("Account Type : Fixed Deposit \n1.Close 2.Exit\nEnter : ");
				int x=s.nextInt();
				if(x==1)
				c[i].transaction(x);
			}
			i++;
		}while(i<1);
	System.out.println("Next Customer y/n");
	rep=sc.next().charAt(0);
 }
}
}
