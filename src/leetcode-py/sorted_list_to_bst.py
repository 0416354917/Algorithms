## Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
#
# Algorithm: slow-fast traversal on linked list.
# http://www.code123.cc/docs/leetcode-notes/basics_data_structure/linked_list.html
# 



# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sortedListToBST(self, head):
        """
        :type head: ListNode
        :rtype: TreeNode
        """
        if not head:
            return None
            
        if not head.next:
            return TreeNode(head.val)
        
        slow, fast = head, head
        prev = slow
        while fast:
            fast = fast.next
            if fast:
                fast = fast.next
                prev = slow
                slow = slow.next
        prev.next = None
        
        root = TreeNode(slow.val)
        root.left = self.sortedListToBST(head)
        root.right = self.sortedListToBST(slow.next)
        
        return root
        
