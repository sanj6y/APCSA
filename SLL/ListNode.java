public class ListNode<E>
{
	private E value;
	private ListNode<E> next;
	
	public ListNode(E val)
	{
		value = val;
		next = null;
	}
	
	public ListNode(E val, ListNode<E> nx)
	{
		value = val;
		next = nx;
	}
	
	public E getValue()
	{
		return value;
	}
	
	public ListNode<E> getNext()
	{
		return next;
	}
	
	public void setValue(E val)
	{
		value = val;
	}
	
	public void setNext(ListNode<E> nx)
	{
		next = nx;
	}
}
