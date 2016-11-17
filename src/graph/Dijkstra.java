package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Dijkstra {

	class Vertex implements Comparable<Vertex> {

		char label;
		int d;
		Vertex parent;

		Vertex(char label) {
			this.label = label;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.d - o.d;
		}
	}

	class Edge {
		Vertex u, v;
		int weight;

		Edge(Vertex u, Vertex v, int weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;
		}
	}

	public void dijkstara(Set<Vertex> vertices, Set<Edge> edges, Vertex s) {
		s.d = 0;
		s.parent = null;
		for (Vertex v : vertices) {
			if (v != s) {
				v.d = Integer.MAX_VALUE;
				v.parent = null;
			}
		}

		List<Vertex> S = new ArrayList<>();
		Queue<Vertex> Q = new PriorityQueue<>(vertices);
		while (!Q.isEmpty()) {
			Vertex u = Q.remove();
			S.add(u);
			for (Edge e : edges) {
				if (e.u == u) {
					relax(u, e.v, edges);
				}
			}
		}

		for (Vertex v : S) {
			System.out.println(v.label + ", dist: " + v.d);
		}

	}

	public void relax(Vertex u, Vertex v, Set<Edge> edges) {
		int w = 0;
		for (Edge e : edges) {
			if (e.u == u && e.v == v) {
				w = e.weight;
				break;
			}
		}

		if (v.d > u.d + w) {
			v.d = u.d + w;
			v.parent = u;
		}
	}

	public static void main(String[] args) {
		Dijkstra sp = new Dijkstra();

		Vertex a = sp.new Vertex('a');
		Vertex b = sp.new Vertex('b');
		Vertex c = sp.new Vertex('c');
		Vertex e = sp.new Vertex('e');
		Vertex f = sp.new Vertex('f');

		Edge ab = sp.new Edge(a, b, 8);
		Edge ae = sp.new Edge(a, e, 9);
		Edge af = sp.new Edge(a, f, 4);
		Edge bc = sp.new Edge(b, c, 1);
		Edge cb = sp.new Edge(c, b, 2);
		Edge ce = sp.new Edge(c, e, 3);
		Edge ec = sp.new Edge(e, c, 2);
		Edge ef = sp.new Edge(e, f, 7);
		Edge fc = sp.new Edge(f, c, 1);

		Set<Vertex> vertices = new HashSet<>();
		Set<Edge> edges = new HashSet<>();

		vertices.add(a);
		vertices.add(b);
		vertices.add(c);
		vertices.add(e);
		vertices.add(f);

		edges.add(ab);
		edges.add(ae);
		edges.add(af);
		edges.add(bc);
		edges.add(cb);
		edges.add(ce);
		edges.add(ec);
		edges.add(ef);
		edges.add(fc);

		sp.dijkstara(vertices, edges, a);

	}

}
