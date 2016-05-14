package leetcode;

/**
 * Reorder List.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * <p>
 * A combination of: #206 Reverse Linked List and #21 Merge Two Sorted Lists.
 * <p>
 * 
 * @author Jason
 *
 */
public class Solution143 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public void reorderList(ListNode head) {
		// step 0: corner cases.
		if (head == null || head.next == null || head.next.next == null)
			return;

		// step 1: find the node to split.
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// step 2: reverse the second half.
		ListNode head2 = slow.next;
		slow.next = null;
		if (head2.next != null) {
			ListNode a = head2, b = a.next; // , c = b.next;
			a.next = null;
			while (b != null) {
				ListNode c = b.next;
				b.next = a;
				if (c == null)
					break;
				a = b;
				b = c;
			}
			head2 = b;
		}

		// step 3: merge.
		ListNode p1 = head, p2, q1 = head2, q2;
		while (q1 != null) {
			p2 = p1.next;
			q2 = q1.next;

			p1.next = q1;
			q1.next = p2;

			p1 = p2;
			q1 = q2;
		}
	}

	public static void main(String[] args) {
		Solution143 solution = new Solution143();

		ListNode p1 = solution.new ListNode(1);
		ListNode p2 = solution.new ListNode(2);
		ListNode p3 = solution.new ListNode(3);
		ListNode p4 = solution.new ListNode(4);
		ListNode p5 = solution.new ListNode(5);
		ListNode p6 = solution.new ListNode(6);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = p6;

		solution.reorderList(p1);
		while (p1 != null) {
			System.out.println(p1.val + " -> ");
			p1 = p1.next;
		}
		System.out.println("null");
	}

}
