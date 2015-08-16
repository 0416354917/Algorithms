package sort;

/* 计数排序思想很美妙，不需要进行元素间大小的比较，时间复杂度是线性的，
 * 在实践中，经常采用计数排序，该排序稳定。计数排序要求元素大小限定在一定范围内，比如[0, k]， 算法代码如下：
 */
//suppose range is : [0, k].

public class CountSort {

	static void countSort(int[] a, int n, int k) {
		int[] fre = new int[k + 1];
		for (int i = 0; i < k + 1; i++)
			fre[i] = 0;
		for (int i = 0; i < n; i++)
			fre[a[i]]++;

		for (int i = 0; i < k + 1; i++)
			System.out.println(fre[i]);

		int pos = 0;
		for (int i = 0; i <= k; i++) {
			int j = pos;
			pos += fre[i];
			while (j < pos) {
				a[j] = i;
				j++;
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 0, 1, 5, 3, 2, 2, 3, 0, 2, 6 };
		int k = 6;
		int n = 10;
		countSort(a, n, k);
		for (int i = 0; i < n; i++)
			System.out.print(a[i] + " ");
	}

}
