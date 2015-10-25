from collections import deque


def markWhite(graph, x, y, mark, n) :
	D = deque()
	D.append((x, y))

	flag = "O"

	touch_boarder = False

	while D:
		top = D.popleft()
		if top[0] == 0 or top[0] == n-1 or top[1] == 0 or top[1] == n-1:
			touch_boarder = True
		# print 'top:', top
		graph[top[0]][top[1]] = mark
		# right:
		right = (top[0], top[1]+1)
		if right[1] < n:
			if graph[right[0]][right[1]] == flag:
				D.append(right)
		# down:
		down = (top[0] + 1, top[1])
		if down[0] < n:
			if graph[down[0]][down[1]] == flag:
				D.append(down)

		# up:
		up = (top[0]-1, top[1])
		if up[0] >= 0:
			if graph[up[0]][up[1]] == flag:
				D.append(up)

		# left:
		left = (top[0], top[1]-1)
		if left[1] >= 0:
			if graph[left[0]][left[1]] == flag:
				D.append(left)

	return touch_boarder


	for i in range(n):
		print graph[i]

def markBlack(graph, x, y, mark, n) :
	D = deque()
	D.append((x, y))

	flag = "X"

	while D:
		top = D.popleft()
		graph[top[0]][top[1]] = mark
		# right:
		right = (top[0], top[1]+1)
		if right[1] < n:
			if graph[right[0]][right[1]] == flag:
				D.append(right)
		# down:
		down = (top[0] + 1, top[1])
		if down[0] < n:
			if graph[down[0]][down[1]] == flag:
				D.append(down)

		# up:
		up = (top[0]-1, top[1])
		if up[0] >= 0:
			if graph[up[0]][up[1]] == flag:
				D.append(up)

		# left:
		left = (top[0], top[1]-1)
		if left[1] >= 0:
			if graph[left[0]][left[1]] == flag:
				D.append(left)

		# lu:
		lu = (top[0]-1, top[1]-1)
		if lu[0] >= 0 and lu[1] >= 0:
			if graph[lu[0]][lu[1]] == flag:
				D.append(lu)

		# ru:
		ru = (top[0]-1, top[1]+1)
		if ru[0] >= 0 and ru[1] < n:
			if graph[ru[0]][ru[1]] == flag:
				D.append(ru)

		# ld:
		ld = (top[0]+1, top[1]-1)
		if ld[0] < n and ld[1] >= 0:
			if graph[ld[0]][ld[1]] == flag:
				D.append(ld)

		# rd:
		rd = (top[0] + 1, top[1] + 1)
		if rd[0] < n and rd[1] < n:
			if graph[rd[0]][rd[1]] == flag:
				D.append(rd)


t = input("")

for i in range(t):
	n = input("")
	m = input("")

	graph = []
	for j in range(n):
		line =  raw_input("")
		graph.append(list(line))

	black = 0
	white = 0

	mark = 1

	for i in range(n):
		for j in range(n):
			# print i, j
			ch = graph[i][j]
			if ch == mark:
				continue
			else:
				if ch == 'O':
					white += 1
					touch_boarder = markWhite(graph, i, j, mark, n)
					if touch_boarder:
						white -= 1
				else:
					black += 1
					markBlack(graph, i, j, mark, n)

	# print black, white

	ans = (black) - (white)

	print ans

		