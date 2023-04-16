abstract class GrandMom
{
	public abstract void temperament();
}

class Dad extends GrandMom
{
	public void temperament ( )
	{
		System.out.println("GRUMPY");
	}
}

class Aunt extends GrandMom
{
	public void temperament ( )
	{
		System.out.println("FRIENDLY");
	}
}

public class MySelf extends Dad
{
	public static void main(String [] args)
	{
		GrandMom g1 = new Dad();
		Dad d1 = new MySelf();
		Aunt a1 = new Aunt();
		GrandMom g2 = new MySelf();
		GrandMom g3 = new Aunt();
		MySelf m1 = new MySelf();
		
		m1 = (MySelf)d1;
		g1.temperament();
		d1.temperament();
//		m1 = (MySelf)g3;
		g1 = (Dad)g2;
//		g3 = (MySelf)g1;
		g1.temperament();
		((Dad)g2).temperament();
		g3.temperament();
		m1.temperament();
	}
	
	public void temperament ( )
	{
		System.out.println("SULKY");
	}
}