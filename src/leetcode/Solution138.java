package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Copy List with Random Pointer.
 * 
 * <p>
 * <b>Description: </b>A linked list is given such that each node contains an
 * additional random pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Hash Table, Linked List.
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution138 {

	/**
	 * Definition for singly-linked list with a random pointer.
	 */
	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	}

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return head;

		Map<RandomListNode, Integer> map1 = new HashMap<RandomListNode, Integer>();
		int index = 0;
		RandomListNode p = head;
		while (p != null) {
			map1.put(p, index);
			index++;
			p = p.next;
		}

		RandomListNode head2 = null, pre = null;
		Map<Integer, RandomListNode> map2 = new HashMap<Integer, RandomListNode>();
		index = 0;
		p = head;
		while (p != null) {
			RandomListNode q = map2.get(index);

			if (q == null) {
				q = new RandomListNode(p.label);
			}

			if (p.random != null) {
				int rIndex = map1.get(p.random);
				RandomListNode r = map2.get(rIndex);
				if (r == null) {
					r = new RandomListNode(p.random.label);
					map2.put(rIndex, r);
				}
				q.random = r;
			}

			map2.put(index, q);

			if (head2 == null) {
				head2 = q;
				pre = q;
			} else {
				pre.next = q;
				pre = q;
			}

			index++;
			p = p.next;
		}

		return head2;
	}

	public static void main(String[] args) {
		Solution138 solution = new Solution138();

		RandomListNode p1 = solution.new RandomListNode(1);
		RandomListNode p2 = solution.new RandomListNode(2);
		// RandomListNode p3 = solution.new RandomListNode(2);
		// RandomListNode p4 = solution.new RandomListNode(2);
		p1.next = p2;
		p1.random = p2;
		// p2.next = p3;
		p2.random = p2;
		// p3.next = p4;

		RandomListNode q = solution.copyRandomList(p1);

		while (q != null) {
			System.out.print("label: " + q.label);
			if (q.random != null) {
				System.out.print(", random : " + q.random.label);
			}
			System.out.println();
			q = q.next;
		}
	}

}
