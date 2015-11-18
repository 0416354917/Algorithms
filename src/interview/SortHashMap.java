package interview;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

/**
 * Sort a HashMap by keys or values.
 * 
 * @author Jun Chen
 *
 */
public class SortHashMap {

	/**
	 * Sort a HasmMap by values.
	 * 
	 * @param map
	 * @return
	 */
	public static List<Entry<Integer, String>> sortByValue(HashMap<Integer, String> map) {
		List<Entry<Integer, String>> resList = new LinkedList<Entry<Integer, String>>();
		for (Entry<Integer, String> entry : map.entrySet())
			resList.add(entry);
		Collections.sort(resList, new Comparator<Entry<Integer, String>>() {
			@Override
			public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		return resList;
	}

	/**
	 * Sort a HashMap by keys.
	 * 
	 * @param map
	 * @return
	 */
	public static List<Entry<Integer, String>> sortByKey(HashMap<Integer, String> map) {
		List<Entry<Integer, String>> resList = new LinkedList<Entry<Integer, String>>();
		for (Entry<Integer, String> entry : map.entrySet())
			resList.add(entry);
		Collections.sort(resList, new Comparator<Entry<Integer, String>>() {
			@Override
			public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		return resList;
	}

	/**
	 * Print out elements in a collection.
	 * 
	 * @param col
	 */
	public static void printList(Collection<Entry<Integer, String>> col) {
		for (Entry<Integer, String> entry : col)
			System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
	}

	public static void main(String[] args) {
		// construct a HashMap:
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Apple");
		map.put(3, "Orange");
		map.put(5, "Strawberry");
		map.put(2, "Watermelon");
		map.put(4, "Banana");

		// without sorting:
		System.out.println("====================Without Sorting=======================");
		printList(map.entrySet());

		// sort by key:
		System.out.println("====================Sort by Key===========================");
		List<Entry<Integer, String>> resList1 = sortByKey(map);
		printList(resList1);

		// sort by value:
		System.out.println("====================Sort by Value=========================");
		List<Entry<Integer, String>> resList2 = sortByValue(map);
		printList(resList2);
	}

}
