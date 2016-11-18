# Next Permutation
# Medium
# AC


class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        ia, ib = -1, -1
        for i in xrange(1, n):
            if nums[i] > nums[i - 1]:
                ia, ib = i-1, i
        if ib == n - 1:
            nums[ia], nums[ib] = nums[ib], nums[ia]
        elif ia == - 1 and ib == -1:
            nums.sort()
        else:
            for i in xrange(n-1, ib-1, -1):
                if nums[i] > nums[ia]:
                    nums[i], nums[ia] = nums[ia], nums[i]
                    s, e = ia+1, n-1
                    while s < e:
                        nums[s], nums[e] = nums[e], nums[s]
                        s += 1
                        e -= 1
                    break
