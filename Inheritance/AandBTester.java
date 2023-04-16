public class AandBTester
{
	public static void main (String [] args)
	{
		System.out.println("\n\n\n");
		ClassA a = new ClassA();
		a.methodOne(1);
		System.out.println();
		a.methodTwo(1);
		System.out.println();
		a.methodThree(1);
		System.out.println();
		a.methodFour(1);
		System.out.println("\n--------------------------\n");
		
		ClassB b = new ClassB();
		b.methodOne(1);
		System.out.println();
		b.methodTwo(1);
		System.out.println();
		b.methodThree(1);
		System.out.println();
		b.methodFour(1);
		System.out.println("\n\n\n");
	}
}


class ClassA 
{
        public void methodOne(int i)
		{
			System.out.println("A One");
		}
        public void methodTwo(int i) 
		{
			System.out.println("A Two");
		}
        public static void methodThree(int i) 
		{
			System.out.println("A Three");
		}
        public static void methodFour(int i) 
		{
			System.out.println("A Four");
		}
}

class ClassB extends ClassA 
{
/*
        public static void methodOne(int i) 
		{
			super.methodOne(i);
			System.out.println("B One");
		}
*/
        public void methodTwo(int i) 
		{
			super.methodTwo(i);
			System.out.println("B Two");
		}
/*
        public void methodThree(int i) 
		{
			super.methodThree(i);
			System.out.println("B Three");
		}
*/
        public static void methodFour(int i) 
		{
//			super.methodFour(i);
			System.out.println("B Four");
		}
}
