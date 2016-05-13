package leetcode;

/**
 * 
 * Remove Duplicates from Sorted List II.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution82 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			this.val = x;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		// find new head:
		ListNode newHead = head;
		int cur = newHead.val;
		while (newHead.next != null && newHead.next.val == cur) {
			newHead = newHead.next;
			if (newHead.next == null)
				return null;
			if (newHead.next.val != cur) {
				newHead = newHead.next;
				cur = newHead.val;
			}
		}

		// System.out.println(newHead.val);

		// remove remaining duplicates:
		if (newHead != null && newHead.next != null) {
			ListNode p = newHead.next, q = newHead;
			int val = p.val;
			while (q != null) {
				int count = 1;
				while (p.next != null && p.next.val == val) {
					p = p.next;
					count++;
				}
				if (count >= 2) {
					q.next = p.next;
				} else {
					q.next = p;
					q = p;
				}
				p = p.next;
				if (p == null)
					return newHead;
				else
					val = p.val;
			}
		}

		return newHead;
	}

	public static void main(String[] args) {
		Solution82 solution = new Solution82();
		ListNode p1 = solution.new ListNode(1);
		ListNode p2 = solution.new ListNode(2);
		ListNode p3 = solution.new ListNode(2);
		ListNode p4 = solution.new ListNode(3);
		ListNode p5 = solution.new ListNode(3);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		ListNode head = solution.deleteDuplicates(p1);
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println("null");
	}

}
