N = input("")

# build board:
board = [['-' for i in range(N)] for j in range(N)]
special = {}

for i in range(N):
	line = raw_input("")
	for index in range(len(line)):
		ch = line[index]
		board[i][index] = ch
		if ch not in special:
			special[ch] = [(i, index)]
		else:
			special[ch].append((i, index))

# print:
# print board
# print special
location = {} # loc -> (x, y)

counter = 1
point = (N-1, 0)
while counter != 26:
	location[counter] = point
	x = point[0]
	y = point[1]	

	if counter % N == 0:
		x -= 1
	else:
		if (counter/N) % 2 == 0:
			y += 1
		else:
			y -= 1


	point = (x, y)
	counter += 1

# print location


M = input("")

loc = [0 for i in range(M)]

while True:
	for turn in range(M):
		x = input("")
		y = input("")
		# print x, y
		z = x + y
		loc[turn] += z

		a, b = location[loc[turn]]
		if board[a][b] != '-':
			spe_ch = board[a][b]
			lst = special[spe_ch]
			if (a, b)


		# print loc

# print loc







