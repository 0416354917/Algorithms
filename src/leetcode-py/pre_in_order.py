# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if inorder:
        	root = TreeNode(preorder.pop(0))
        	root_index = inorder.index(root.val)
        	root.left = self.buildTree(preorder, inorder[:root_index])
        	root.right = self.buildTree(preorder, inorder[root_index+1:])
        	return root
        else:
        	return None