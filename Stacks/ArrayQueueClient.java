public class ArrayQueueClient
{
	public static void main(String [] args)
	{
		ArrayQueueClient run = new ArrayQueueClient();
		run.methods();
	}
	
	public void methods ( )
	{
		ArrayQueue<String> stringQueue = new ArrayQueue<String>();
		
		System.out.println("\n\n\n");
		System.out.println(stringQueue.isEmpty());
		stringQueue.add("I'm First in line!");
		stringQueue.add("I'm Second!");
		stringQueue.add("I got here Third!");
		stringQueue.add("Shoot, I got here last!");
		System.out.println(stringQueue.isEmpty());
		
		System.out.println("\n\n\n");
		stringQueue = printAndPutBackInQueue(stringQueue);
		
		System.out.println("\n\n\n");
		System.out.println(stringQueue.isEmpty());
		System.out.println(stringQueue.peek());
		System.out.println(stringQueue.remove());
		System.out.println(stringQueue.peek());
		System.out.println(stringQueue.remove());
		System.out.println(stringQueue.peek());
		System.out.println(stringQueue.remove());
		System.out.println(stringQueue.peek());
		System.out.println(stringQueue.remove());
		System.out.println(stringQueue.isEmpty());
		System.out.println("\n\n\n");
	}
	
	public ArrayQueue<String> printAndPutBackInQueue(ArrayQueue<String> q)
	{
		ArrayQueue<String> temp = new ArrayQueue<String>();
		while(!q.isEmpty())
		{
			System.out.println(q.peek());
			temp.add(q.remove());
		}
		return temp;
	}
}

/*
C:\Java\Stacks> java ArrayQueueClient




true
false




I'm First in line!
I'm Second!
I got here Third!
Shoot, I got here last!




false
I'm First in line!
I'm First in line!
I'm Second!
I'm Second!
I got here Third!
I got here Third!
Shoot, I got here last!
Shoot, I got here last!
true




C:\Java\Stacks>
*/