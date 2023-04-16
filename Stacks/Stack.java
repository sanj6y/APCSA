/**
 * Stack.java
 * 
 * An interface to represent a Stack.
 * 
 * @author Scott DeRuiter and Sanjay Chandrasekar
 * @version 1.0
 * @since 3/7/2022
 */

public interface Stack<E>
{
	public abstract boolean isEmpty();
	public abstract E peek();
	public abstract void push(E obj);
	public abstract E pop();
}