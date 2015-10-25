

n = input("")

for day in range(n):
	line  = raw_input("")
	arr = line.split(" ")
	num = [int(x) for x in arr]
	s,m,r,b = num[0], num[1], num[2], num[3]
	# calculate:

	if num[1:].count(0) >= 2:
		print 0
	else:
		lst = [m, r, b]
		lst.sort()
		min_img = lst[0]
		max_ing = lst[2]

		if max_ing > lst[0] + lst[1]:
			right = lst[0] + lst[1]
		else:
			right = max_ing + (lst[0] - (max_ing - lst[1])) // 2

		# sum_ing = m + r + b
		# right = min(max_ing, sum_ing - max_ing)

		ans = min(s, right)

		print ans
