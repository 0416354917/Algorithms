# Majority Element II
# Medium
# AC


class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        # There are at most 2 majority elements, and there is the possibility
        # that there isn't any majority elements at all.
        a, b = None, None
        cnta, cntb = 0, 0
        for i in xrange(len(nums)):
            if a is None and nums[i] != b:
                a, cnta = nums[i], 1
            elif nums[i] == a:
                cnta += 1
            elif b is None:
                b, cntb = nums[i], 1
            elif nums[i] == b:
                cntb += 1
            else:
                cnta, cntb = cnta-1, cntb-1
                a = None if cnta == 0 else a
                b = None if cntb == 0 else b
        return filter(lambda x: x is not None and nums.count(x) > len(nums) // 3, [a, b])
