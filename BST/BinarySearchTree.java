/**
 * BinarySearchTree.java
 * 
 * Program that provides implementation of a
 * Binary Search Tree, with necessary methods
 * such as counting total number of nodes,
 * finding the minimum or maximum value,
 * searching for a certain value, and adding
 * or deleting a node from the tree.
 *
 * @author Scott DeRuiter and Sanjay Chandrasekar
 * @version 1.0
 * @since 5/16/2022
 */
import java.util.NoSuchElementException;
import java.util.List;
import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>>
{
	private TreeNode<E> root;
	
	/** Constructs a BinarySearchTree object. */
	public BinarySearchTree ( )
	{
		root = null;
	}
	
	/** Clears entire BST. */
	public void clear ( )
	{
		root = null;
	}
	
	/** Returns number of nodes in the BST. */
	public int countNodes ( )
	{
		return countNodes(root);
	}
	
	/** Counts the number of nodes in the BST using recursion. */
	public int countNodes(TreeNode<E> node)
	{
		if (node == null)
			return 0;
		else
			return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
	}
	
	/** Returns the least value in the entire BST. */
	public E min()
	{
		return min(root);
	}

	/** Least value is also leftmost value; this method
	 * 	finds and returnd least/leftmost value in BST. */
	private E min(TreeNode<E> node) 
	{
		if (node.getLeft() == null)
			return node.getValue();
		
		return min(node.getLeft());
	}

	/** Returns the greatest value in the entire BST. */
	public E max()
	{
		return max(root);
	}

	/** Greatest value is also rightmost value; this method
	 * 	finds and returnd greatest/rightmost value in BST. */
	private E max(TreeNode<E> node) 
	{
		if (node.getRight() == null)
			return node.getValue();
		
		return max(node.getRight());
	}
	
	/** Returns TreeNode containing passed in value. */
	public TreeNode<E> find(E value) 
	{
		return find(root, value);
	}
	
	/**	Finds and returns TreeNode containing passed
	 * 	in value in the BST using recursion. */
	public TreeNode<E> find(TreeNode<E> node, E value)
	{
		if (node == null)
			return null;
		else
		{
			int diff = value.compareTo(node.getValue());
			if (diff == 0)
				return node;
			else if (diff < 0)
				return find(node.getLeft(), value);
			else // if (diff > 0)
				return find(node.getRight(), value);
		}
	}
	
	/** Returns index of TreeNode containing passed in value. */
	public int rank(E value)
	{
		if (value != null)
		{
			return rank(value, root);
		}
		return -1;
	}

	/** Finds and returns index of the first TreeNode
	 * 	containing passed in value, using recursion. */
	private int rank(E value, TreeNode<E> node)
	{
		if (node == null)
			return 0;
			
		if (node.getValue().compareTo(value) == 0)
			return 0;
		 
		else if (node.getValue().compareTo(value) > 0)
			return rank(value, node.getLeft());
		
		else
			return 1 + rank(value, node.getLeft()) + rank(value, node.getRight());
	}
	
	/**
	 * Returns true if this BST contains value; otherwise
	 * returns false.
	 */
	public boolean contains(E value)
	{
		return contains(root,value);
	}
	
	/**
	 * Returns true if the BST rooted at node contains value.
	 * Otherwise returns false (recursive version).
	 */
	private boolean contains(TreeNode<E> node, E value)
	{
		if (node == null)
			return false;
		else
		{
			int diff = value.compareTo(node.getValue());
			if (diff == 0)
				return true;
			else if (diff < 0)
				return contains(node.getLeft(), value);
			else // if (diff > 0)
				return contains(node.getRight(), value);
		}
	}
	
	/**
	 * Adds value to this BST, unless this tree already holds
	 * value. Returns true if value has been added; otherwise
	 * returns false.
	 */
	public boolean add(E value)
	{
		if(contains(value))
		{
			return false;
		}
		root = add(root, value);
		return true;
	}
	
	/**
	 * Adds value of the BST rooted at node. Returns the root
	 * of the new tree.
	 */
	private TreeNode<E> add(TreeNode<E> node, E value)
	{
		if (node == null)
			node = new TreeNode(value);
		else
		{
			int diff = value.compareTo(node.getValue());
			if (diff < 0)
				node.setLeft(add(node.getLeft(), value));
			else // if (diff > 0)
				node.setRight(add(node.getRight(), value));
		}
		
		return node;
	}
	
	/** Returns the maximum number of levels in the BST. */
	public int levelCount ( ) 
	{
		return(maxDepth(root));
	}
	
	/** Counts and returns the number of levels in the BST
	 * 	using recursion. */
	private int maxDepth(TreeNode<E> node) 
	{
		if (node == null)
			return 0;
		
		int leftDepth = maxDepth(node.getLeft());
		int rightDepth = maxDepth(node.getRight());
		
		return 1 + Math.max(leftDepth, rightDepth);
	}
	
	/** Deletes the TreeNode containing a certain value
	 * from the BST. */
	public void delete(E value) 
	{
		if (!contains(value))
			System.out.println("Sorry, but " + value + " could not be found.");
		root = delete(root, value);
	}
	
	/** Deletes the TreeNode containing a certain value
	 * 	from the BST, using recursion. Returns new,
	 * 	modified BST. */
	private TreeNode<E> delete(TreeNode<E> node, E value) 
	{
		
		if (node == null)
			return null;
		
		if (value.compareTo(node.getValue()) < 0)
			node.setLeft(delete(node.getLeft(), value));
		else if (value.compareTo(node.getValue()) > 0)
			node.setRight(delete(node.getRight(), value));
		
		else
		{
			if (node.getLeft() == null)
				return node.getRight();
			else if (node.getRight() == null)
				return node.getLeft();
			
			node.setValue(min(node.getRight()));
			node.setRight(delete(node.getRight(), node.getValue()));
		}
		
		return node;
	}
	
	
	
	/*********  The methods below are complete.  Do not change them.    **********/
	
	
	/** Returns a String representation of this BST. */
	public String toString ( )
	{
		return print(root);
	}
	
	/** Returns a String representation of the tree rooted at node. */
	public String print(TreeNode<E> node)
	{
		if (node != null) 
		{
			return print(node.getLeft()) + String.format("%4d", node.getValue()) + print(node.getRight());
		}
		return "";
	}

	public void printInFullForm ( )
	{
		int height = getHeight(root);
		int size = (int)Math.pow(2, height)-1;
		List<List<String>> result = new ArrayList<List<String>>();
		for(int i = 0; i < height; i++)
		{
			List<String> list = new ArrayList<String>();
			for(int j = 0; j < size; j++)
			{
				list.add("  ");
			}
			result.add(list);
		}
		helper(result, root, 0, 0, size - 1);
		System.out.println();
		for(List<String> line : result)
		{
			for(String numberOrSpaces : line)
			{
				System.out.print(numberOrSpaces);
			}
			System.out.println("\n");
		}
	}

	public void helper(List<List<String>> result, TreeNode<E> node, int level, int left, int right)
	{
		if(node == null)
		{
			return;
		}
		int index = (left + right) / 2;
		result.get(level).set(index, node.getValue()+"");
		helper(result, node.getLeft(), level+1, left, index-1);
		helper(result, node.getRight(), level+1, index+1, right);
	}

	public int getHeight(TreeNode<E> node)
	{
		if(node == null)
		{
			return 0;
		}
		return Math.max(1 + getHeight(node.getLeft()), 1 + getHeight(node.getRight()));
	}
}

