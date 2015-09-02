package hdu;

import java.util.Scanner;

public class HDU3635 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			System.out.println("Case " + t + ":");
			int N = sc.nextInt();
			int Q = sc.nextInt();
			WQUPC3635 uf = new WQUPC3635(N + 1);

			String line = sc.nextLine();
			for (int i = 0; i < Q; i++) {
				line = sc.nextLine();
				if (line.startsWith("T")) {
					int p = Integer.parseInt(line.split(" ")[1]);
					int q = Integer.parseInt(line.split(" ")[2]);
					uf.unite(p, q);
				} else {
					int p = Integer.parseInt(line.split(" ")[1]);
					int X = uf.root(p);
					int Y = uf.getSize(X);
					int Z = uf.getTransNum(p);
					System.out.println(X + " " + Y + " " + Z);
				}
			}
		}
		sc.close();
	}

}

class WQUPC3635 {
	private int[] id;
	private int[] sz;
	private int[] trans;

	public WQUPC3635(int N) {
		id = new int[N];
		sz = new int[N];
		trans = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
			trans[i] = 0;
		}
	}

	// find the root (group id) of p:
	public int root(int p) {
		while (p != id[p]) {
			id[p] = id[id[p]];
			p = id[p];
		}
		return p;
	}

	// unite p to q:
	public void unite(int p, int q) {
		int i = root(p);
		int j = root(q);

		if (i == j)
			return;

		// update trans:
		for (int k = 1; k < id.length; k++) {
			if (root(k) == i) {
				trans[k]++;
			}
		}

		id[i] = j;
		sz[j] += sz[i];

	}

	// get size of group r:
	public int getSize(int r) {
		return sz[r];
	}

	// get trans of p:
	public int getTransNum(int p) {
		return trans[p];
	}
}