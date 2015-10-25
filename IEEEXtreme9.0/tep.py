N = int(raw_input(""))


for i in range(N):
	M = int(raw_input(""))
	# print M
	time_money = {}
	end_start = {}

	start, end = 48, 0

	for j in range(M):
		line = raw_input("")
		print line
		arr = line.split(" ")
		num = [int(x) for x in arr]

		x, y = num[0], num[1]
		money = num[2]

		time_money[(x, y)] = money

		start = min(x, start)
		end = max(y, end)

	dp = [[0 for a in range(end+1)] for b in range(end+1)]
	for tup in time_money:
		dp[tup[0]][tup[1]] = time_money[tup]

	# dp[0][end+1] = ?
	for line in dp:
		print line
	print '=='
	# print dp




	# end = end_start.keys()
	# end.sort()
	
	# ans = [0 for k in range(end[-1] + 1)]
	# for endtime in end:
	# 	starttime = end_start[endtime]
		

		

		# order by starting time:
		# dic[] = avg





