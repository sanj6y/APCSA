/**
 *  Queue.java
 *
 *  An interface to represent a Queue.
 *
 *  @author Scott DeRuiter
 *  @version 1.0
 *  @since 3/8/2022
 */
 
public interface Queue<E>
{
	public abstract boolean isEmpty();
	public abstract E peek();
	public abstract boolean add(E obj);
	public abstract E remove();
}


