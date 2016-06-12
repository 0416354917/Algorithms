package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Line Reflection.
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution356 {

	public boolean isReflected(int[][] points) {
		if (points == null || points.length < 2) {
			return true;
		}

		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				if (arr1[0] < arr2[0]) {
					return -1;
				} else if (arr1[0] > arr2[0]) {
					return 1;
				} else {
					if (arr1[1] < arr2[1]) {
						return -1;
					} else if (arr1[1] > arr2[1]) {
						return 1;
					} else {
						return 0;
					}
				}
			}
		});

		int n = points.length;

		Arrays.sort(points, ((n - 1) >> 1) + 1, n, new Comparator<int[]>() {

			@Override
			public int compare(int[] arr1, int[] arr2) {
				if (arr1[0] < arr2[0]) {
					return -1;
				} else if (arr1[0] > arr2[0]) {
					return 1;
				} else {
					if (arr1[1] < arr2[1]) {
						return 1;
					} else if (arr1[1] > arr2[1]) {
						return -1;
					} else {
						return 0;
					}
				}
			}

		});

		int left = n >> 1, right = n >> 1;
		if ((n & 1) == 0) {
			left--;
		}
		int midX2 = points[left][0] + points[right][0];

		while (left >= 0) {
			if (points[left][0] != points[right][0]) {
				if (((points[left][0] + points[right][0]) ^ midX2) != 0) {
					return false;
				} else if ((points[left][1] ^ points[right][1]) != 0) {
					return false;
				}
			}

			left--;
			right++;
		}

		return true;
	}

	public static void main(String[] args) {
		Solution356 solution = new Solution356();

		int[][] points = { { 2, 0 }, { 2, 1 }, { 2, 2 }, { 2, 3 }, { 2, 4 },
				{ -2, 0 }, { -2, 1 }, { -2, 2 }, { -2, 3 }, { -2, 4 } };
		System.out.println(solution.isReflected(points));
	}

}
