public class BSTTester1
{
	public static void main (String [] args)
	{
		BSTTester1 run = new BSTTester1();
		run.methods();
	}
	
	public void methods ( )
	{
		printTreeNodes();
		BinarySearchTree<Integer> myTree = new BinarySearchTree<Integer>();
		testAddTreeNodes(myTree);
		testCountNodes(myTree);
		testCountLevels(myTree);
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