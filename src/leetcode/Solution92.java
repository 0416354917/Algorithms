package leetcode;

/**
 * Reverse Linked List II.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution92 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			this.val = x;
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n)
			return head;

		// find the starting position to reverse:
		ListNode start = head, p = null;
		int index = 1;
		if (m != 1) {
			while (index != m) {
				p = start;
				start = start.next;
				index++;
			}
		}

		// reverse:
		ListNode a, b, c;
		a = start;
		b = a.next;
		while (index + 1 != n) {
			c = b.next;
			b.next = a;
			a = b;
			b = c;

			index++;
		}

		start.next = b.next;
		b.next = a;
		if (p == null) {
			return b;
		} else {
			p.next = b;
			return head;
		}
	}

	public static void main(String[] args) {
		Solution92 solution = new Solution92();
		ListNode p1 = solution.new ListNode(1);
		ListNode p2 = solution.new ListNode(2);
		ListNode p3 = solution.new ListNode(3);
		ListNode p4 = solution.new ListNode(4);
		ListNode p5 = solution.new ListNode(5);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		ListNode head = solution.reverseBetween(p1, 2, 3);
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println("null");
	}

}