/*
PS D:\Java2020\BinarySearchTreeGeneric> java BSTTester1



The tree node contains: 43

The tree node contains: 27



 TESTING THE METHOD add:


      63

  37      75

    56  68

--------------------------------------------------
OR     37  56  63  68  75




 TESTING THE METHOD countNodes:


      63

  37      75

    56  68

--------------------------------------------------
OR     37  56  63  68  75

The number of nodes in the tree above is: 5

              63

      37              75

  21      56      68

                    73

--------------------------------------------------
OR     21  37  56  63  68  73  75

The number of nodes in the tree above is: 7




 TESTING THE METHOD countLevels:

              63

      37              75

  21      56      68

                    73

--------------------------------------------------
OR     21  37  56  63  68  73  75

The number of levels in the tree above is: 4

              63

      37              75

  21      56      68      91

14      45      66  73  88

--------------------------------------------------
OR     14  21  37  45  56  63  66  68  73  75  88  91

The number of levels in the tree above is: 4

                              63

              37                              75

      21              56              68              91

  14              45              66      73      88      97

    17          39

--------------------------------------------------
OR     14  17  21  37  39  45  56  63  66  68  73  75  88  91  97

The number of levels in the tree above is: 5

The number of nodes in the tree above is: 15



PS D:\Java2020\BinarySearchTreeGeneric>
*/

