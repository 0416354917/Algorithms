package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Simplify Path.
 * 
 * <p>
 * <b>Description: </b>Given an absolute path for a file (Unix-style), simplify
 * it.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Stack.
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution71 {

	public String simplifyPath(String path) {
		if (path == null || path.length() == 0)
			return path;

		StringBuffer ans = new StringBuffer();

		List<String> stack = new ArrayList<String>();
		int index = 0;
		StringBuffer token = new StringBuffer();
		while (index < path.length()) {
			if (path.charAt(index) == '/') {
				if (token.length() != 0) {
					stack.add(token.toString());
					token = new StringBuffer();
				}
				while (index < path.length() && path.charAt(index) == '/') {
					index++;
				}
				stack.add("/");
			} else if (path.charAt(index) == '.') { // key algorithm branch:
				token.append(".");
				index++;
				while (index < path.length() && path.charAt(index) != '/') {
					token.append(path.charAt(index));
					index++;
				}
				if (token.toString().equals(".")) {
					stack.remove(stack.size() - 1);
					token = new StringBuffer();
				} else if (token.toString().equals("..")) {
					try {
						stack.remove(stack.size() - 1);
						stack.remove(stack.size() - 1);
						stack.remove(stack.size() - 1);
					} catch (Exception e) {
					}
					token = new StringBuffer();
				} else {
					continue;
				}
			} else {
				token.append(path.charAt(index));
				index++;
			}
		}

		if (token.length() != 0) {
			stack.add(token.toString());
		}

		if (stack.size() == 0)
			return "/";

		if (stack.size() > 1 && stack.get(stack.size() - 1).equals("/"))
			stack.remove(stack.size() - 1);

		stack.stream().forEach(s -> ans.append(s));

		return ans.toString();
	}

	public static void main(String[] args) {
		Solution71 solution = new Solution71();

		String path = "/a/./b/../../c/";
		System.out.println(path + " -> " + solution.simplifyPath(path));
		String path1 = "/VO/.././../..///F/Krh";
		System.out.println(path1 + " -> " + solution.simplifyPath(path1));
		String path2 = "/a/./b/../";
		System.out.println(path2 + " -> " + solution.simplifyPath(path2));
		String path3 = "/../";
		System.out.println(path3 + " -> " + solution.simplifyPath(path3));
		String path4 = "/home//foo/";
		System.out.println(path4 + " -> " + solution.simplifyPath(path4));
		String path5 = "/...";
		System.out.println(path5 + " -> " + solution.simplifyPath(path5));
		String path6 = "/..hidden";
		System.out.println(path6 + " -> " + solution.simplifyPath(path6));
	}

}
