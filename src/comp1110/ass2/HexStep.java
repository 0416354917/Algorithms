package comp1110.ass2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by SIQI on 24/08/15.
 */
public class HexStep {

	static String pathname = "/Users/Jason/git/Algorithms/src/comp1110/ass2/data.txt";
	static HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

	/**
	 * Parse data.txt.
	 * 
	 * @param pathname
	 * @throws Exception
	 */
	// public static void parseGameState(String pathname) throws Exception {
	// // File f = new File(pathname);
	// // BufferedReader br = new BufferedReader(new FileReader(f));
	// // String line = br.readLine();
	// // while (line != null) {
	// // // parse a single line:
	// // int key = Integer.parseInt(line.split(":")[0].trim());
	// // String[] valueStr = line.split(":")[1].trim().split(",");
	// // ArrayList<Integer> valueList = new ArrayList<Integer>();
	// // for (String val : valueStr) {
	// // valueList.add(Integer.parseInt(val.trim()));
	// // }
	// // map.put(key, valueList);
	// // line = br.readLine();
	// // }
	// // br.close();
	//
	// map = HexData.parse();
	// }

	/**
	 * Judge.
	 * 
	 * @param game
	 * @param from
	 * @param to
	 * @return
	 * @throws Exception
	 */
	public static boolean stepJudge(String game, int from, int to) throws Exception {
		// parseGameState(pathname);

		map = HexData.parse();

		// split:
		// (1) crannies:
		String cranniesStr = game.substring(0, 18);
		ArrayList<Integer> cranniesNum = new ArrayList<Integer>();
		for (int i = 0; i < 18; i += 3) {
			cranniesNum.add(Integer.parseInt(cranniesStr.substring(i, i + 3)));
		}

		// (2) nooks:
		String nooksStr = game.substring(18, 90);
		HashMap<Integer, Character> nooks = new HashMap<Integer, Character>();
		for (int i = 0; i < 72; i += 4) {
			int nookPos = Integer.parseInt(nooksStr.substring(i, i + 3));
			char angle = nooksStr.substring(i + 3, i + 4).charAt(0);
			nooks.put(nookPos, angle);
		}

		// (3) starting pos of the ball:
		String ballPosStr = game.substring(90);
		int ballInitPos = Integer.parseInt(ballPosStr);

		/** from is in nooks positions? */
		// if (!nooks.containsKey(from)) {
		// return false;
		// }
		if (from != ballInitPos) {
			return false;
		}

		/** barrier or not? */
		boolean hasBarrier = false;
		if (!nooks.containsKey(to) && to < 169) {
			hasBarrier = true;
		} else {
			// walk from starting point to ending point, if walked into a nook
			// position but not the ending point, then there is a barrier caused
			// by a nook.
			int dir = direction(from, to);
			// System.out.println(dir);
			if (dir == -1) {
				hasBarrier = true;
			} else {
				int next = map.get(from).get(dir);
				while (next != to) {
					if (nooks.containsKey(next)) {
						hasBarrier = true;
						break;
					}
					next = map.get(next).get(dir);
				}
			}
		}
		if (hasBarrier) {
			return false;
		}

		/** everything is OK, indicating a legitimate step */
		return true;
	}

	public static int direction(int from, int to) {
		int res = 0;
		boolean reachable = false;
		while (res < 6) {
			int next = map.get(from).get(res);
			while (next != -1) {
				if (next == to) {
					reachable = true;
					break;
				} else {
					next = map.get(next).get(res);
				}
			}
			if (reachable) {
				return res;
			}
			res++;
		}

		// if not reachable:
		return -1;
	}

	public static void main(String[] args) throws Exception {
		// parseGameState(pathname);
		// System.out.println(direction(37, 127));
	}
}
