import java.util.*;
import java.lang.*;
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
		x=p.x;
		y=p.y;
	}
	double find_distance(double a,double b)
	{
		return Math.sqrt((a-x)*(a-x)+(b-y)*(b-y));
	}
		double find_distance(point a)
	{
		return Math.sqrt(((a.x)-x)*((a.x)-x)+((a.y)-y)*((a.y)-y));
	}

}
class ex6
{
	public static void main(String args[])
	{
		double x,y,z;
		ArrayList<point> al=new ArrayList<point>();
		al.add(new point(2,3));
		al.add(new point(4,5));
		al.add(new point(3,4));
	 	point p=al.get(0);
		point p1=al.get(2);
		point p2=al.get(1);
		x=p.find_distance(al.get(1));
	    y=p1.find_distance(al.get(0));
        z=p2.find_distance(al.get(2));
		System.out.println(x+" "+y+" "+z);
	}
}
