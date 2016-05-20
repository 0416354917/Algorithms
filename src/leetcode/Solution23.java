package leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Merge k Sorted Lists.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution23 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		// corner cases.
		if (lists == null)
			return null;

		ListNode head = new ListNode(0);
		ListNode p = head;
		List<ListNode> nodes = new LinkedList<ListNode>();
		for (ListNode x : lists) {
			if (x != null) {
				nodes.add(x);
			}
		}
		Collections.sort(nodes, new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				if (o1.val < o2.val)
					return -1;
				else if (o1.val == o2.val)
					return 0;
				else
					return 1;
			}

		});

		while (!nodes.isEmpty()) {
			ListNode next = nodes.get(0);

			// update p:
			p.next = next;
			p = p.next;

			// update lists:
			nodes.remove(0);
			next = next.next;
			if (next != null) {
				int index = 0;
				for (; index < nodes.size(); index++) {
					if (next.val <= nodes.get(index).val) {
						nodes.add(index, next);
						break;
					}
				}
				if (index == nodes.size()) {
					nodes.add(next);
				}
			}
		}

		return head.next;
	}

	/**
	 * TLE solution.
	 * 
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists1(ListNode[] lists) {
		// corner cases.
		if (lists == null || lists.length == 0)
			return null;

		if (lists.length == 1)
			return lists[0];

		// get first non-empty list head:
		int index = 0;
		ListNode head1 = lists[0];
		while (head1 == null) {
			index++;
			if (index == lists.length - 1)
				return null;
			head1 = lists[index];
		}

		index++;
		for (; index < lists.length; index++) {
			ListNode head2 = lists[index];
			if (head2 == null)
				continue;
			ListNode h1 = head1, h2 = head2, h11 = head1, h22;
			while (h2 != null && h2.val < h1.val) {
				h22 = h2.next;
				h2.next = h1;
				head1 = h2;
				h1 = h2;
				h2 = h22;
			}
			if (h2 == null)
				continue;

			ListNode p = h11;
			while (h2.val >= p.val) {
				if (p.next == null) {
					p.next = h2;
					break;
				} else if (p.next.val >= h2.val) {
					h22 = h2.next;
					ListNode q = p.next;
					p.next = h2;
					h2.next = q;
					p = h2;
					h2 = h22;
					if (h2 == null)
						break;
				} else {
					p = p.next;
				}
			}

		}

		return head1;
	}

	public static void main(String[] args) {
		Solution23 solution = new Solution23();

		ListNode p1 = solution.new ListNode(1);
		ListNode p2 = solution.new ListNode(4);
		ListNode p3 = solution.new ListNode(7);
		ListNode p4 = solution.new ListNode(2);
		ListNode p5 = solution.new ListNode(5);
		ListNode p6 = solution.new ListNode(8);
		ListNode p7 = solution.new ListNode(3);
		ListNode p8 = solution.new ListNode(6);
		ListNode p9 = solution.new ListNode(9);
		p1.next = p2;
		p2.next = p3;
		// p3.next = p4;
		p4.next = p5;
		p5.next = p6;
		// p6.next = p7;
		p7.next = p8;
		p8.next = p9;

		ListNode[] lists = { p1, p4, p7 };
		solution.mergeKLists(lists);

		while (p1 != null) {
			System.out.println(p1.val + " -> ");
			p1 = p1.next;
		}
		System.out.println("null");
	}

}
