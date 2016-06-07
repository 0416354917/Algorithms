package graph;

import java.util.List;

public interface Graph {

	public List<Node> nodes();

	public List<Edge> edges();

	public void addEdge(Node u, Node v);

	public void removeEdge(Node u, Node v);

	public void setWeight(Edge e, double w);

}
