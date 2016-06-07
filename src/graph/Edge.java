package graph;

public class Edge {

	Node start;
	Node end;
	double weight;

	public Edge(Node u, Node v) {
		this.start = u;
		this.end = v;
		this.weight = .0;
	}

	public Edge(Node u, Node v, double weight) {
		this.start = u;
		this.end = v;
		this.weight = weight;
	}

	public void setWeight(double newWeight) {
		this.weight = newWeight;
	}

}
