# Permutation Sequence
# Medium
# AC


class Solution(object):
    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        res = []
        st = set(xrange(1, n+1))
        fact = reduce(lambda x, y: x*y, st)
        while k <= fact:
            fact /= (n - len(res))
            if k % fact == 0:
                res.append(sorted(st)[max(k/fact - 1, 0)])
                st.remove(res[-1])
                res.extend(sorted(list(st), reverse=True))
                st.clear()
                break
            else:
                res.append(sorted(st)[k/fact])
                st.remove(res[-1])
                k -= (k/fact) * fact
        res.extend(sorted(list(st)))
        return ''.join(map(str, res))
