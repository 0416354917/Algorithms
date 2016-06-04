def encode62(x):
	res = ""
	mul =  0
	while x > 0:
		res = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"[x % 62] + res
		x /= 62
	return res


base_url = raw_input("")
n = input("")

base_url_backup = base_url


for i in range(n):
	base_url = base_url_backup
	
	target_url = raw_input("")
	if len(target_url) < len(base_url):
		base_url = base_url[:len(target_url)]
	else:
		while len(base_url) < len(target_url):
			base_url += base_url[:(len(target_url) - len(base_url))]


	# print "+++++++++"
	# print base_url
	# print target_url
	# print "+++++++++"

	target = [ord(ch) for ch in target_url]
	base = [ord(ch) for ch in base_url]

	xor_res = [target[index] ^ base[index] for index in range(len(target))]

	last8bytes = xor_res[-8:]

	#print 'last8bytes:', last8bytes

	hexstr = str(hex(last8bytes[0]))[2:]
	while len(hexstr) != 2:
		hexstr = "0" + hexstr
	hexstr = "0x" + hexstr

	for j in range(1, 8):
		tmp = str(hex(last8bytes[j])[2:])
		while len(tmp) != 2:
			tmp = "0" + tmp
		hexstr += tmp

	#print 'hexstr: ' + hexstr

	res_int = int(hexstr, base=16)
	base62str = encode62(res_int)

	ans = base_url_backup + "/" + base62str
	print ans







