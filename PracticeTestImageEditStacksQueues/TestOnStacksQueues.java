public class TestOnStacksQueues
{
	public static void main(String [] args)
	{
		TestOnStacksQueues run = new TestOnStacksQueues();
		run.methods();
	}
	
	public void methods ( )
	{
		method1();
		method2();
		method3();
	}
	
	public void method1 ( )
	{
		System.out.println("\n\n");
		
		ArrayStack<String> stack = new ArrayStack<String>();
		ArrayStack<String> stack2 = new ArrayStack<String>();
		ArrayStack<String> stack3 = new ArrayStack<String>();
			
		stack2.push("QUEUE");    stack2.push("POP");    stack2.push("PEEK");    
		stack2.push("LIFO");    stack2.push("FIFO");
		
		stack3.push("STACK");    stack3.push("PUSH"); 
			
		while (!stack2.isEmpty() && !stack3.isEmpty())
		{
			if (stack2.peek().compareTo(stack3.peek()) < 0)
			{
				stack.push(stack2.pop());
			}
			else
			{
				stack.push(stack3.pop());			//    OUTPUT:
			}
		}
		while (!stack2.isEmpty())
		{
			stack.push(stack2.pop());
		}
		while (!stack3.isEmpty())
		{
			stack.push(stack3.pop());
		}
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop() + "  ");
		}
		System.out.println("\n\n");
	}
	
	public void method2 ( )
	{
		ArrayStack<Integer> stack = new ArrayStack<Integer>();
		ArrayStack<Integer> stack2 = new ArrayStack<Integer>();
		ArrayStack<Integer> temp = new ArrayStack<Integer>();
		stack.push(8);
		stack.push(11);
		stack.push(14); 						//    OUTPUT:
		stack.push(17);
			
		while(!stack.isEmpty())
		{
			Integer value = stack.pop();
			temp.push(value);
			stack2.push(value);
		}
			
		while(!stack2.isEmpty())
		{
			stack.push(temp.peek());
			stack.push(stack2.pop());
		}
			
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop() + "  ");
		}
		System.out.println("\n\n");
	}
	
	public void method3 ( )
	{
		int arr [][] = { {0, 1, 2, 3}, {5, 6, 7, 8}, {8, 9, 10, 11} }; 				//    OUTPUT:
		for (int j = 0; j < arr[0].length; j++)
		{
			for (int k = arr.length - 1; k >= j; k--) 
			{
				System.out.print(arr[k][j] + "  ");
			}
			System.out.println("");
		}		
		System.out.println("\n\n");
	}
}
