package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Find Median from Data Stream.
 * 
 * Median is the middle value in an ordered integer list. If the size of the
 * list is even, there is no middle value. So the median is the mean of the two
 * middle value.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution295 {

	class MedianFinder {

		List<Integer> nums = new ArrayList<Integer>();

		// Adds a number into the data structure.
		public void addNum(int num) {
			if (nums.size() < 1) {
				nums.add(num);
				return;
			}

			int left = 0;
			int right = nums.size() - 1;
			int mid = (left + right) / 2;
			while (left != right) {
				int midVal = nums.get(mid);
				if (num == midVal) {
					nums.add(mid, num);
					return;
				} else if (num < midVal) {
					right = mid - 1;
					if (right < left)
						break;
					mid = (left + right) / 2;
				} else {
					left = mid + 1;
					mid = (left + right) / 2;
				}
			}
			if (num >= nums.get(mid)) {
				nums.add(mid + 1, num);
			} else {
				nums.add(mid, num);
			}
		}

		// Returns the median of current data stream
		public double findMedian() {
			int n = nums.size();
			if (n == 1)
				return nums.get(0);
			else if (n % 2 == 0) {
				return (nums.get(n / 2 - 1) + nums.get(n / 2)) / 2.0;
			} else {
				return nums.get(n / 2);
			}
		}
	}

	public static void main(String[] args) {
		Solution295 solution = new Solution295();

		MedianFinder mf = solution.new MedianFinder();

		mf.addNum(-1);
		for (int num : mf.nums)
			System.out.print(num + " -> ");
		System.out.println(mf.findMedian());
		mf.addNum(-2);
		for (int num : mf.nums)
			System.out.print(num + " -> ");
		System.out.println(mf.findMedian());
		mf.addNum(-3);
		for (int num : mf.nums)
			System.out.print(num + " -> ");
		System.out.println(mf.findMedian());
		mf.addNum(-4);
		System.out.println(mf.findMedian());
		mf.addNum(-5);
		System.out.println(mf.findMedian());
	}

}
