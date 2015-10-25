from collections import Counter

def isDicStr(words, dic_str):
	is_dic_str = True

	ans = 0

	counter = Counter(dic_str)
	for word in words:
		word_counter = Counter(word)
		for ch in word_counter:
			if ch not in counter:
				ans += word_counter[ch]
				counter[ch] = word_counter[ch]
				is_dic_str = False
			elif counter[ch] < word_counter[ch]:
				ans += word_counter[ch] - counter[ch]
				counter[ch] = word_counter[ch]
				is_dic_str = False

	return (is_dic_str, ans)

def isPerfect(words, dic_str):
	dic_counter = Counter(dic_str)

	is_perfect = False
	max_counter = {}
	for word in words:
		word_counter = Counter(word)
		for ch in word_counter:
			if ch not in max_counter:
				max_counter[ch] = word_counter[ch]
			else:
				max_counter[ch] = max(max_counter[ch], word_counter[ch])
	for ch in max_counter:
		if max_counter[ch] != dic_counter[ch]:
			return "No"
	return "Yes"





T = input("")

for i in range(T):
	line = raw_input("")
	D = int(line.split(" ")[0])
	S = int(line.split(" ")[1])

	words = set()
	for j in range(D):
		line = raw_input("")
		words.add(line)

	dic_strs = []
	for j in range(S):
		line = raw_input("")
		dic_strs.append(line)


	for cand in dic_strs:
		flag, ans = isDicStr(words, cand)
		if flag:
			print "Yes", isPerfect(words, cand)
		else:
			print "No", ans





