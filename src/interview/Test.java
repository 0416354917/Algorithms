package interview;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.stream.IntStream;

public class Test {
	public static int minSubArrayLen(int s, int[] nums) {
		int n = nums.length;
		int totalSum = IntStream.of(nums).sum();
		if (totalSum == s) {
			return n;
		} else if (totalSum < s) {
			return 0;
		} else {
			// two-pointers:
			int res = n;
			int left = 0;
			int right = n - 1;
			while (true) {
				int num1 = nums[left];
				int num2 = nums[right];
				int remainSum = 0;
				if (num1 <= num2) {
					remainSum = totalSum - num1;
					left += 1;
				} else {
					remainSum = totalSum - num2;
					right -= 1;
				}

				if (remainSum < s) {
					break;
				} else {
					totalSum = remainSum;
					res -= 1;
				}
			}

			System.out.println(left + " " + right);
			return res;
		}
	}

	public static void main(String[] args) {
		Deque<Integer> sta1 = new ArrayDeque<Integer>();
		sta1.add(1);
		System.out.println(sta1.size());

		Stack<Integer> sta2 = new Stack<Integer>();
		sta2.add(1);
		System.out.println(sta2.size());

		// Calculate the sum of an array with the use of stream (since Java
		// 1.8):
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		System.out.println(IntStream.of(nums).sum());

		// test:
		int s = 7;
		System.out.println(minSubArrayLen(s, nums));

		String str = "apple";
		System.out.println(str.substring(4, 5));
	}

}
