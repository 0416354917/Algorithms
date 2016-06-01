import java.util.Comparator;

public interface Sorter {
	public <T extends Comparable<T>> void insertionSort(T[] arr);

	public <T> void selectionSort(T[] arr, Comparator<T> cmp);
}
