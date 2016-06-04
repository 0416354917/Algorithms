# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


#
# Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
#
class Solution:
    # @param {integer[]} nums
    # @return {TreeNode}
    def sortedArrayToBST(self, nums):
        if not nums:
            return None

        N = len(nums)
        if N == 0 :
            return None
        else:
            root_index = N/2
            root = TreeNode(nums[root_index])
            root.left = self.sortedArrayToBST(nums[:root_index])
            root.right = self.sortedArrayToBST(nums[root_index+1:])
            return root


