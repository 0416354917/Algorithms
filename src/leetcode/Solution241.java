package leetcode;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptException;

/**
 * Different Ways to Add Parentheses.
 * 
 * Given a string of numbers and operators, return all possible results from
 * computing all the different possible ways to group numbers and operators. The
 * valid operators are +, - and *.
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * <p>
 * Algorithm:<b> Dynamic Programming & Divide and Conquer.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution241 {

	// TODO! Divide and Conquer.

	/**
	 * Evaluate a math expression represented in strings.
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	public Integer eval(String[] arr, int left, int right) {
		if (left == right) {
			return Integer.parseInt(arr[left]);
		} else {
			Integer x = Integer.parseInt(arr[left]);
			Integer y = Integer.parseInt(arr[right]);
			switch (arr[1]) {
			case "+":
				return x + y;
			case "-":
				return x - y;
			case "*":
				return x * y;
			}
		}

		return 0;
	}

	public List<Integer> merge(String[] arr, int left, int right) {
		List<Integer> ans = new ArrayList<Integer>();

		if (right - left <= 2) {

		}

		return ans;
	}

	public List<Integer> partition(String[] arr, int left, int index,
			int right) {
		return null;
	}

	/**
	 * Dynamic Programming.
	 * 
	 * @param input
	 * @return
	 */
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> ans = new ArrayList<Integer>();

		if (input == null || input.length() == 0)
			return ans;

		// scan and parse:
		List<Integer> nums = new ArrayList<Integer>();
		List<Character> ops = new ArrayList<Character>();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*') {
				nums.add(Integer.parseInt(sb.toString()));
				ops.add(ch);
				sb = new StringBuffer();
			} else {
				sb.append(ch);
			}
		}
		nums.add(Integer.parseInt(sb.toString()));

		// dp initialization:
		List<List<List<Integer>>> dp = new ArrayList<List<List<Integer>>>();
		for (int i = 0; i < nums.size(); i++) {
			List<List<Integer>> row = new ArrayList<List<Integer>>();
			for (int j = 0; j < nums.size(); j++) {
				List<Integer> cell = new ArrayList<Integer>();
				if (j == i) {
					cell.add(nums.get(i));
					row.add(cell);
				} else {
					// cell.add(0);
					row.add(cell);
				}
			}
			dp.add(row);
		}

		// dp:
		for (int col = 1; col < nums.size(); col++) {
			for (int row = col - 1; row >= 0; row--) {
				List<Integer> cell = dp.get(row).get(col);
				for (int i = row; i <= col - 1; i++) {
					eval(cell, dp.get(row).get(i), dp.get(i + 1).get(col),
							ops.get(i));
				}
			}
		}

		// set ans:
		dp.get(0).get(nums.size() - 1).stream().forEach(i -> ans.add(i));

		return ans;
	}

	public void eval(List<Integer> result, List<Integer> set1,
			List<Integer> set2, char op) {
		if (op == '+') {
			for (Integer x : set1) {
				for (Integer y : set2) {
					result.add(x + y);
				}
			}
		} else if (op == '-') {
			for (Integer x : set1) {
				for (Integer y : set2) {
					result.add(x - y);
				}
			}
		} else if (op == '*') {
			for (Integer x : set1) {
				for (Integer y : set2) {
					result.add(x * y);
				}
			}
		}
	}

	public static void main(String[] args) throws ScriptException {
		// ScriptEngineManager manager = new ScriptEngineManager();
		// ScriptEngine engine = manager.getEngineByName("js");
		// Object result = engine.eval("4*5");
		// System.out.println(result.toString());

		Solution241 solution = new Solution241();

		String input = "1+2+3";

		List<Integer> ans = solution.diffWaysToCompute(input);
		for (int x : ans) {
			System.out.println(x);
		}
	}

}
