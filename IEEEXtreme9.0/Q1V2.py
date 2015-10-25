def calculate(num, length, counter):
	#print num, length
	if num == length:
		return counter
	else:
		counter += 1
		return calculate(length, len(str(length)), counter)

line = raw_input("")
while line != "END":
	ans = 0
	if line.find(".") != -1:
		num = float(line)
		length = len(line) - 1
	else:
		num = int(line)
		length = len(line)
		ans = calculate(num, length, 1)
	print 'ans =', ans
	line = raw_input("")

