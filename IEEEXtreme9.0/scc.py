import itertools

def strong_connect(vertex):
    global indices, lowlinks, connected_components, index, stack
    indices[vertex] = index
    lowlinks[vertex] = index
    index += 1
    stack.append(vertex)

    for v, w in (e for e in edges if e[0] == vertex):
        if indices[w] < 0:
            strong_connect(w)
            lowlinks[v] = min(lowlinks[v], lowlinks[w])
        elif w in stack:
            lowlinks[v] = min(lowlinks[v], indices[w])

    if indices[vertex] == lowlinks[vertex]:
        connected_components.append([])
        while stack[-1] != vertex:
            connected_components[-1].append(stack.pop())
        connected_components[-1].append(stack.pop())



edges = []
# vertices = set()

line = raw_input("")
n = int(line.split(" ")[0])
m = int(line.split(" ")[1])
for i in range(n):
    line = raw_input("")
    if line == "END":
        break

    p1 = line.split(" ")[0]
    p2 = line.split(" ")[1]
    edges.append((p1, p2))
    # vertices.add(p1)
    # vertices.add(p2)

vertices = set(v for v in itertools.chain(*edges))
indices = dict((v, -1) for v in vertices)
lowlinks = [i for i in indices]
connected_components = []

index = 0
stack = []
for v in vertices:
    if indices[v] < 0:
        strong_connect(v)


sizes = [len(cc) for cc in connected_components]
sizes.sort(reverse=True)

for size in sizes:
    print size

length = len(sizes)
if length < m:
    for i in range(m - length):
        print "Does not apply!"

