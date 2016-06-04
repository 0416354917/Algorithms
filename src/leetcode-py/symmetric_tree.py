# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param {TreeNode} root
    # @return {boolean}
    def isSymmetric(self, root):
        if root == None:
            return True
            
        from collections import deque
        d = deque()
        d.append(root)
        lst = []
        while d:
            node = d.popleft()
            if node == None:
                lst.append('#')
            else:
                lst.append(node.val)
                if not node.left and not node.right and not d:
                    break
                else:
                    d.append(node.left)
                    d.append(node.right)
        
        n = len(lst)
        # print lst
        
        i = n - 1
        while i >= 0:
            if lst[i] == '#':
                lst.pop()
                i -= 1
            else:
                break
            
        n = len(lst)
        print lst
        
        if n == 1:
            return True
        
        length = 2
        sidx = 1
        # print 'lst:', lst
        while sidx < n:
            print 'sidx =', sidx
            sublst = lst[sidx : sidx + length]
            sublen = len(sublst)
            print 'sublst:', sublst
            max_sub = length - sublen
            i = 0
            while i < max_sub:
                if sublst[i] == '#':
                    i += 1
                else:
                    break
            if i:
                sublst = sublst[i : ]
                sublen = len(sublst)
            
            if sublen % 2 != 0:
                return False
            for i in range(sublen / 2):
                if sublst[i] != sublst[sublen-1-i]:
                    return False
            sidx = sidx + length
            length <<= 1 
            
        return True
        
            
                
                
        
        
        
            
        