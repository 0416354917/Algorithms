import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Hashtable;

public class MST {
	/***********************************************************************
	 * Inner classes : (1) MinHeap builds the min-heap and maintains the
	 * min-heap-property (2) Each instance of Node is used to represent a node 1
	 * in the min-heap.
	 **********************************************************************/
	private static class MinHeap {
		// build a min-heap on an array of comparable objects
		public static void build(Comparable[] array, int size) {
			for (int i = (size - 1) / 2; i >= 0; i--)
				min_heapify(array, i, size);
		}

		/***********************************************************************
		 * Helper functions to restore the heap invariant.
		 **********************************************************************/
		// min-heapify which maintains the min-heapify-property
		public static void min_heapify(Comparable[] array, int i, int size) {
			int l = left(i);
			int r = right(i);
			int smallest = -1;
			if (l < size && less(array[l], array[i]))
				smallest = l;
			else
				smallest = i;
			if (r < size && less(array[r], array[smallest]))
				smallest = r;
			if (smallest != i) {
				exch(array, i, smallest);
				min_heapify(array, smallest, size);
			}
		}

		/***********************************************************************
		 * Helper functions for comparisons and swaps.
		 **********************************************************************/
		private static int parent(int i) {
			return (i - 1) / 2;

		}

		private static int left(int i) {
			return 2 * i + 1;
		}

		private static int right(int i) {
			return 2 * i + 2;
		}

		private static boolean less(Comparable v, Comparable w) {
			return (v.compareTo(w) < 0);
		}

		private static void exch(Object[] arr, int i, int j) {
			Object swap = arr[i];
			arr[i] = arr[j];
			arr[j] = swap;
		}

		// returns -1 if obj does not exist, else return the index of obj.
		public static int contains(Comparable[] arr, Object obj, int heapSize) {
			for (int i = 0; i < heapSize; i++) {
				if (arr[i].equals(obj))
					return i;
			}
			return -1;
		}
	}

	// node in the min-heap
	private class Node implements Comparable {
		public int id;
		public int pi;
		public double key;

		public Node(int id, int pi, double key) {
			this.id = id;
			this.pi = pi;
			this.key = key;

		}

		@Override
		public int compareTo(Object anotherNode) throws ClassCastException {
			final int SMALL = -1;
			final int EQUAL = 0;
			final int LARGE = 1;
			if (!(anotherNode instanceof Node))
				throw new ClassCastException("A Node object expected!");
			if (this == anotherNode)
				return EQUAL;
			double anotherNodeKey = ((Node) anotherNode).key;
			if (this.key < anotherNodeKey)
				return SMALL;
			if (this.key > anotherNodeKey)
				return LARGE;
			return EQUAL;
		}

		@Override
		public boolean equals(Object another) {
			// check for self-comparison
			if (this == another)
				return true;
			if (!(another instanceof Node))
				return false;
			// cast to native object is now safe
			Node that = (Node) another;
			// now a proper field-by-field evaluation can be made
			if (this.id == that.id)
				return true;
			else
				return false;
		}

		@Override

		public String toString() {
			return this.id + "";
		}
	}

	/***********************************************************************
	 * Class members of MST
	 **********************************************************************/
	// We use a hash table to map the nodes in the original graph and the nodes
	// in the min-heap.
	private Hashtable<Integer, Node> idToNode = new Hashtable<Integer, Node>();
	// the weight of a minimum spanning tree
	private double mstWeight = 0;
	// the minimum spanning tree (you may not need this if you
	// do not want to see the tree structure.)
	private double[][] mst;

	// find the adjacent nodes of the node with ID = id
	private Object[] adjacents(double[][] graph, int id) {
		ArrayList<Node> adjs = new ArrayList<Node>();
		for (int i = 0; i < graph.length; i++) {
			if ((i != id) && (-1 != graph[id][i]))
				adjs.add(idToNode.get(i));
		}
		return adjs.toArray();
	}

