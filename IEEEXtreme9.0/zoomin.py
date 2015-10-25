# Enter your code here. Read input from STDIN. Print output to STDOUT

# The "zoomed-in" version of an empty string is m blank lines 
# (i.e. lines with only a newline character).

n = input("")
m = input("")
k = input("")

dic = {}
for i in range(k):
    key = raw_input("")
    value = []
    for j in range(m):
        line = raw_input("")
        value.append(list(line))
    dic[key] = value

x = input("")
# print x
# for ch in dic:
#     print ch
#     print dic[ch]

for i in range(x):
    line = raw_input("")

    # print 'line =', line
    # compute:
    ans = []
    for ch in line:
        ans.append(dic[ch])


    # print "===="
    # print ans
    # print "===="

    # print:
    output = []
    for j in range(m):
        single_line = ""
        for k in range(len(ans)):
            single_line += "".join(ans[k][j])
        # print 'single_line:', single_line
        output.append(single_line)

        # print output

    for line_data in output:
        print line_data



