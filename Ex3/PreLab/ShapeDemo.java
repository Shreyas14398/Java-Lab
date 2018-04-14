import java.util.Scanner;
import shape2d.*;
import shape3d.*;

public class ShapeDemo
{
	public static void main(String args[])
	{
		Scanner sca = new Scanner(System.in);
		char rep='y';int ch1;
		while(rep=='y')
		{
			System.out.println("1.Square 2.Rectangle 3.Circle 4.Cube 5.Cuboid 6.Sphere");
			ch1= sca.nextInt();
			if(ch1==1)
			{
				System.out.println("Enter the side");
				int a1 = sca.nextInt();
				Square sq=new Square(a1);
				System.out.println("The Area of Square         : "+sq.area());
				System.out.println("The Perimeter of Square    : "+sq.perimeter());
			}
			else if(ch1==2)
			{
				System.out.println("Enter the sides");
				int l1 = sca.nextInt();
				int b1 = sca.nextInt();
				Rectangle re=new Rectangle(l1,b1);
				System.out.println("The Area of Rectangle      : "+re.area());
				System.out.println("The Perimeter of Rectangle : "+re.perimeter());
			}
			else if(ch1==3)
			{
				System.out.println("Enter the radius");
				int r1 = sca.nextInt();
				Circle ci=new Circle(r1);
				System.out.println("The Area of Circle         : "+ci.area());
				System.out.println("The Perimeter of Circle    : "+ci.perimeter());
			}
			else if(ch1==4)
			{
				System.out.println("Enter the side");
				int a2 = sca.nextInt();
				Cube s1=new Cube(a2);
				System.out.println("The SurfaceArea of Cube    : "+s1.surfaceArea());
				System.out.println("The Volume of Cube         : "+s1.volume());
			}
			else if(ch1==5)
			{
				System.out.println("Enter the sides");
				int l2 = sca.nextInt();
				int b2 = sca.nextInt();
				int h2 =sca.nextInt();
				Cuboid r1=new Cuboid(l2,b2,h2);
				System.out.println("The SurfaceArea of Cuboid  : "+r1.surfaceArea());
				System.out.println("The Volume of Cuboid       : "+r1.volume());
			}
			else if(ch1==6)
			{
				System.out.println("Enter the radius");
				int r2 = sca.nextInt();
				Sphere c1=new Sphere(r2);
				System.out.println("The SurfaceArea of Sphere  : "+c1.surfaceArea());
			System.out.println("The Volume of Sphere       : "+c1.volume());
			}
			System.out.println("Continue y/n");
			rep = sca.next().charAt(0);
		}
				}
}
