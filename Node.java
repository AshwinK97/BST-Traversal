/**
 * @authors:
 * 		Darron Singh
 * 		Jasindan Rasalingam
 * 		Kaushal Patel
 * 		Ashwin Kamalakannan
 * 
 * - Binary tree node class
 * - Any single instance of a Node an be used to create a whole tree
 * - contains methods:
 * 		- recursive insert(int) O(log n) time
 * 		- recursive contains(int) O(log n) time
 *  		- printPreOrder(), printInOrder() and printPostOrder() all O(n) time
 */

public class Node {
	Node left, right; // left and right child nodes
	int data; // numerical data for the node

	/*
	 * constructor takes data for node and initializes it
	 */
	public Node(int data) {
		this.data = data;
	}

	/*
	 * takes data and traverses tree to insert at correct position
	 */
	public void insert(int value) {
		if (value <= data) { // if insert value is less than current node
			if (left == null) // if current node, left child is null
				left = new Node(value); // create left child and set value
			else
				left.insert(value); // if not, recall function for left child node
		} else { // if insert value is greater than current node
			if (right == null) // if current nodes, right child is null
				right = new Node(value); // create right child and set value
			else
				right.insert(value); // if not, recall function for right child node
		}
	}
	
	/*
	 * finds given data in tree and returns true if it exists, false otherwise
	 */
	public boolean contains(int value) {
		if (value == data) // if value = current node's data, return true
			return true;
		else if (value < data) { // if value is less than current node's data
			if (left == null) // return false if left child node is empty
				return false;
			else // if not empty, recall function for left child node
				return left.contains(value);
		} else { // if value is greater than current node's data
			if (right == null) // return false if right child node is empty
				return false;
			else // if not empty, recall function for the right child node
				return right.contains(value);
		}
	}
	
	/*
	 * prints node data from top to bottom, left to right
	 */
	public void printPreOrder() {
		System.out.print(data + " "); // print current node
		if (left != null) // check if left is not empty
			left.printPreOrder(); // recursively print left
		if (right != null) // check if right is not empty
			right.printPreOrder(); // recursively print right
	}
	
	/*
	 * prints node data in ascending order from left to right
	 */ 
	public void printInOrder() {
		if (left != null) // check if left is not empty
			left.printInOrder(); // recursively print left
		System.out.print(data + " "); // print current node
		if (right != null) // check if right is not empty
			right.printInOrder(); // recursively print right
	}
	
	/*
	 * prints node data from bottom to top, left to right
	 */
	public void printPostOrder() {
		if (left != null) // check if left is not empty
			left.printPostOrder(); // recursively print left
		if (right != null) // check if right is not empty
			right.printPostOrder(); // recursively print right
		System.out.print(data + " "); // print current node
	}
}

