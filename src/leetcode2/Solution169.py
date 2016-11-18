# Majority Element
# Easy
# AC


class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        x, count = None, 0
        for i in xrange(len(nums)):
            if x is None:
                x = nums[i]
                count = 1
            elif nums[i] == x:
                count += 1
            else:
                count -= 1
                if count == 0:
                    x = None
        return x
