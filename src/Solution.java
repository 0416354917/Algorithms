import java.util.Comparator;

public class Solution implements Sorter {

	@Override
	public <T extends Comparable<T>> void insertionSort(T[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			T iCopy = arr[i];
			while (j >= 0 && arr[j].compareTo(iCopy) > 0) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = iCopy;
		}
	}

	@Override
	public <T> void selectionSort(T[] arr, Comparator<T> cmp) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			T minValue = arr[minIndex];
			for (int j = i + 1; j < arr.length; j++) {
				if (cmp.compare(arr[j], minValue) < 0) {
					minIndex = j;
					minValue = arr[j];
				}
			}
			T temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}

	public static void main(String[] args) {
		// Queue<Person> q = new PriorityQueue<>();
		//
		// q.add(new Person(3, "c"));
		// q.add(new Person(2, "b"));
		// q.add(new Person(1, "a"));
		//
		// while (!q.isEmpty()) {
		// System.out.println(q.poll().id);
		// }

		Integer[] nums = { 5, 1, 6, 2, 3, 1, 3, 4, 7 };
		// int[] sortedNums = { 1, 1, 2, 3, 3, 4, 5, 6, 7 };

		Solution sol = new Solution();
		// sol.insertionSort(nums);
		sol.selectionSort(nums, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}

		});
		for (int x : nums) {
			System.out.println(x);
		}

	}

}