	// extract the root of the min-heap (the node with minimum key)
	private Node extract_min(Node[] array, int heapSize) {
		// exchange the root with the last element;
		MinHeap.exch(array, 0, heapSize - 1);
		Node minKeyNode = array[heapSize - 1];
		// delete the minimum node
		array[heapSize - 1] = null;
		// return the node with minimum key

		return minKeyNode;
	}

	public double prim(double[][] graph) {
		int graphSize = graph.length;
		// use an equal size matrix to represent the minimum spanning tree
		// and initialise all the elements to -1;
		this.mst = new double[graphSize][graphSize];
		for (int i = 0; i < graphSize; i++)
			for (int j = 0; j < graphSize; j++)
				this.mst[i][j] = -1;
		Object[] array = new Node[graphSize];
		for (int i = 0; i < graphSize; i++) {
			if (0 == i)
				array[i] = new Node(i, -1, 0);
			else
				array[i] = new Node(i, -1, Double.MAX_VALUE);
			idToNode.put(i, (Node) array[i]);
		}
		int heapSize = graphSize;
		// build a min-heap
		MinHeap.build((Node[]) array, heapSize);
		while ((heapSize = size(array)) > 0) {
			Node minKeyNode = extract_min((Node[]) array, heapSize);
			--heapSize;
			if (0 != minKeyNode.id) {// not the root node
				this.mst[minKeyNode.pi][minKeyNode.id] = minKeyNode.key;
				this.mst[minKeyNode.id][minKeyNode.pi] = minKeyNode.key;
			}
			this.mstWeight += minKeyNode.key;
			Object[] adjs = adjacents(graph, minKeyNode.id);

			for (Object nd : adjs) {
				Node node = (Node) nd;
				int nodeIndex = MinHeap.contains((Node[]) array, nd, heapSize);
				if ((-1 != nodeIndex) && (graph[minKeyNode.id][node.id] < node.key)) {
					node.key = graph[minKeyNode.id][node.id];
					node.pi = minKeyNode.id;
				}
			}
			MinHeap.build((Node[]) array, heapSize);
		}
		return this.mstWeight;
	}

	// randomly generate the undirected complete graph using a symmetric matrix
	public static void generate(double[][] graph) {
		int size = graph.length;
		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				if (i == j)
					graph[i][j] = 0;
				else {
					graph[i][j] = Math.random();
					graph[j][i] = graph[i][j];
				}
			}
		}
	}

	public static void main(String[] args) {
		int sizes[] = { 10, 50, 100, 150, 200 };
		// int sizes[] = { 50, 100, 150, 200, 250 };
		for (int i = 0; i < sizes.length; i++) {
			double[] averageWeight = new double[5];
			long[] averageRunTime = new long[5];

			int size = sizes[i];
			for (int j = 0; j < 100; j++) {
				double[][] graph = new double[size][size];
				// randomly generate graph
				MST.generate(graph);
				MST mst = new MST();
				long startTime = System.nanoTime();
				averageWeight[i] += mst.prim(graph) / 100;
				long endTime = System.nanoTime();
				averageRunTime[i] += ((endTime - startTime) / 100);
			}
			System.out.println("Size : " + size + "; Average Run Time : " + averageRunTime[i]
					+ " ns ; Average Weight : " + averageWeight[i]);
		}
	}

	/***********************************************************************
	 * Helper functions for get sizes and print graphs.
	 **********************************************************************/
	// return the size of the min-heap
	private int size(Object[] array) {
		int size = 0;
		for (int i = 0; i < array.length; i++) {
			if (null != array[i])
				size++;
		}
		return size;
	}

	// print a graph
	public static void print(double[][] graph) {
		int r = graph.length;
		int c = graph[0].length;

		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if ((c - 1) == j)
					System.out.print(df.format(graph[i][j]) + "\n");
				else
					System.out.print(df.format(graph[i][j]) + ", ");
			}
		}
	}
}
