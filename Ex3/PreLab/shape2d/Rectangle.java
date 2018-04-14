package shape2d;
import shape2d.Twod.*;
public class Rectangle implements twod
{
	public double l;
	public double b;
	public Rectangle(double x, double y)
	{
		l=x;
		b=y;
	}
	public double area()
	{
		return l*b;
	}
	public double perimeter()
	{
		return 2*(l+b);
	}
}
