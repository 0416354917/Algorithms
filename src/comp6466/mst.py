## Kruskal Algorithm to find the minimal spanning tree of a complete graph
## author: Jun Chen u5485230

import time
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
        """Add an edge in the graph with two vertices u and v. Assign a random 
        weight to the edge

        u: a vode
        v: a node
        """
        self.edges.extend([(u, v), (v, u)])
        self.weights[u][v] = uniform(0, 1)
        self.weights[v][u] = self.weights[u][v]

    def add_edges(self):
        """Add edges to generate the undirected complete graph
        """
        for i in range(n-1):
            for j in range(i+1, n):
                self.add_edge(i, j)


class Union_Find(object):
    """Union Find use Directed Forest Representation"""
    def __init__(self, nodes):
        """
        nodes: a list of objects
        """
        self.n = len(nodes)
        self.nodes = nodes
        self.rank = [0 for i in range(self.n)]
        self.parent = [0 for i in range(self.n)]

    def make_set(self, x):
        """Make a set for an object
        
        x: an object
        """
        self.parent[x] = x
        self.rank[x] = 0

    def find_set(self, x):
        """Find the set the object x is in
        
        x: an object
        """
        if x != self.parent[x]:
            self.parent[x] = self.find_set(self.parent[x])
        return self.parent[x]

    def union(self, x, y):
        """Unite sets where x and y are in into one set
        
        x: an object
        y: an object
        """
        xroot = self.find_set(x)
        yroot = self.find_set(y)
        if self.rank[xroot] > self.rank[yroot]:
            self.parent[yroot] = xroot
        else:
            self.parent[xroot] = yroot
        if self.rank[xroot] == self.rank[yroot]:
            self.rank[yroot] += 1


def quick_sort(E, W, lo, hi):
    """Quick Sort edges in increasing order of edges weights
    
    E: a list of edges representated by tuples
    W: weight matrix stores all edges' weights
    lo: lower position of the sorting sequence
    hi: higher position of the sorting sequence
    """
    if lo < hi:
        p = partition(E, W, lo, hi)
        quick_sort(E, W, lo, p-1)
        quick_sort(E, W, p+1, hi)

def partition(E, W, lo, hi):
    """Partition the input sequence into 2 subsequences using an pivot
    
    E: input sequence
    W: an array of weights of edges
    lo: lower position of the sorting sequence
    hi: higher position of the sorting sequence
    """
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
    """Kruskal algorithm to find the minimal spanning tree of G
    
    G: a graph
    """
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


number_of_nodes = [10, 100, 200, 500, 1000]
L = {} # expected weighted sum
T = {} # expected running time
for n in number_of_nodes:
    total_weights = 0
    total_time = 0
    for i in range(15):
        G = Graph(n)
        G.add_edges()
        start_time = time.time()
        A, weights = kruskal_mst(G)
        total_time += time.time() - start_time
        total_weights += weights
    L[n] = total_weights / 15
    T[n] = total_time / 15
    print 'Size: {0}, Expected weighted sum: {1}, Expected running time: {2}s.' \
    .format(n, L[n], T[n])