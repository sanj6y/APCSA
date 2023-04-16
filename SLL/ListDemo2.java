public class ListDemo2
{
	public static void main (String [] args)
	{
		SinglyLinkedList<Integer> mylist;
		mylist = new SinglyLinkedList<Integer>();
		for (int i = 0; i < 20; i++)
		{
			mylist.addLast(i + 1);
		}
		System.out.println("\n\n");
		System.out.println("First Element: " + mylist.getFirst());
		System.out.println("Last Element: " + mylist.getLast());
		System.out.print("SinglyLinkedList: ");
		mylist.printList();
		System.out.println();
		System.out.println("Nodes: " + mylist.size());
		System.out.println("\n\n\n");
	}
}