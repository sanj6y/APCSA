/**
 *  ArrayQueue.java
 *
 *  A class to represent a Queue, making use of a List
 *  and an ArrayList.
 *
 *  @author Scott DeRuiter and Sanjay Chandrasekar
 *  @version 1.0
 *  @since 3/9/2022
 */
 
import java.util.List;
import java.util.ArrayList;

public class ArrayQueue<E> implements Queue<E>
{
	public List<E> elements;
	
	public ArrayQueue()
	{
		elements = new ArrayList<E>();
	}
	
	public boolean isEmpty()
	{
		return elements.isEmpty();
	}
	
	public E peek()
	{
		return elements.get(0);
	}
	
	public boolean add(E obj)
	{
		return elements.add(obj);
	}
	
	public E remove()
	{
		return elements.remove(0);
	}
}