import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Node newNode = new Node(5);

		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			newNode.insert(sc.nextInt());
		}
		
		System.out.println(newNode.navigateToThatNode(1, newNode, null).data);

		// System.out.println("inOrderTraversal");
		// newNode.inOrderTraversal();
		//
		// System.out.println();

		System.out.println("preOrderTraversal");
		newNode.preOrderTraversal();

		// System.out.println();
		//
		// System.out.println("postOrderTraversal");
		// newNode.postOrderTraversal();

		System.out.println("Height of tree: ");
		System.out.println(newNode.getHeight(newNode));
	}
}