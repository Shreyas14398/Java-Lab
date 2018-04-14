package shape3d;
import shape3d.Threed.*;
import shape2d.*;
public class Sphere extends Circle implements threed
{
	public Sphere(double ra)
	{
		super(ra);
	}
	public double volume()
	{
		return 4/3*3.14*r*r*r;
	}
	public double surfaceArea()
	{
		return 4*3.14*r*r;
	}
}
