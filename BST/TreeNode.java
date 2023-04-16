public class TreeNode<E>
{
	private E value;
	private TreeNode<E> left;
	private TreeNode<E> right;
	
	public TreeNode(E val)
	{
		value = val;
		left = null;
		right = null;
	}
	
	public TreeNode(E val, TreeNode<E> initLeft, TreeNode<E> initRight)
	{
		value = val;
		left = initLeft;
		right = initRight;
	}
	
	public E getValue()
	{
		return value;
	}
	
	public TreeNode<E> getLeft()
	{
		return left;
	}
	
	public TreeNode<E> getRight()
	{
		return right;
	}
	
	public void setValue(E val)
	{
		value = val;
	}
	
	public void setLeft(TreeNode<E> initLeft)
	{
		left = initLeft;
	}
	
	public void setRight(TreeNode<E> initRight)
	{
		right = initRight;
	}
}
