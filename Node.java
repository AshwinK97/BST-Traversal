/*
* Binary tree node
  Find a way to load tree nodes using the different types of traversal as input {1, 2, 3, 4}
  Then output the other 2 traversals
*/

public class Node {
	Node left, right;
	int data;

	public Node(int data) {
		this.data = data;

	}

	/* inserts value into tree */

	public void insert(int value) {
		if (value <= data) { // if insert value is less than current node
			if (left == null) // if current node, left child is null
				left = new Node(value); // create left child and set value
			else
				left.insert(value); // if not, recall function for left child node
		} else { // if insert value is greater than current node
			if (right == null) // if current noded, right child is null
				right = new Node(value); // create right child and set value
			else
				right.insert(value); // if not, recall function for right child node
		}
	}

	/* Returns true if tree contains value */

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

	/* Print the tree in order from left to right, aka ascending order */

	public void printInOrder() {
		if (left != null)
			left.printInOrder();
		System.out.println(data);
		if (right != null)
			right.printInOrder();
	}
	
	public void printPreOrder() {
		// TODO lul
	}
	
	public void printPostOrder() {
		// TODO this shit
	}
}
