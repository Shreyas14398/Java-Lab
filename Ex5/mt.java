import java.util.*;
class queue
{
 int n;
 boolean valueSet=false;
 synchronized void put(int n)
  {
    if(valueSet)
    try{
      wait();
    }
    catch(InterruptedException e){System.out.println("InterruptedException caught");}
    this.n=n;
    valueSet=true;
     System.out.println("put:"+n);
     notify();
   }
   synchronized int get()
   {
     if(!valueSet)
       try{
         wait();
       }catch(InterruptedException e){System.out.println("InterruptedException caught");}
      System.out.println("get:"+n);
      valueSet=false;
      notify();
      return n;
   }
}
class Producer implements Runnable
{
queue Q1;
Producer(queue q1)
{
   this.Q1=q1;
   new Thread(this,"Producer").start();
}
public void run()
{
  int i=0;
while(i<=10)
{
Q1.put(i++);
try{
Thread.sleep(300);
}catch(InterruptedException e){System.out.println("InterruptedException caught");}
}
}
}
class Consumer implements Runnable
{
queue Q2;
Consumer(queue q2)
{
  this.Q2=q2;
  new Thread(this,"Consumer").start();
}
public void run()
{
 while(true)
 {
  Q2.get();
  try{
  Thread.sleep(300);
  }catch(InterruptedException e){System.out.println("InterruptedException caught");}
}
 }
}
class mt
{
public static void main(String args[])
{
queue q=new queue();
new Producer(q);
new Consumer(q);
System.out.println("mt exiting");
}
}
