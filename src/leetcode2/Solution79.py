# Word Search
# Medium
# AC


class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        m, n = len(board), len(board[0])
        for i in xrange(m):
            for j in xrange(n):
                if board[i][j] == word[0]:
                    if self.bt(board, word, [word[0]], set([(i, j)]), i, j):
                        return True
        return False

    def bt(self, board, word, ass, used, x, y):
        m, n, length = len(board), len(board[0]), len(word)
        if len(ass) == length:
            return ''.join(ass) == word
        else:
            offset_arr = [-1, 0, 1, 0, -1]
            for i in xrange(4):
                xx, yy = x+offset_arr[i], y+offset_arr[i+1]
                if 0 <= xx < m and 0 <= yy < n and (xx, yy) not in used:
                    if board[xx][yy] == word[len(ass)]:
                        ass.append(board[xx][yy])
                        used.add((xx, yy))
                        if self.bt(board, word, ass, used, xx, yy):
                            return True
                        else:
                            used.remove((xx, yy))
                            ass.pop()
            return False
