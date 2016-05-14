package leetcode;

/**
 * Merge k Sorted Lists.
 * 
 * <p>
 * <b>Status: TLE.</b>
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
