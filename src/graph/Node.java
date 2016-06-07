package graph;

import java.util.ArrayList;
import java.util.List;

public class Node {

	int val;
	List<Node> neighbors;

	public Node(int x) {
		this.val = x;
		this.neighbors = new ArrayList<>();
	}

}
