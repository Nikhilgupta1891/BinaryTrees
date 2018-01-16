import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

// Depth Frist Search
public class Graph {

	private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();

	public static void main(String[] args) {
		Graph graph = new Graph();

		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(2, 5);

		System.out.println(graph.hasPathDFS(1,5));
	}

	public class Node {
		int nodeID;
		public LinkedList<Node> adjecentNodes = new LinkedList<>();

		private Node(int nodeID) {
			this.nodeID = nodeID;
		}
	}

	private Node getNode(int nodeID) {
		return nodeLookup.get(nodeID);
	}

	public void addEdge(int sourceID, int destinationID) {
		Node sourceNode;
		Node destinationNode;
		
		if(getNode(sourceID)==null){
			sourceNode = new Node(sourceID);
		} else 
			sourceNode = getNode(sourceID);
		
		if(getNode(destinationID)==null) {
			destinationNode = new Node(destinationID);
		} else
			destinationNode = getNode(destinationID);
		
		LinkedList<Node> sourceLinkedList = sourceNode.adjecentNodes;
		sourceLinkedList.add(destinationNode);
		
		System.out.println("sourceNode.nodeID: " + sourceNode.nodeID);
		for (Node child : sourceLinkedList) {
			System.out.println("child.nodeID: " + child.nodeID);
		}
		System.out.println();
		
		nodeLookup.put(sourceID, sourceNode);
		nodeLookup.put(destinationID, destinationNode);
	}

	public boolean hasPathDFS(int sourceID, int destinationID) {
		Node sourceNode = getNode(sourceID);
		Node destinationNode = getNode(destinationID);

		HashSet<Integer> visitedNodes = new HashSet<Integer>();
		return hasPathDFS(sourceNode, destinationNode, visitedNodes);
	}

	private boolean hasPathDFS(Node sourceNode, Node destinationNode, HashSet<Integer> visitedNodes) {
		if (visitedNodes.contains(sourceNode.nodeID)) {
			return false;
		}
		visitedNodes.add(sourceNode.nodeID);
		if (sourceNode == destinationNode) {
			return true;
		}
		for (Node child : sourceNode.adjecentNodes) {
			if (hasPathDFS(child, destinationNode, visitedNodes)) {
				return true;
			}
		}
		return false;
	}
}