/*
PS D:\Java2020\BinarySearchTreeGeneric> java BSTTester2



The tree node contains: 43

The tree node contains: 27



 TESTING THE METHOD add:


      63

  37      75

    56  68

--------------------------------------------------
OR     37  56  63  68  75




 TESTING THE METHOD countNodes:


      63

  37      75

    56  68

--------------------------------------------------
OR     37  56  63  68  75

The number of nodes in the tree above is: 5

              63

      37              75

  21      56      68

                    73

--------------------------------------------------
OR     21  37  56  63  68  73  75

The number of nodes in the tree above is: 7




 TESTING THE METHOD countLevels:

              63

      37              75

  21      56      68

                    73

--------------------------------------------------
OR     21  37  56  63  68  73  75

The number of levels in the tree above is: 4

              63

      37              75

  21      56      68      91

14      45      66  73  88

--------------------------------------------------
OR     14  21  37  45  56  63  66  68  73  75  88  91

The number of levels in the tree above is: 4

                              63

              37                              75

      21              56              68              91

  14              45              66      73      88      97

    17          39

--------------------------------------------------
OR     14  17  21  37  39  45  56  63  66  68  73  75  88  91  97

The number of levels in the tree above is: 5

The number of nodes in the tree above is: 15



 TESTING THE METHODS find (a specific value) and rank:

  14  17  21  37  39  45  56  63  66  68  73  75  88  91  97
 Looking for the value 88:
 YES, 88 is in the Binary Search Tree, at "index" 12

  14  17  21  37  39  45  56  63  66  68  73  75  88  91  97
 Looking for the value 14:
 YES, 14 is in the Binary Search Tree, at "index" 0

  14  17  21  37  39  45  56  63  66  68  73  75  88  91  97
 Looking for the value 97:
 YES, 97 is in the Binary Search Tree, at "index" 14

  14  17  21  37  39  45  56  63  66  68  73  75  88  91  97
 Looking for the value 11:
 NO, 11 is NOT in the Binary Search Tree

  14  17  21  37  39  45  56  63  66  68  73  75  88  91  97
 Looking for the value 54:
 NO, 54 is NOT in the Binary Search Tree


 TESTING THE METHODS max and min:

  14  17  21  37  39  45  56  63  66  68  73  75  88  91  97
The minimum value in this tree is: 14
The maximum value in this tree is: 97

  10  14  17  21  37  39  45  56  63  66  68  73  75  88  91  97  98
The minimum value in this tree is: 10
The maximum value in this tree is: 98


 TESTING THE METHOD delete (a specific value):

                              63

              37                              75

      21              56              68              91

  14              45              66      73      88      97

10  17          39                                          98

--------------------------------------------------
OR     10  14  17  21  37  39  45  56  63  66  68  73  75  88  91  97  98

 Delete the value 37:

                              63

              39                              75

      21              56              68              91

  14              45              66      73      88      97

10  17                                                      98

--------------------------------------------------
OR     10  14  17  21  39  45  56  63  66  68  73  75  88  91  97  98


 Delete the value 45:

                              63

              39                              75

      21              56              68              91

  14                              66      73      88      97

10  17                                                      98

--------------------------------------------------
OR     10  14  17  21  39  56  63  66  68  73  75  88  91  97  98


 Delete the value 63:

                              66

              39                              75

      21              56              68              91

  14                                      73      88      97

10  17                                                      98

--------------------------------------------------
OR     10  14  17  21  39  56  66  68  73  75  88  91  97  98


 Delete the value 21:

                              66

              39                              75

      14              56              68              91

  10      17                              73      88      97

                                                            98

--------------------------------------------------
OR     10  14  17  39  56  66  68  73  75  88  91  97  98


 Delete the value 91:

              66

      39              75

  14      56      68      97

10  17              73  88  98

--------------------------------------------------
OR     10  14  17  39  56  66  68  73  75  88  97  98


 Delete the value 66:

              68

      39              75

  14      56      73      97

10  17                  88  98

--------------------------------------------------
OR     10  14  17  39  56  68  73  75  88  97  98


 Delete the value 70:
 Sorry, but 70 could not be found.

              68

      39              75

  14      56      73      97

10  17                  88  98

--------------------------------------------------
OR     10  14  17  39  56  68  73  75  88  97  98



PS D:\Java2020\BinarySearchTreeGeneric>
*/
