public class Node {
	Node left, right;
	int data;

	public Node(int data) {
		this.data = data;
	}

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

	public void printInOrder() {
		if (left != null)
			left.printInOrder();
		System.out.print(data + " ");
		if (right != null)
			right.printInOrder();
	}

	public void printPreOrder() {
		System.out.print(data + " ");
		if (left != null)
			left.printPreOrder();
		if (right != null)
			right.printPreOrder();
	}

	public void printPostOrder() {
		if (left != null)
			left.printPostOrder();
		if (right != null)
			right.printPostOrder();
		System.out.print(data + " ");
	}
}

