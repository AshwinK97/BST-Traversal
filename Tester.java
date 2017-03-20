public class Tester {
	
	public static Node load(int[] input, String traversal) {
		Node root = null;
		int start = 0, finish = 0, dir = 0;
		
		if (traversal.equals("inorder")) {
			root = new Node(input[0]);
			start = 1; finish = input.length; dir = 1;
		} else if (traversal.equals("preorder")) {
			root = new Node(input[0]);
			start = 1; finish = input.length; dir = 1;
		} else if (traversal.equals("postorder")) {
			root = new Node(input[input.length-1]);
			start = input.length-1; finish = -1; dir = -1;
		}
		
		for (int i=start; i != finish; i += dir) {
			if (input[i] < root.data) {
				if (root.left == null)
					root.left = new Node(input[i]);
				else
					root.left.insert(input[i]);
			}
			else if (input[i] > root.data) {
				if (root.right == null)
					root.right = new Node(input[i]);
				else
					root.right.insert(input[i]);
			}
			else 
				root.data = input[i];
		}
		
		return root;
	}
	
	public static void printTree(Node root) {
		System.out.print("preorder: ");
		root.printInOrder();
		System.out.println();
		System.out.print("inorder: ");
		root.printPreOrder();
		System.out.println();
		System.out.print("postorder: ");
		root.printPostOrder();
		System.out.println("\n");
	}
	
	public static void main(String args[]) {
		int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		
		System.out.println("Pre-order given");
		printTree(load(input, "preorder"));
		
		System.out.println("In-order given");
		printTree(load(input, "inorder"));
		
		System.out.println("Post-order given");
		printTree(load(input, "postorder"));
		
	}
}
