import java.util.Scanner;

/*
 * Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height.
 */

public class ArrayIntoBinaryTree {
	/*
	 Algorithm:
		1. Insert into the tree the middle element of the array.
		2. Insert (into the left subtree) the left subarray elements
		3. Insert (into the right subtree) the right subarray elements
		4. Recurse
	 */
	
	ArrayIntoBinaryTree arrayIntoBinaryTree = new ArrayIntoBinaryTree();
	
	public static void main(String[] args) {
		int[] arr = initializeArray();
		Node node = addToTree(arr, 0, arr.length);
	}
	
	// find Subarray - Use Recursion. 
	static Node addToTree(int[] arr, int first, int last) {
		// Exit condition
		if(first<last) {
			return null;
		}
		int midElement = arr[(first+last)/2];
		Node newNode = new Node(arr[midElement]);
		newNode.left = addToTree(arr, first, midElement-1);
		newNode.right = addToTree(arr, midElement+1, last);
		return newNode;
	}
	
	static int[] initializeArray() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array: ");
		int size = sc.nextInt();
		
		System.out.println("Now enter " + size + " number of elements.");
		int[] arr = new int[size];
		for(int i=0; i<size; i++) {
			arr[i] = sc.nextInt();
		}
		return arr;
	}
}