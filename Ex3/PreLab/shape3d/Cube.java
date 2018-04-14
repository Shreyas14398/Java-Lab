package shape3d;
import shape3d.Threed.*;
import shape2d.*;

public class Cube extends Square implements threed
{
	public Cube(double x)
	{
		super(x);
	}
	public double surfaceArea()
	{
		return 6*a*a;
	}
	public double volume()
	{
		return a*a*a;
	}
}
