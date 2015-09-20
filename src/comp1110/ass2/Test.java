package comp1110.ass2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Test {

	static String pathname = "/Users/Jason/git/Algorithms/src/comp1110/ass2/data.txt";
	static HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

	static String outputFilePath = "/Users/Jason/git/Algorithms/src/comp1110/ass2/output.txt";

	/**
	 * Parse data.txt.
	 * 
	 * @param pathname
	 * @throws Exception
	 */
	public static void parseGameState(String pathname) throws Exception {
		File in = new File(pathname);
		BufferedReader br = new BufferedReader(new FileReader(in));

		File out = new File(outputFilePath);
		BufferedWriter bw = new BufferedWriter(new FileWriter(out));

		String line = br.readLine();
		while (line != null) {
			StringBuffer sb = new StringBuffer();
			sb.append("list = new ArrayList<>(); \n");

			// parse a single line:
			String key = line.split(":")[0].trim();
			String[] valueStr = line.split(":")[1].trim().split(",");
			ArrayList<Integer> valueList = new ArrayList<Integer>();
			for (String val : valueStr) {
				// valueList.add(Integer.parseInt(val.trim()));
				sb.append("list.add(" + val.trim() + "); \n");
			}

			sb.append("map.put(" + key + ", " + "list); \n");
			bw.write(sb.toString());

			line = br.readLine();
		}

		bw.close();
		br.close();

	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		parseGameState(pathname);
	}

}
