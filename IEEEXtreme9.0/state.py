line = raw_input("")
N = int(line.split(" ")[0])
M = int(line.split(" ")[1])

states = range(N)
inputs = [chr(i) for i in range(65, 65 + M)]
outputs = [0 for i in range(N)]

# TRANSITIONS:
trans_table = {}
for state in states:
	line = raw_input("")
	arr = line.split(" ")
	outputs[state] = int(arr[0])
	P = int(arr[1])
	arr = arr[2:]
	dic = {}
	trans_table[state] = dic
	for trans in arr:
		first = trans.split("/")[0]
		second = trans.split("/")[0]
		a = first.split(",")
		# for b in a:
		# 	c = 









line = raw_input("")
T = int(line.split(" ")[0])
I = int(line.split(" ")[1])


for i in range(T):
	line = raw_input("")
	arr = [int(e) for e in line.split(" ")]
