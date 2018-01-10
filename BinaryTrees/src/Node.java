class Node {

	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
	}
	
	// Deletion
//	public boolean deleteNoChildNode(int value, Node node) {
//		if(node==null) {
//			return false;
//		} else {
//			if(value == node.data) {
//				return true;
//			} else {
//				// Search the node
//				Node parent = null;
//				navigateToThatNode(value, node, parent);
//				// Keep track of the parent
//				// Delete the node. 
//			}
//		}
//	}
	
	public Node navigateToThatNode(int value, Node node, Node parent) {
		if(value <= node.data) {
			parent = node;
			node = node.left;
			navigateToThatNode(value, node, parent);
		} else if(value==node.data) {
			return parent;
		} else if(value > node.data){
			parent = node;
			node = node.right;
			navigateToThatNode(value, node, parent);
		} else {
			return null;
		}
		return null;
	}

	// Insertion
	public void insert(int value) {
		if (value <= data) {
			if (left == null) {
				left = new Node(value);
			} else {
				left.insert(value);
			}
		} else {
			if (right == null) {
				right = new Node(value);
			} else {
				right.insert(value);
			}
		}
	}

	// find
	public boolean contains(int value) {
		if (value == data) {
			return true;
		} else if (value < data) {
			if (left == null) {
				return false;
			} else {
				return left.contains(value);
			}
		} else {
			if (right == null) {
				return false;
			} else {
				return right.contains(value);
			}
		}
	}
	
	// Traversal
	public void inOrderTraversal() {
		if (left != null) {
			left.inOrderTraversal();
		}
		System.out.println(data + " ");
		if (right != null) {
			right.inOrderTraversal();
		}
	}

	// Traversal
	public void preOrderTraversal() {
		System.out.println(data + " ");
		if (left != null) {
			left.preOrderTraversal();
		}
		if (right != null) {
			right.preOrderTraversal();
		}
	}

	// Traversal
	public void postOrderTraversal() {
		if (left != null) {
			left.postOrderTraversal();
		}
		if (right != null) {
			right.postOrderTraversal();
		}
		System.out.println(data + " ");
	}
	
	// Height
	public int getHeight(Node node) {
		if(node == null) {
			return 0;
		} else {
			System.out.println("Node parsing: " + node.data);
			return (1+Math.max(getHeight(node.left), getHeight(node.right)));
		}
	}
	
	
	
}