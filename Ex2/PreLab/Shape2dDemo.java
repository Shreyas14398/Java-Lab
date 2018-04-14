abstract class Shape2d
{
	double a;
	double b;
	Shape2d()
	{
		a=0;
		b=0;
	}
	abstract double area();
	abstract void display();
}
class Rectangle extends Shape2d
{
	Rectangle(double x, double y)
	{
		a=x;b=y;
	}
	double area()
	{
		return a*b;
	}
	void display()
	{
		System.out.println("Sides are : "+ a +" and " + b);
		System.out.println("Area is  : "+area());
	}
}
class Triangle extends Shape2d
{
	double c;
	Triangle(double x, double y, double z)
	{
		a=x;b=y;c=z;
	}
	double area()
	{
		double s=(a+b+c)/2;
		return Math.sqrt(Math.abs(s*(s-a)*(s-b)*(s-c)));
	}
	void display()
	{
		System.out.println("Sides are : "+a+" , "+b+" and "+c);
		System.out.println("Area is : "+area());
	}
}
public class Shape2dDemo
{
	public static void main(String args[])
	{
		Rectangle r = new Rectangle(5.62,7.14);
		Triangle t = new Triangle(23,5.78,9.04);
		r.display();
		t.display();
	}
}
