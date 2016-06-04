def catlan(n):
	if n == 0:
		return 1
	else:
		return catlan(n-1) * (4*n - 2) / (n + 1)

while True:
	line = raw_input("") 
	ways = int(line)
	n = 3
	while catlan(n-2) != ways:
		n += 1
	print n