package shape3d;
import shape3d.Threed.*;
import shape2d.*;

public class Cuboid extends Rectangle implements threed
{
	double h;
	public Cuboid(double x, double y,double z)
	{
		super(x,y);
		h=z;
	}
	public double volume()
	{
		return l*b*h;
	}
	public double surfaceArea()
	{
		return 2*(l*b+l*h+h*b);
	}
}
