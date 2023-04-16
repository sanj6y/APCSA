public class StuartReges
{
	public static void main(String [] args)
	{
		Ball var1 = new Truck();
		Doll var2 = new Doll();
		Ball var3 = new Block();
		Object var4 = new Ball();
		Truck var5 = new Block();
		Ball var6 = new Doll();
//		var1.method1();                  //  Compile-time error
		var2.method1();
		var1.method2();
		var2.method2();
		var3.method2();
//		var4.method2();                  //  Compile-time error
		var5.method2();
		var1.method3();
		var2.method3();
		var3.method3();
//		var4.method3();                  //  Compile-time error
		var5.method3();
//		((Doll)var3).method1();          //  Run-time error
		((Block)var5).method1();
//		((Truck)var3).method1();         //  Compile-time error
		((Truck)var3).method3();
//		((Block)var6).method3();         //  Run-time error
		((Ball)var4).method2();
//		((Truck)var4).method3();         //  Run-time error
		((Doll)var6).method3();
	}
}


class Block extends Truck 
{
	public void method1() 
	{
		System.out.println("Block 1");
	}

	public void method3() 
	{
		System.out.println("Block 3");
	}
}

class Doll extends Ball 
{
	public void method1() 
	{
		System.out.println("Doll 1");
	}

	public void method2() 
	{
		System.out.println("Doll 2");
	}
}

class Truck extends Ball 
{
	public void method2() 
	{
		System.out.println("Truck 2");
		super.method2();
		method3();
	}

	public void method3() 
	{
		System.out.println("Truck 3");
	}
}

class Ball 
{
	public void method2() 
	{
		System.out.println("Ball 2");
	}

	public void method3() 
	{
		System.out.println("Ball 3");
	}
}