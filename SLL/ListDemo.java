public class ListDemo
{
	public static void main (String [] args)
	{
		ListNode<Integer> list;
		list = new ListNode<Integer>(13, null);
		System.out.println("\n\n\nThe node contains: " + list.getValue());

		list.setValue(17);
		System.out.println("\n\nThe node contains: " + list.getValue());

		SinglyLinkedList<Integer> mylist;
		mylist = new SinglyLinkedList<Integer>();
		for (int i = 0; i < 5; i++)
		{
			mylist.addFirst(i + 1);
		}
		System.out.println("\n\n");
		mylist.printList();
		System.out.println("\n\n\n");
	}
}