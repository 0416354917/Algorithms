package hdu;

import java.io.BufferedReader;
import java.io.FileReader;
/*
 * Weighted quick-union with path compression.
 */

/**
 * Today is Ignatius' birthday. He invites a lot of friends. Now it's dinner
 * time. Ignatius wants to know how many tables he needs at least. You have to
 * notice that not all the friends know each other, and all the friends do not
 * want to stay with strangers.
 * 
 * One important rule for this problem is that if I tell you A knows B, and B
 * knows C, that means A, B, C know each other, so they can stay in one table.
 * 
 * For example: If I tell you A knows B, B knows C, and D knows E, so A, B, C
 * can stay in one table, and D, E have to stay in the other one. So Ignatius
 * needs 2 tables at least.
 */
/**
 * 
 * Input: (1) first line: two integers, n and m. n represents number of friends,
 * m represents number of pair connections between those n friends. (2) m lines,
 * each line represents a connection between a pair of friend.
 *
 */
public class HDU1213 {

	/** file path */
	final static String input = "/Users/Jason/git/Algorithms/src/hdu/hdu1213_input.txt";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(input));

		String next = br.readLine();
		int n = Integer.parseInt(next.split(" ")[0]);
		int m = Integer.parseInt(next.split(" ")[1]);
		WQUPC uf = new WQUPC(n);

		int i = 0;
		while (i < m) {
			next = br.readLine();
			if (next != null) {
				int p = Integer.parseInt(next.split(" ")[0]);
				int q = Integer.parseInt(next.split(" ")[1]);
				System.out.println("add connection: " + p + " --> " + q);
				uf.unite(p, q);
			}
			i++;
		}
		br.close();

		// analyze groups:
		System.out.println("number of groups: " + uf.getNumGroups());

	}

}

/**
 * Weighted quick-union with path compression.
 * 
 * @author Jason
 *
 */
class WQUPC {
	private int[] id;
	private int[] sz;
	private int numGroups;

	public WQUPC(int N) {
		id = new int[N];
		sz = new int[N];
		numGroups = N;
		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}

	/**
	 * Find root with path compression.
	 * 
	 * @param p
	 * @return
	 */
	public int root(int p) {
		while (p != id[p]) {
			id[p] = id[id[p]];
			p = id[p];
		}
		return p;
	}

	/**
	 * Find whether there is a connection between p and q.
	 * 
	 * @param p
	 * @param q
	 * @return root(p) == root(q)
	 */
	public boolean find(int p, int q) {
		return root(p) == root(q);
	}

	/**
	 * Unite p and q.
	 * 
	 * @param p
	 * @param q
	 */
	public void unite(int p, int q) {
		int i = root(p);
		int j = root(q);

		if (i == j) {
			System.out.println(i + " and " + j + " are already connected...");
			return;
		}

		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		numGroups--;
	}

	/**
	 * Get the number of groups.
	 * 
	 * @return numGroups
	 */
	public int getNumGroups() {
		return numGroups;
	}
}