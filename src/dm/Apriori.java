package dm;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * An implementation of Apriori algorithm.
 * 
 * @author Jason
 *
 */
public class Apriori {

	static void loadData(String dir, String filename) {
		String file = dir + filename;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			// read data:
			String record;
			while ((record = br.readLine()) != null) {

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		System.out.println("HELLO!");
	}

}
