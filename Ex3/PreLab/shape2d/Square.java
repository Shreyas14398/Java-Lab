package shape2d;
import shape2d.Twod.*;
public class Square implements twod
{
	public double a;
  public Square(double x)
	{
		a=x;
	}
	public double area()
	{
		return a*a;
	}
	public double perimeter()
	{
		return 4*a;
	}
}
