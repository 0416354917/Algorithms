## backtracking

def solveNQueens(n):
    """
    :type n: int
    :rtype: List[List[str]]
    """
    if n == 0 or n == 2 or n == 3:
    	return []

    if n == 1:
    	return [['Q']]

    ans = []
    sol = []

    

    