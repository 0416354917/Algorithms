t = input("")

for i in range(t):
	line = raw_input("")
	arr = line.split(" ")

	#nums = [int(x) for x in arr]
	
	switches = int(arr[0])
	gre = int(arr[1])

	flag = {}


	# flag = [0 for j in range(switches + 1)]

	# # primes = nums[2:]

	ans = 0
	for p in arr[2: ]:
		prime = int(p)
		pos = prime
		while pos <= switches:
			if pos not in flag:
				flag[pos] = 1
				ans += 1
			else:
				if flag[pos] == 0:
					flag[pos] = 1
					ans += 1
				else:
					flag[pos] = 0
					ans -= 1
			pos += prime
	print ans

