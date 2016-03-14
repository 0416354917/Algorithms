from itertools import combinations

# Define global constants:
filename = "data.txt"
min_sup = 3
K = 4

# Construct L(1):
L = {}
with file(filename) as transactions:
    while True:
        line = transactions.readline().strip()
        if not line:
            break
        items = line.split(": ")[1]
        items_list = items.strip().split(",")
        for item in items_list:
            if item in L:
                L[item] += 1
            else:
                L[item] = 1

for item in L.keys():
    if L[item] < min_sup:
        L.pop(item)

# Algorithm loop begins:
k = 1
while k < K:
    k += 1
    # Compute L(k):
    # (1) Generate C(k) by self-joining L(k-1).
    candidate_items_list = list(combinations(sorted(L.keys()), 2))
    if k > 2:
        for i in range(len(candidate_items_list)):
            candidate_items = candidate_items_list[i]
            candidate_items_list[i] = tuple(sorted(list(set(candidate_items[0]).union(set(candidate_items[1])))))
        candidate_items_list = [candidate_items for candidate_items in candidate_items_list if len(candidate_items) == k]
        
    # print len(candidate_items_list)
    if k == K:
        print set(candidate_items_list)

    L = {}
    # Scan database to count:
    with file(filename) as transactions:
        while True:
            line = transactions.readline().strip()
            if not line:
                break
            items = line.split(": ")[1]
            items_list = items.strip().split(",")
            for candidate_items in set(candidate_items_list):
                if set(candidate_items).issubset(set(items_list)):
                    if candidate_items in L:
                        L[candidate_items] += 1
                    else:
                        L[candidate_items] = 1
    for candidate_items in L.keys():
        if L[candidate_items] < min_sup:
            L.pop(candidate_items)

    if k == K:
        keys = sorted(L.keys())
        for key in keys:
            print key, ":", L[key]