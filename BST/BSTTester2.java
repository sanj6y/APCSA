public class BSTTester2
{
	public static void main (String [] args)
	{
		BSTTester2 run = new BSTTester2();
		run.methods();
	}
	
	public void methods ( )
	{
		printTreeNodes();
		BinarySearchTree<Integer> myTree = new BinarySearchTree<Integer>();
		testAddTreeNodes(myTree);
		testCountNodes(myTree);
		testCountLevels(myTree);
		testFindAndRank(myTree);
		testMinAndMax(myTree);
		testDelete(myTree);
	}
	
	public void printTreeNodes ( )
	{
		TreeNode<Integer> tNode;
		tNode = new TreeNode<Integer>(43);
		System.out.println("\n\n\nThe tree node contains: " + (Integer)tNode.getValue());

		tNode.setValue(27);
		System.out.println("\nThe tree node contains: " + (Integer)tNode.getValue());
	}

	public void testAddTreeNodes(BinarySearchTree<Integer> tree)
	{
		System.out.println("\n\n");
		System.out.println(" TESTING THE METHOD add:\n");
		tree.add(63);
		tree.add(37);
		tree.add(75);
		tree.add(68);
		tree.add(56);
		tree.printInFullForm();
		System.out.print("--------------------------------------------------\nOR   ");
		System.out.println(tree);
		System.out.println("\n\n");
	}

	public void testCountNodes(BinarySearchTree<Integer> tree)
	{
		System.out.println();
		System.out.println(" TESTING THE METHOD countNodes:\n");
		tree.printInFullForm();
		System.out.print("--------------------------------------------------\nOR   ");
		System.out.println(tree);
		System.out.println("\nThe number of nodes in the tree above is: " + tree.countNodes());
		tree.add(21);
		tree.add(73);
		tree.printInFullForm();
		System.out.print("--------------------------------------------------\nOR   ");
		System.out.println(tree);
		System.out.println("\nThe number of nodes in the tree above is: " + tree.countNodes());
		System.out.println("\n\n");
	}
	
	public void testCountLevels(BinarySearchTree<Integer> tree)
	{
		System.out.println();
		System.out.println(" TESTING THE METHOD countLevels:");
		tree.printInFullForm();
		System.out.print("--------------------------------------------------\nOR   ");
		System.out.println(tree);
		System.out.println("\nThe number of levels in the tree above is: " + tree.levelCount());
		tree.add(45);
		tree.add(91);
		tree.add(88);
		tree.add(14);
		tree.add(66);
		tree.printInFullForm();
		System.out.print("--------------------------------------------------\nOR   ");
		System.out.println(tree);
		System.out.println("\nThe number of levels in the tree above is: " + tree.levelCount());
		tree.add(39);
		tree.add(17);
		tree.add(97);
		tree.printInFullForm();
		System.out.print("--------------------------------------------------\nOR   ");
		System.out.println(tree);
		System.out.println("\nThe number of levels in the tree above is: " + tree.levelCount());
		System.out.println("\nThe number of nodes in the tree above is: " + tree.countNodes());
		System.out.println("\n\n");
	}
	
	public void testFindAndRank(BinarySearchTree<Integer> tree)
	{
		System.out.println(" TESTING THE METHODS find (a specific value) and rank:\n");
		System.out.println(tree);
		System.out.println(" Looking for the value 88:");
		if(tree.find(88) != null)
		{
			System.out.println(" YES, 88 is in the Binary Search Tree, at \"index\" " + tree.rank(88));
		}
		else
		{
			System.out.println(" NO, 88 is NOT in the Binary Search Tree");
		}
		System.out.println("\n" + tree);
		System.out.println(" Looking for the value 14:");
		if(tree.find(14) != null)
		{
			System.out.println(" YES, 14 is in the Binary Search Tree, at \"index\" " + tree.rank(14));
		}
		else
		{
			System.out.println(" NO, 14 is NOT in the Binary Search Tree");
		}
		System.out.println("\n" + tree);
		System.out.println(" Looking for the value 97:");
		if(tree.find(97) != null)
		{
			System.out.println(" YES, 97 is in the Binary Search Tree, at \"index\" " + tree.rank(97));
		}
		else
		{
			System.out.println(" NO, 97 is NOT in the Binary Search Tree");
		}
		System.out.println("\n" + tree);
		System.out.println(" Looking for the value 11:");
		if(tree.find(11) != null)
		{
			System.out.println(" YES, 11 is in the Binary Search Tree, at \"index\" " + tree.rank(11));
		}
		else
		{
			System.out.println(" NO, 11 is NOT in the Binary Search Tree");
		}
		System.out.println("\n" + tree);
		System.out.println(" Looking for the value 54:");
		if(tree.find(54) != null)
		{
			System.out.println(" YES, 54 is in the Binary Search Tree, at \"index\" " + tree.rank(54));
		}
		else
		{
			System.out.println(" NO, 54 is NOT in the Binary Search Tree");
		}
		System.out.println("\n");
		
	}
	
	public void testMinAndMax(BinarySearchTree<Integer> tree)
	{
		System.out.println(" TESTING THE METHODS max and min:\n");
		System.out.println(tree);
		System.out.println("The minimum value in this tree is: " + tree.min());
		System.out.println("The maximum value in this tree is: " + tree.max());
		tree.add(98);
		tree.add(10);
		System.out.println("\n" + tree);
		System.out.println("The minimum value in this tree is: " + tree.min());
		System.out.println("The maximum value in this tree is: " + tree.max());
		System.out.println("\n");
	}
	
	public void testDelete(BinarySearchTree<Integer> tree)
	{
		System.out.println(" TESTING THE METHOD delete (a specific value):");
		tree.printInFullForm();
		System.out.print("--------------------------------------------------\nOR   ");
		System.out.println(tree);
		System.out.println("\n Delete the value 37:");
		tree.delete(37);
		tree.printInFullForm();
		System.out.print("--------------------------------------------------\nOR   ");
		System.out.println(tree);
		System.out.println("\n\n Delete the value 45:");
		tree.delete(45);
		tree.printInFullForm();
		System.out.print("--------------------------------------------------\nOR   ");
		System.out.println(tree);
		System.out.println("\n\n Delete the value 63:");
		tree.delete(63);
		tree.printInFullForm();
		System.out.print("--------------------------------------------------\nOR   ");
		System.out.println(tree);
		System.out.println("\n\n Delete the value 21:");
		tree.delete(21);
		tree.printInFullForm();
		System.out.print("--------------------------------------------------\nOR   ");
		System.out.println(tree);
		System.out.println("\n\n Delete the value 91:");
		tree.delete(91);
		tree.printInFullForm();
		System.out.print("--------------------------------------------------\nOR   ");
		System.out.println(tree);
		System.out.println("\n\n Delete the value 66:");
		tree.delete(66);
		tree.printInFullForm();
		System.out.print("--------------------------------------------------\nOR   ");
		System.out.println(tree);
		System.out.println("\n\n Delete the value 70:");
		tree.delete(70);
		tree.printInFullForm();
		System.out.print("--------------------------------------------------\nOR   ");
		System.out.println(tree);
		System.out.println("\n\n");
	}
}
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