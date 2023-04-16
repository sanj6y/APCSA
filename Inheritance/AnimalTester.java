public class AnimalTester
{
	public static void main(String[] args)
	{
		Animal beast = new Animal();
		Dog rover = new Dog();
		Animal dogBeast = new Dog();
		
		System.out.println("\n\n\n");
		beast.testClassMethod();
		beast.testInstanceMethod();
		System.out.println();
		rover.testClassMethod();
		rover.testInstanceMethod();
		System.out.println();
		dogBeast.testClassMethod();
		dogBeast.testInstanceMethod();
		System.out.println("\n\n\n");
	}
}

class Animal
{
	public static void testClassMethod()
	{
		System.out.println("The class method in Animal.");
	}
	
	public void testInstanceMethod()
	{
		System.out.println("The instance method in Animal.");
	}
}

class Dog extends Animal
{
	public static void testClassMethod()
	{
		System.out.println("The class method in Dog.");
	}
	
	public void testInstanceMethod()
	{
		System.out.println("The instance method in Dog.");
	}
}