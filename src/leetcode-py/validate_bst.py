# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True

        # get the inorder traversal sequence:
        inorder_res = self.inorder(root)
        a = inorder_res[0]
        index = 1
        while index < len(inorder_res):
            if inorder_res[index] <= a:
                return False
            else:
                a = inorder_res[index]
            index += 1
        return True


    def inorder(self, root):
        if not root:
            return []
        elif not root.left and not root.right:
            return [root.val]
        else:
            return self.inorder(root.left) + [root.val] + self.inorder(root.right)