# Kruskal to find mst of a complete graph
from random import uniform

class Graph(object):
	"""Randomly weighted complete graph"""
	def __init__(self, num):
		"""
		n: number of nodes in the graph
		"""
		self.num = num
		self.nodes = range(num)
		self.edges = []
		self.weights = [[0 for i in range(num)] for j in range(num)]

	def add_edge(self, u, v):
		self.edges.extend([(u, v), (v, u)])
		self.weights[u][v] = uniform(0, 1)
		self.weights[v][u] = self.weights[u][v]

	def assign_random_weights(self):
		for i in range(n-1):
			for j in range(i+1, n):
				self.add_edge(i, j)


class Union_Find(object):
	"""Union Find use Directed Forest Representation"""
	def __init__(self, nodes):
		self.n = len(nodes)
		self.nodes = nodes
		self.rank = [0 for i in range(self.n)]
		self.parent = [0 for i in range(self.n)]

	def make_set(self, x):
		self.parent[x] = x
		self.rank[x] = 0

	def find_set(self, x):
		if x != self.parent[x]:
			self.parent[x] = self.find_set(self.parent[x])
		return self.parent[x]

	def union(self, x, y):
		xroot = self.find_set(x)
		yroot = self.find_set(y)
		if self.rank[xroot] > self.rank[yroot]:
			self.parent[yroot] = xroot
		else:
			self.parent[xroot] = yroot
		if self.rank[xroot] == self.rank[yroot]:
			self.rank[yroot] += 1


def quick_sort(E, W, lo, hi):
	"""Sort edges in increasing order of edges weights
	E: a list of edges representated by tuple
	W: weight matrix stores all edges weights
	"""
	if lo < hi:
		p = partition(E, W, lo, hi)
		quick_sort(E, W, lo, p-1)
		quick_sort(E, W, p+1, hi)

def partition(E, W, lo, hi):
	pivot = E[hi]
	pivot_weight = W[pivot[0]][pivot[1]]
	i = lo
	for j in range(lo, hi):
		weight = W[E[j][0]][E[j][1]]
		if weight <= pivot_weight:
			E[i], E[j] = E[j], E[i]
			i += 1
	E[i], E[hi] = E[hi], E[i]
	return i

def kruskal_mst(G):
	V, E, W = G.nodes, G.edges, G.weights
	uf = Union_Find(V)
	for v in V:
		uf.make_set(v)
	# sort the edges in E in increasing order of edge weights:
	quick_sort(E, W, 0, len(E)-1)

	A = set()
	for (u, v) in E:
		if uf.find_set(u) != uf.find_set(v):
			A.add((u, v))
			uf.union(u, v)
	return (A, sum([W[u][v] for (u, v) in A]))


number_of_nodes = [10, 100, 200, 500]#, 1000]
L = {}
for n in number_of_nodes:
	total_weights = 0
	for i in range(15):
		G = Graph(n)
		G.assign_random_weights()
		A, weights = kruskal_mst(G)
		total_weights += weights
	L[n] = total_weights / 15
	print 'L({0}) = {1}'.format(n, L[n])