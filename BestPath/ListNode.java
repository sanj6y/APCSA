public class ListNode
{
	private Object value;  // the element stored in this node
	private ListNode next; // reference to next node in List

	public ListNode(Object initValue, ListNode initNext) 
	{
	// post: constructs a new element with object initValue,
	// followed by next element
		value = initValue;
		next = initNext;
	}

	public ListNode (Object initValue)
	{
	// post: constructs a new element with object initValue,
	// followed by a reference to null
		this(initValue, null);
	}

	public Object getValue()
	{
	// post: returns value associated with this element
		return value;
	}

	public ListNode getNext()
	{
	// post: returns reference to next value in list
		return next;
	}

	public void setValue(Object theNewValue) 
	{
		value = theNewValue;
	}

	public void setNext(ListNode theNewNext) 
	{
	// post: sets reference to new next value
		next = theNewNext;
	}
}