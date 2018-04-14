class Factorial implements Runnable
{
	int val,fact;
	Thread t;

	Factorial(int v)
	{
		val=v;
		fact=1;
		t= new Thread(this,"Factorial");
		t.setPriority(1);
		t.start();
	}

	public void run()
	{
		try
		{
			System.out.println(t);
			if(val>0)
				for(int i=val;i>0;i--)
				{
					System.out.println("CurrentFactPriority : "+t.getPriority());
					fact*=i;
					t.sleep(100*i);
					t.setPriority(i);
					System.out.println("Fact : "+fact);
				}
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		System.out.println("The factorial is : "+fact);
		System.out.println("Factorial is Alive ? "+t.isAlive()+"--Finished");
	}
}

class SumOfSeries implements Runnable
{
	int val,sum;
	Thread t;

	SumOfSeries(int v)
	{
		val=v;
		sum=0;
		t=new Thread(this,"Sum");
		t.setPriority(5);
		t.start();
	}

	public void run()
	{
		try
		{
			System.out.println(t);
			for(int i=val;i>0;i--)
			{
				System.out.println("CurrentSumPriority : "+t.getPriority());
				sum+=i;
				t.sleep(200*i);
				t.setPriority(i);
				System.out.println("Sum : "+sum);
			}
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		System.out.println("The sum of natural numbers is : "+sum);
		System.out.println("Sum is Alive ? "+t.isAlive()+"--Finished");
	}
}

class MulTab implements Runnable
{
	int val;
	Thread t;

	MulTab(int v)
	{
		val=v;
		t=new Thread(this,"MulTab");
		t.setPriority(10);
		t.start();
	}

	public void run()
	{
		try
		{
			System.out.println(t);
			for(int i=1;i<=10;i++)
			{
				System.out.println("CurrentMulTabPriority : "+t.getPriority());
				System.out.println("Mul : "+val+" * "+i+" = "+val*i);
				t.sleep(100*i);
				t.setPriority(i);
			}
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		System.out.println("MulTab is Alive ? "+t.isAlive()+"--Finished");
	}
}

class ThreadTest
{
	public static void main(String args[])
	{
		Thread t;
		t=Thread.currentThread();
		Factorial f=new Factorial(8);
		System.out.println("Created Fact");
		SumOfSeries s=new SumOfSeries(10);
		System.out.println("Created Sum");
		MulTab m=new MulTab(5);
		System.out.println("Created MulTab");
		System.out.println("--------------Main Close------------");	
		/*try
		{
			t.join();
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}*/	
	}
}