package assignment2;

/**
 * @authors:
 * 		Darron Singh
 * 		Jasindan Rasalingam
 * 		Kaushal Patel
 * 		Ashwin Kamalakannan
 * 
 * - Binary tree testing class
 * - Contains methods:
 * 		- Load(int[], String) constructs binary tree from given traversal and type O(n) time
 * 		- printTree(Node) prints all traversals of a given tree in O(n) time
 * 		- main(String[]) contains test cases and input 
 */

public class Tester {

	/*
	 * Takes an integer array for the data points Takes a String containing the
	 * type of traversal constructs tree with given information and returns it
	 */
	public static Node load(int[] input, String traversal) {
		Node root = null; // root for tree starts null
		int start = 0, finish = 0, dir = 0; // initialize variables

		if (traversal.equals("preorder")) { // preorder given
			root = new Node(input[0]); // start at index 0
			start = 1;
			finish = input.length;
			dir = 1;
		} else if (traversal.equals("inorder")) { // inorder given
			root = new Node(input[0]); // start at index 0
			start = 1;
			finish = input.length;
			dir = 1;
		} else if (traversal.equals("postorder")) { // postorder given
			root = new Node(input[input.length - 1]); // start at index end
			start = input.length - 1;
			finish = -1;
			dir = -1;
		}

		// loop through input array and load the tree
		for (int i = start; i != finish; i += dir) {
			if (input[i] < root.data) { // if input < root
				if (root.left == null) // check if left is null
					root.left = new Node(input[i]); // create left node
				else // if it wasn't empty
					root.left.insert(input[i]); // call recursive insert
			} else if (input[i] > root.data) { // if input > root
				if (root.right == null) // check if right is null
					root.right = new Node(input[i]); // create right node
				else // if it wasn't empty
					root.right.insert(input[i]); // call recursive insert
			} else // if neither
				root.data = input[i]; // root data set equal to input
		}
		return root; // return the tree at the end
	}

	/*
	 * Print all traversals for a given tree
	 */
	public static void printTree(Node root) {
		System.out.print("preorder: ");
		root.printPreOrder(); // print preorder
		System.out.println();
		System.out.print("inorder: ");
		root.printInOrder(); // print inorder
		System.out.println();
		System.out.print("postorder: ");
		root.printPostOrder(); // print postorder
	}
	
	/*
	 * main method, sets up input and all test cases
	 */
	public static void main(String args[]) {
		int[] input = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 }; // input array
		long runTime; // allocate memory to store runtime
		
		load(input, "preorder");
		
		// load tree with preorder traversal and print it
		System.out.println("Pre-order given");
		runTime = System.nanoTime();
		printTree(load(input, "preorder"));
		runTime = System.nanoTime() - runTime;
		System.out.println("\nruntime: " + ((double)runTime)/1000000 + "ms\n");

		// load tree with inorder traversal and print it
		System.out.println("In-order given");
		runTime = System.nanoTime();
		printTree(load(input, "inorder"));
		runTime = System.nanoTime() - runTime;
		System.out.println("\nruntime: " + ((double)runTime)/1000000 + "ms\n");

		// load tree with postorder traversal and print it
		System.out.println("Post-order given");
		runTime = System.nanoTime();
		printTree(load(input, "postorder"));
		runTime = System.nanoTime() - runTime;
		System.out.println("\nruntime: " + ((double)runTime)/1000000 + "ms\n");
	}
}
