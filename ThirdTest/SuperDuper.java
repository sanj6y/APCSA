public class SuperDuper
{
	public static void main(String [] args)
	{
		SuperDuper super1;
		DuperInterface interface1;
		Duper dd1 = new Duper();
		SubSuper ss1 = new SubSuper();
		SubSuper ss2;
		super1 = dd1;
		interface1 = ss1;
		
		ss2 = (SubSuper)interface1;
//		ss2 = (SubSuper)dd1;
		ss1 = (SubSuper)interface1;
//		interface1 = super1;
//		ss1 = (SubSuper)dd1;
//		ss1 = dd1;
	}
}

interface DuperInterface
{
	
}

class Duper extends SuperDuper
{
	
}

class SubSuper extends SuperDuper implements DuperInterface
{
	
}