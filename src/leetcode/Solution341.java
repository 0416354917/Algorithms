package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Flatten Nested List Iterator.
 * 
 * <p>
 * <b>Description: </b>Given a nested list of integers, implement an iterator to
 * flatten it.
 * 
 * Each element is either an integer, or a list -- whose elements may also be
 * integers or other lists.
 * 
 * Example 1: Given the list [[1,1],2,[1,1]],
 * 
 * By calling next repeatedly until hasNext returns false, the order of elements
 * returned by next should be: [1,1,2,1,1].
 * 
 * Example 2: Given the list [1,[4,[6]]],
 * 
 * By calling next repeatedly until hasNext returns false, the order of elements
 * returned by next should be: [1,4,6].
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Stack, Design.
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution341 {

	// This is the interface that allows for creating nested lists.
	// You should not implement it, or speculate about its implementation
	public interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather
		// than a nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds
		// a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a
		// nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

	public class NestedIterator implements Iterator<Integer> {

		List<NestedInteger> nestedList;
		List<Integer> sta = new LinkedList<Integer>();
		int pos = 0;

		public NestedIterator(List<NestedInteger> nestedList) {
			this.nestedList = nestedList;
			if (nestedList != null && nestedList.size() != 0) {
				while (this.pos < this.nestedList.size()
						&& this.sta.isEmpty()) {
					this.pushNestedList(nestedList.get(this.pos));
					this.pos++;
				}
			}
		}

		@Override
		public Integer next() {
			return sta.remove(0);
		}

		@Override
		public boolean hasNext() {
			if (!sta.isEmpty()) {
				return true;
			} else if (this.pos < this.nestedList.size()) {
				while (this.pos < this.nestedList.size()
						&& this.sta.isEmpty()) {
					this.pushNestedList(nestedList.get(this.pos));
					this.pos++;
				}
				return !sta.isEmpty();
			} else {
				return false;
			}
		}

		public void pushNestedList(NestedInteger x) {
			if (x.isInteger()) {
				sta.add(x.getInteger());
			} else {
				List<NestedInteger> list = x.getList();
				for (NestedInteger y : list) {
					pushNestedList(y);
				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
