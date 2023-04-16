/**
 * SinglyLinkedList.java
 * 
 * Implementation of a Singly-Linked List
 * class of a generic type.
 *
 * @author Scott DeRuiter and Sanjay Chandrasekar
 * @version 1.0
 * @since 4/11/2022
 */

import java.util.NoSuchElementException;

public class SinglyLinkedList<E>
{
	private ListNode<E> first;
	private ListNode<E> last;
	
	public SinglyLinkedList()
	{
		first = null;
	}
	
	/**
	 * Adds the parameter value as the first node in the linked list.
	 */
	public void addFirst(E value)
	{
		if (first == null)
		{
			first = last = new ListNode<E>(value);
		}
		else
		{
			first = new ListNode<E>(value, first);
		}
	}
	
	/**
	 * Adds the parameter value as the last node in the linked list.
	 */
	public void addLast(E value)
	{
		last = new ListNode<E>(value);
		ListNode<E> temp = first;
		
		if (temp == null)
		{
			addFirst(value);
			return;
		}
		
		while (temp.getNext() != null)
		{
			temp = temp.getNext();
		}
		temp.setNext(last);
	}
	
	/**
	 * Returns first element in the linked list. Throws a
	 * NoSuchElementException if the first element is null.
	 */
	public E getFirst()
	{
		if (first == null)
		{
			throw new NoSuchElementException();
		}
		return first.getValue();
	}
	
	/**
	 * Returns last element in the linked list. Throws a
	 * NoSuchElementException if the last element is null.
	 */
	public E getLast()
	{
		if (last == null)
		{
			throw new NoSuchElementException();
		}
		return last.getValue();
	}
	
	/**
	 * Returns the size of the linked list.
	 */
	public int size()
	{
		int count = 1;
		ListNode<E> temp = first;
		
		if (temp == null)
			return 0;
		
		while (temp.getNext() != null)
		{
			count++;
			temp = temp.getNext();
		}
		
		return count;
	}
	
	/**
	 * Inserts a parameter value into the linked list at
	 * a specified parameter index.
	 */
	public void insert(E value, int index)
	{	
		ListNode<E> temp = first;
		
		if (index == 0)
		{
			addFirst(value);
			return;
		}
		
		if (index > size() - 1)
		{
			addLast(value);
			return;
		}
		
		int count = 0;
		
		while (count != index - 1)
		{
			count++;
			temp = temp.getNext();
		}
		
		temp.setNext(new ListNode<E>(value, temp.getNext()));
		
	}
	
	/**
	 * Deletes all occurrences of a parameter value from the linked list.
	 * Does nothing if the parameter value is not found in the linked list.
	 */
	public void deleteValue(E value)
	{
		int count = 0;
		for (ListNode<E> node = first; node != null; node = node.getNext())
		{
			if (node.getValue().equals(value))
			{
				deleteIndex(count);
				count--;
			}
			count++;
		}

	}
	
	/**
	 * Deletes the value at the parameter index from the linked list.
	 * Does nothing if the parameter index is invalid.
	 */
	public void deleteIndex(int index)
	{
		ListNode<E> start = first;
		int count = 0;
		
		if (index < 0 || index > size() - 1)
			return;
			
		if (index == 0)
		{
			first = start.getNext();
			return;
		}
		
		while (start.getNext().getNext() != null && start.getNext() != null && count != index - 1)
		{
			start = start.getNext();
			count++;
		}
		
		start.setNext(start.getNext().getNext());
	}
	
	/**
	 * Traverses through the linked list and prints all values.
	 */
	public void printList()
	{
		ListNode<E> temp = first;
		
		while (temp != null)
		{
			System.out.print(temp.getValue() + " ");
			temp = temp.getNext();
		}
	}
}
