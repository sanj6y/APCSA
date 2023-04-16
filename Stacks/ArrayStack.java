/**
 * ArrayStack.java
 * 
 * An interface to represent a Stack, make use of a List
 * and ArrayList.
 * 
 * @author Scott DeRuiter and Sanjay Chandrasekar
 * @version 1.0
 * @since 3/7/2022
 */
 
import java.util.List;
import java.util.ArrayList;

public class ArrayStack<E> implements Stack<E>
{
	public List<E> elements;
	
	public ArrayStack()
	{
		elements = new ArrayList<E>();
	}
	
	public boolean isEmpty()
	{
		return elements.isEmpty();
	}
	
	public E peek()
	{
		return elements.get(elements.size() - 1);
	}
	
	public void push(E obj)
	{
		elements.add(obj);
	}
	
	public E pop()
	{
		return elements.remove(elements.size() - 1);
	}
	
	public static void main(String[] args) 
	{
		ArrayStack<String> stringStack = new ArrayStack<String>();
		stringStack.push("Monday");
		stringStack.push("Tuesday");
		stringStack.push("Wednesday");
		
		System.out.println("\n\n\n");
		System.out.println(stringStack.isEmpty());
		System.out.println(stringStack.peek());
		System.out.println(stringStack.pop());
		System.out.println(stringStack.peek());
		System.out.println(stringStack.pop());
		System.out.println(stringStack.peek());
		System.out.println(stringStack.pop());
		System.out.println(stringStack.isEmpty());
		System.out.println("\n\n\n");
		
	}
}