import pkbanking.pkcustomer.*;
import java.util.Scanner;

public class BankDemo
{
	public static void main(String args[])
	{
		Customer c[]= new Customer[5];
		Scanner s= new Scanner(System.in);
		int i;

		for(i=0;i<1;i++)
		{
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
		}
		i=0;

		do
		{
			do
			{

				c[i].display();
				System.out.print("\nDo you want to continue (1/0) ? ");
				int c1= s.nextInt();
				if(c1==0)
					break;

			}while(true);

			i++;
		}while(i<5);

	}
}
