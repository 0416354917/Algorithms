# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True
        
        dif = self.height(root.left) - self.height(root.right)
        if dif >= -1 and dif <= 1 and self.isBalanced(root.left) and self.isBalanced(root.right):
            return True
        else:
            return False

    def height(self, root):
        if not root:
            return 0
        elif not root.left and not root.right:
            return 1
        else:
            return max(self.height(root.left), self.height(root.right)) + 1

