package comp6466;

/**
 * Compilation: javac MST.java
 * Execution: java MST
 * 
 * @author Danyang Li
 */
import java.util.ArrayList;
import java.util.HashSet;

/**
 * A pair of node (from , to) represents an edge.
 *
 */
class Edge {
	int from, to;

	public Edge(int from, int to) {
		this.from = from;
		this.to = to;
	}
}

/**
 * Fully-connected undirected graph.
 *
 */
class Graph {
	int size;
	int[] nodes;
	double[][] weights;

	ArrayList<Edge> edges;

	public Graph(int size) {
		this.size = size;
		nodes = new int[size];
		edges = new ArrayList<Edge>();
		weights = new double[size][size];
		initialiseGraph();
	}

	public void initialiseGraph() {
		for (int i = 0; i < size; i++) {
			nodes[i] = i;
		}

		/**
		 * Change the multiplier here when the upper bound of the uniform
		 * distribution needs to be changed.
		 */
		double multiplier = 0.5;
		assignRandomWeights(multiplier);
	}

	public void assignRandomWeights(double multiplier) {
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				weights[i][j] = Math.random() * multiplier;
				edges.add(new Edge(i, j));
				weights[j][i] = weights[i][j];
				edges.add(new Edge(j, i));
			}
		}
	}
}

/**
 * Union-Find with both heuristics.
 *
 */
class UnionFind {

	int size = 0;

	int[] elements;
	int[] parents;
	int[] ranks;

	public UnionFind(int n) {
		size = n;
		elements = new int[size];
		parents = new int[size];
		ranks = new int[size];
	}

	void makeSet(int x) {
		elements[x] = x;
		parents[x] = x;
		ranks[x] = 0;
	}

	int findSet(int x) {
		if (x != parents[x]) {
			parents[x] = findSet(parents[x]);
		}
		return parents[x];
	}

	void union(int x, int y) {
		int xroot = findSet(x);
		int yroot = findSet(y);
		if (ranks[xroot] > ranks[yroot]) {
			parents[yroot] = xroot;
		} else {
			parents[xroot] = yroot;
		}

		if (ranks[xroot] == ranks[yroot]) {
			ranks[yroot]++;
		}
	}

}

public class MST {

	public static void swap(Edge e1, Edge e2) {
		int tmpFrom = e1.from;
		int tmpTo = e1.to;
		e1.from = e2.from;
		e1.to = e2.to;
		e2.from = tmpFrom;
		e2.to = tmpTo;
	}

	public static int partition(ArrayList<Edge> edges, double[][] weights, int lo, int hi) {
		Edge pivot = edges.get(hi);
		double pivotWeight = weights[pivot.from][pivot.to];
		int i = lo, j = lo;
		while (j < hi) {
			double w = weights[edges.get(j).from][edges.get(j).to];
			if (w <= pivotWeight) {
				swap(edges.get(i), edges.get(j));
				i++;
			}
			j++;
		}
		swap(edges.get(i), edges.get(hi));
		return i;
	}

	public static void quickSort(ArrayList<Edge> edges, double[][] weights, int lo, int hi) {
		if (lo < hi) {
			int p = partition(edges, weights, lo, hi);
			quickSort(edges, weights, lo, p - 1);
			quickSort(edges, weights, p + 1, hi);
		}
	}

	public static double kruskal(Graph G) {
		int[] nodes = G.nodes;
		ArrayList<Edge> edges = G.edges;
		double[][] weights = G.weights;
		UnionFind uf = new UnionFind(nodes.length);
		for (int index = 0; index < nodes.length; index++) {
			uf.makeSet(nodes[index]);
		}
		quickSort(edges, weights, 0, edges.size() - 1);

		HashSet<Edge> A = new HashSet<>();
		for (Edge e : edges) {
			if (uf.findSet(e.from) != uf.findSet(e.to)) {
				A.add(e);
				uf.union(e.from, e.to);
			}
		}

		double totalWeigths = 0;
		for (Edge e : A) {
			totalWeigths += weights[e.from][e.to];
		}

		return totalWeigths;
	}

	public static void main(String[] args) {
		int[] size = { 10, 100, 200, 500, 1000 };
		for (int index = 0; index < size.length; index++) {
			int numberOfNodes = size[index];
			double totalWeights = 0;
			long totalTime = 0;
			for (int i = 0; i < 15; i++) {
				Graph G = new Graph(numberOfNodes);

				long startTime = System.nanoTime();
				totalWeights += kruskal(G);
				long endTime = System.nanoTime();
				totalTime += (endTime - startTime);
			}
			System.out.println("Size: " + numberOfNodes + ", Expected weighted sum: " + totalWeights / 15
					+ ", Expected running time: " + totalTime / 15 + "ns.");
		}
	}

}
