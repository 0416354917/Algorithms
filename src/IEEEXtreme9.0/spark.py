N = input("")


for i in range(N):
	M = input()
	time_money = {}
	end_start = {}

	
	for j in range(M):
		line = raw_input("")
		arr = line.split(" ")
		num = [int(x) for x in arr]

		x, y = num[0], num[1]
		money = num[2]

		time_money[(x, y)] = money
		if y not in end_start:
			end_start[y] = [x]
		else:
			end_start[y].append(x)

	end = end_start.keys()
	end.sort()
	
	ans = [0 for k in range(end[-1] + 1)]
	for endtime in end:
		starttime = end_start[endtime]
		

		

		# order by starting time:
		# dic[] = avg





