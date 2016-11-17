with open('README.md', 'r') as fi, open('output.md', 'w') as fo:
	fi.readline()
	for i in xrange(50):
		line = '{}. '.format(i+1) + fi.readline()
		fo.write(line)