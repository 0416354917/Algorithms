# Enter your code here. Read input from STDIN. # Print output to STDOUT

import math

t = int(input(""))

# # print t

for i in range(t):
    line = raw_input("")
    p = int(line.split(" ")[0])
    c = int(line.split(" ")[1])
    ## print p, c

    predictions = {}
    for j in range(p):
        name = raw_input("")
        ## print name
        predictions[name] = []
        for k in range(c):
            line = raw_input("")
            p1 = int(line.split(" ")[0])
            p2 = int(line.split(" ")[1])

            # p1 = input("")
            # p2 = input("")

            predictions[name].append((p1, p2))
    # real data:
    real = []
    for j in range(c):
        line = raw_input("")
        s1 = line.split(" ")[0]
        s2 = line.split(" ")[1]

        if s1 != '?':
            s1 = int(s1)
            s2 = int(s2)

        # s1 = input("")
        # s2 = input("")

        real.append((s1, s2))
        
    # compute scores:
    scores = {}
    max_score = -1
    max_name = ""
    for name in predictions:
        pred = predictions[name]
        # print 'pred: ', pred
        score = 0
        for idx in range(c):
            # print name, "......"
            # print pred[idx], real[idx]

            t1score, t2score, point_spread = 0, 0, 0
            
            if real[idx][0] != "?":
                # print pred[idx][0] - real[idx][0]
                if (pred[idx][0] - pred[idx][1]) * (real[idx][0] - real[idx][1]) > 0 or pred[idx] == real[idx]:
                    # print 'yyy'
                    score += 10
                t1score = max(0, 5 - math.fabs(pred[idx][0] - real[idx][0]))
                # print t1score
                t2score = max(0, 5 - math.fabs(pred[idx][1] - real[idx][1]))
                # print t2score
                point_spread = max(0, 5 - math.fabs((pred[idx][0] - pred[idx][1]) - (real[idx][0] - real[idx][1])))
                # print point_spread
            else:
                
                pass

            score += (t1score + t2score + point_spread)
            # print 'score = ', score
        if score > max_score:
            max_score = score
            max_name = name
        scores[name] = score

    # # print this round:
    ans = []
    for name in scores:
        if scores[name] == scores[max_name]:
            ans.append(name)

    ans.sort()
    print " ".join(ans)
    # print scores






    
    
        
        
    
    