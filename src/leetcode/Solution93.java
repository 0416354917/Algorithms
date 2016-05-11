package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Restore IP Addresses.
 * 
 * Status: Accepted.
 * 
 * @author Jason
 *
 */
public class Solution93 {

	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();

		StringBuffer sb = new StringBuffer(s);
		int addressLength = s.length();
		for (int i = 1; i < Math.min(addressLength - 2, 4); i++) {
			for (int j = i + 1; j < Math.min(addressLength - 1, i + 4); j++) {
				for (int k = j + 1; k < Math.min(addressLength, j + 4); k++) {
					sb.insert(i, ".");
					sb.insert(j + 1, ".");
					sb.insert(k + 2, ".");
					String[] segment = sb.toString().split("\\.");
					try {
						int num1 = Integer.parseInt(segment[0]);
						int num2 = Integer.parseInt(segment[1]);
						int num3 = Integer.parseInt(segment[2]);
						int num4 = Integer.parseInt(segment[3]);
						if (num1 >= 0 && num1 <= 255 && num2 >= 0 && num2 <= 255
								&& num3 >= 0 && num3 <= 255 && num4 >= 0
								&& num4 <= 255) {
							boolean flag = true;
							if (segment[0].startsWith("0")
									&& segment[0].length() > 1) {
								flag = false;
							}
							if (segment[1].startsWith("0")
									&& segment[1].length() > 1) {
								flag = false;
							}
							if (segment[2].startsWith("0")
									&& segment[2].length() > 1) {
								flag = false;
							}
							if (segment[3].startsWith("0")
									&& segment[3].length() > 1) {
								flag = false;
							}

							if (flag) {
								result.add(sb.toString());
							}
						}
					} catch (Exception e) {

					}
					sb.deleteCharAt(k + 2);
					sb.deleteCharAt(j + 1);
					sb.deleteCharAt(i);
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		String s = "25525511135";
		System.out.println(new Solution93().restoreIpAddresses(s));
	}

}
