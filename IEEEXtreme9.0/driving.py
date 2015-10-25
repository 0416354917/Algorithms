line = raw_input("")

K = int(line.split(" ")[0])
N = int(line.split(" ")[1])

matrix = [[0 for i in range(K)] for j in range(4)]

for row in range(N):
    line = raw_input("")
    x = int(line.split(" ")[0]) - 1
    y = int(line.split(" ")[1]) - 1
    matrix[x][y] = 1


# main alg:
level = 1
frontier = set([(0, 0)])
counter = {}
counter[(0, 0)] = 1
ans = 0
while level <= K:
    # print frontier

    new_frontier = set()
    # print frontier
    # print level

    # if level == K:
    #     print "=============="
    #     for i in counter:
    #         print i, counter[i]
    #     print "=============="
    
    for loc in frontier:
        # print "loc =", loc, "counter: ", counter[loc]
        x, y = loc[0], loc[1]

        if y != K - 1:
            newY = y + 1

            # case 1:
            newX = x - 1
            if newX >= 0 and newX < 4:
                if matrix[newX][newY] != 1:
                    new_frontier.add((newX, newY))
                    if (newX, newY) in counter:
                        counter[(newX, newY)] += counter[(x, y)]
                    else:
                        counter[(newX, newY)] = counter[(x, y)]

                    # if (newX, newY) == (0, K-1):
                    #    ans += 1

            # case 2:
            newX = x
            if newX >= 0 and newX < 4:
                if matrix[newX][newY] != 1:
                    new_frontier.add((newX, newY))
                    if (newX, newY) in counter:
                        counter[(newX, newY)] += counter[(x, y)]
                    else:
                        counter[(newX, newY)] = counter[(x, y)]

                    # if (newX, newY) == (0, K-1):
                    #     ans += 1

            # case 3:
            newX = x + 1
            if newX >= 0 and newX < 4:
                # print newX, newY

                if matrix[newX][newY] != 1:
                    new_frontier.add((newX, newY))
                    if (newX, newY) in counter:
                        counter[(newX, newY)] += counter[(x, y)]
                    else:
                        counter[(newX, newY)] = counter[(x, y)]

                    # if (newX, newY) == (0, K-1):
                    #     ans += 1
        else:
            if x == 0:
                ans = counter[(x, y)]

    
    # if level == K:
    #     print "=============="
    #     for i in frontier:
    #         print i, counter[i]
    #     print "=============="

    frontier = new_frontier

    level += 1

# print counter
print ans






