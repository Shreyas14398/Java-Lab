class point
{
	double x,y;
	point()
	{
		x=0;
		y=0;
	}
  point(double a, double b)
	{
		x=a;
		y=b;
	}
	point(point p)
	{
		this.x=p.x;
		this.y=p.y;
	}
	double find_distance(double a,double b)
	{
		double temp;
		temp=Math.sqrt((x-a)*(x-a)+(y-b)*(y-b));
		return temp;
	}
	double find_distance(point p)
	{
		double temp;
		temp=Math.sqrt((this.x-p.x)*(this.x-p.x)+(this.y-p.y)*(this.y-p.y));
		return temp;
	}
	void display()
	{
		System.out.println("(X ,Y) = (" + x +" , " + y +")");
	}
}

public class PointDemo
{
	public static void main(String a[])
	{
		point p1=new point(3.25,7.89);
		point p2=new point(5.37,18.12);
		point p3=new point(p2);
		p1.display();
		p2.display();
		System.out.println("The distance is " +p1.find_distance(7.9,16.25));
		System.out.println("The distance is " +p1.find_distance(p3));
	}
}
