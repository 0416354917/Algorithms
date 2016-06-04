N = input("")

for i in range(N):
	line = raw_input("")
	flag = True
	i = 1
	while i <= len(line) / 2:
		if line[:i] == line[i: 2*i]:
			print i
			flag = False
			break
		i += 1

	if flag:
		print len(line)

