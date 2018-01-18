
/*
 * Graph is a data structure that consists of following two components:
1. A finite set of vertices also called as nodes.
2. A finite set of ordered pair of the form (u, v) called as edge. 
The pair is ordered because (u, v) is not same as (v, u) in case of directed graph(di-graph). 
The pair of form (u, v) indicates that there is an edge from vertex u to vertex v. 
The edges may contain weight/value/cost.

Graphs are used to represent many real life applications: 
Graphs are used to represent networks. 
The networks may include paths in a city or telephone network or circuit network. G
raphs are also used in social networks like linkedIn, facebook. 
For example, in facebook, each person is represented with a vertex(or node). 
Each node is a structure and contains information like person id, name, gender and locale.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

// Depth First Search and Breadth first search.
// Youtube link - https://www.youtube.com/watch?v=zaBhtODEL0w
public class Graph_BFS_DFS {

	private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();

	public static void main(String[] args) {
		Graph_BFS_DFS graph = new Graph_BFS_DFS();

		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 2);
		graph.addEdge(2, 5);

		System.out.println("Check path from DFS: " + graph.hasPathDFS(1, 5));
		System.out.println("Check path from BFS: " + graph.hasPathBFS(1, 5));
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

	// Nodes - sourceNode and destinationNodes are called vertices.
	// sourceNode to DestinationNode, this path, is called as an Edge.
	public void addEdge(int sourceID, int destinationID) {
		Node sourceNode;
		Node destinationNode;

		if (getNode(sourceID) == null) {
			sourceNode = new Node(sourceID);
			nodeLookup.put(sourceID, sourceNode);
		} else {
			sourceNode = getNode(sourceID);
		}

		if (getNode(destinationID) == null) {
			destinationNode = new Node(destinationID);
			nodeLookup.put(destinationID, destinationNode);
		} else {
			destinationNode = getNode(destinationID);
		}

		LinkedList<Node> sourceLinkedList = sourceNode.adjecentNodes;
		sourceLinkedList.add(destinationNode);

		System.out.println("sourceNode.nodeID: " + sourceNode.nodeID);
		for (Node child : sourceLinkedList) {
			System.out.println("child.nodeID: " + child.nodeID);
		}
		System.out.println();

	}

	public boolean hasPathDFS(int sourceID, int destinationID) {
		Node sourceNode = getNode(sourceID);
		Node destinationNode = getNode(destinationID);

		/*
		 * If we don’t mark visited vertices, then the node will be processed
		 * again and it will become a non-terminating process.
		 */
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

	public boolean hasPathBFS(int sourceID, int destinationID) {
		Node source = getNode(sourceID);
		Node destination = getNode(destinationID);

		LinkedList<Node> nodesToVisit = new LinkedList<>();
		nodesToVisit.add(source);

		HashSet<Integer> nodesAlreadyVisited = new HashSet<>();

		while (!nodesToVisit.isEmpty()) {
			Node node = nodesToVisit.remove();
			if (node == destination) {
				return true;
			}

			if (nodesAlreadyVisited.contains(node.nodeID)) {
				continue;
			} else {
				nodesAlreadyVisited.add(node.nodeID);
			}

			for (Node child : node.adjecentNodes) {
				nodesToVisit.add(child);
			}
		}
		return false;
	}
}