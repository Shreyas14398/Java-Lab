package shape2d;
import shape2d.Twod.*;
public class Circle implements twod
{
	public double r;
	public Circle(double ra)
	{
		r=ra;
	}
	public double area()
	{
		return 3.14*r*r;
	}
	public double perimeter()
	{
		return 2*3.14*r;
	}
}
