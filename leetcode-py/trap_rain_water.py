class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if not height:
            return 0

        N = len(height)
        if N < 3:
            return 0

        index = 0
        left = height[index]
        while left == 0 and index < N - 1:
            index += 1
            left = height[index]
        if index >= N - 2:
            return 0
        else:
            index += 2
            right = height[index]
        


