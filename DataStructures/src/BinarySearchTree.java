import java.awt.HeadlessException;

// Java program to demonstrate delete operation in binary search tree
class BinarySearchTree {

	/* Class containing left and right child of current node and data value */
	class Node {
		int data;
		Node left;
		Node right;

		public Node(int item) {
			data = item;
			left = null;
			right = null;
		}
	}

	// Root of BST
	Node root;

	// Constructor
	BinarySearchTree() {
		root = null;
	}

	// This method mainly calls insertRec()
	void insert(int data) {
		root = insertRec(root, data);
	}

	/* A recursive function to insert a new data in BST */
	Node insertRec(Node root, int data) {
		if (root == null) {
			root = new Node(data);
			return root;
		} else if (root.data > data) {
			root.left = insertRec(root.left, data);
		} else // (root.data< data) {
			root.right = insertRec(root.right, data);
		return root;
	}

	boolean searchNode(int data) {
		return searchNode(root, data);
	}

	boolean searchNode(Node root, int data) {
		if (root == null) {
			return false;
		} else if (root.data == data) {
			return true;
		} else if (root.data > data) {
			return searchNode(root.left, data);
		} else {
			return searchNode(root.right, data);
		}
	}

	void inOrder() {
		inOrderTraversal(root);
	}

	void inOrderTraversal(Node root) {
		if (root.left != null)
			inOrderTraversal(root.left);

		System.out.print(root.data + " ");

		if (root.right != null)
			inOrderTraversal(root.right);
	}

	void preOrder() {
		preOrderTraversal(root);
	}

	void preOrderTraversal(Node root) {
		if (root != null)
			System.out.print(root.data + " ");

		if (root.left != null)
			preOrderTraversal(root.left);

		if (root.right != null)
			preOrderTraversal(root.right);
	}

	void postOrder() {
		postOrderTraversal(root);
	}

	void postOrderTraversal(Node root) {
		if (root.right != null)
			postOrderTraversal(root.right);

		if (root != null) {
			System.out.print(root.data + " ");
		}

		if (root.left != null)
			postOrderTraversal(root.left);
	}
	
	boolean isTreeBalanced() {
		return isTreeBalancedRec(root);
	}
	
	/* Tree is balanced when - 
	 * 1> Left sub-tree is balanced.
	 * 2> Right sub-tree is balanced.
	 * 3> Absolute(Height of left tree - height of right tree) of height difference is not greater than 1. 
	*/
	boolean isTreeBalancedRec(Node root) {
		if(root==null) {
			return true;
		} else{
			int heightL = heightOfTree(root.left);
			int heightR = heightOfTree(root.right);
			
			boolean isHeightDifferenceLessThanOne = false;
			if(Math.abs(heightL-heightR)<=1) {
				isHeightDifferenceLessThanOne = true;
			}
			boolean isLeftTreeBalanced = isTreeBalancedRec(root.left);
			boolean isRightTreeBalanced = isTreeBalancedRec(root.right);
			
			if(isHeightDifferenceLessThanOne && isLeftTreeBalanced && isRightTreeBalanced) {
				return true;
			}
			
			return false;
		}
	}

	int heightOfTree() {
		return heightOfTree(root);
	}

	int heightOfTree(Node root) {
		if (root == null) {
			return 0;
		} else {
			return (1 + Math.max(heightOfTree(root.left), heightOfTree(root.right)));
		}
	}
	
	int minValue(Node root) {
		int minv = root.data;
		while (root.left != null) {
			minv = root.left.data;
			root = root.left;
		}
		return minv;
	}

	// Driver Program to test above functions
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		tree.insert(100);
		tree.insert(80);
		tree.insert(60);
		tree.insert(200);
		tree.insert(150);
		tree.insert(175);
		
		System.out.println();

		System.out.println("Height of tree: " + tree.heightOfTree());
		
		System.out.println("Is tree balanced? " + tree.isTreeBalanced());

		System.out.println("Search node:100 " + tree.searchNode(100));

		System.out.println("Inorder traversal of the given tree");
		tree.inOrder();

		System.out.println("PreOrder traversal of the given tree");
		tree.preOrder();

		System.out.println();

		System.out.println("PostOrder traversal of the given tree");
		tree.postOrder();
	}
}