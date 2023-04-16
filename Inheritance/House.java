
public class House extends Building
{
	public static void composition ( ) 
	{
		System.out.print("wood ");
	}

	public void color ( )
	{
		System.out.print("green ");
	}
	
	public void neighborhood ( )
	{
		System.out.print("by the park ");
	}

	public static void main(String[] args)
	{
		System.out.println("\n\n");
		House home = new House();
		home.composition();				//  wood  ->  calls composition() from House
		home.color();					//  green ->  calls color() from House								 SimpleStructure
		home.neighborhood();			//  by the park ->  calls neighborhood() from House							^
		home.address();					//  123 Hub Way ->  calls address() from Building							|
		home.city();					//  Cupertino ->  calls city from SimpleStructure							|
												//																 Building
		System.out.println("\n\n");				//																	^
		Building building = new House();		//																	|
		building.composition();			//  steel  ->  calls composition() from Building							|
		building.color();				//  green ->  calls color() from House									  House
//		building.neighborhood();		//  won't compile, neighborhood() is not an overriden method
		building.address();				//  123 Hub Way ->  calls address() from Building
		building.city();				//  Cupertino ->  calls city from SimpleStructure
		
		System.out.println("\n\n");
		SimpleStructure simple = new House();
		simple.composition();			//  sticks  ->  calls composition() from SimpleStructure
		simple.color();					//  green ->  calls color() from House
//		simple.neighborhood();			//  won't compile, neighborhood() is not an overriden method
		simple.address();				//  123 Hub Way ->  calls address() from Building
		simple.city();					//  Cupertino ->  calls city from SimpleStructure

		System.out.println("\n\n");
		Building buildingtwo = new Building();
		buildingtwo.composition();		//  steel  ->  calls composition() from Building
		buildingtwo.color();			//  gray ->  calls color() from Building
		buildingtwo.address();
		buildingtwo.city();

		System.out.println("\n\n");
		SimpleStructure simpletwo = new Building();
		simpletwo.composition();		//  sticks  ->  calls composition() from SimpleStructure
		simpletwo.color();				//  gray ->  calls color() from Building
		simpletwo.address();
		simpletwo.city();

		System.out.println("\n\n");
		SimpleStructure simplethree = new SimpleStructure();
		simplethree.composition();		//  sticks  ->  calls composition() from SimpleStructure
		simplethree.color();			//  brown ->  calls color() from SimpleStructure
		simplethree.address();
		simplethree.city();
		
//		Building buildingthree = simplethree;	//  does not compile, can't create an instance of
												//  the superclass using the subclass instance
												
//		House hometwo = simplethree;			//  does not compile, can't create an instance of
												//  the superclass using the subclass instance
		
		System.out.println("\n\n\n");		
	}
}
class Building extends SimpleStructure
{
	public static void composition ( )
	{ 
		System.out.print("steel ");
	}
	
	public void color ( )
	{
		System.out.print("gray ");
	}
	
	public void address ( )
	{
		System.out.print("123 Hub Way ");
	}
}
class SimpleStructure
{
	public static void composition ( )
	{ 
		System.out.print("sticks ");
	}

	public void color ( )
	{
		System.out.print("brown ");
	}
	
	public void address ( )
	{
		System.out.print("21 Dirt Road ");
	}
	
	public void city ( )
	{
		System.out.print("Cupertino ");
	}
}