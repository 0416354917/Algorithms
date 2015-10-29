class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        ans = [[0 for i in range(n)] for j in range(m)]
        
        for i in range(m):
            for j in range(n):
                live = 0
                
                if i-1 >= 0 and j-1 >= 0:
                    live += (board[i-1][j-1] == 1)
                if i-1 >= 0:
                    live += (board[i-1][j] == 1)
                if i-1 >= 0 and j+1 < n:
                    live += (board[i-1][j+1] == 1)
                if j+1 < n:
                    live += (board[i][j+1] == 1)
                if i+1 < m and j+1 < n:
                    live += (board[i+1][j+1] == 1)
                if i+1 < m:
                    live += (board[i+1][j] == 1)
                if i+1 < m and j-1 >= 0:
                    live += (board[i+1][j-1] == 1)
                if j-1 >= 0:
                    live += (board[i][j-1] == 1)
                
                if board[i][j] == 0:
                    if live == 3:
                        ans[i][j] = 1
                    
                if board[i][j] == 1:
                    if live == 2 or live == 3:
                        ans[i][j] = 1
        for i in range(m):
            for j in range(n):
                board[i][j] = ans[i][j]
                    
    
        
        