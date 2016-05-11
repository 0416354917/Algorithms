package leetcode;

/**
 * Palindrome Linked List.
 * 
 * Status: Accepted.
 * 
 * <p>
 * Algorithm: <b>Two Pointers, Fast-Slow Pointers.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution234 {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;

		// find middle node:
		ListNode slow = head, fast = head.next;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode head2 = null;
		if (fast.next != null) {
			head2 = slow.next.next;
			fast = fast.next;
		} else {
			head2 = slow.next;
		}

		// reverse the second half:
		ListNode p = head2, q = p.next, s;
		if (q != null) {
			while (q.next != null) {
				s = q.next;
				q.next = p;
				p = q;
				q = s;
				s = s.next;
			}
			q.next = p;
			head2 = q;
		}

		// compare:
		while (true) {
			if (head.val != head2.val)
				return false;
			if (head == slow)
				break;
			head = head.next;
			head2 = head2.next;
		}

		return true;
	}

	public static void main(String[] args) {
		Solution234 solution = new Solution234();
		ListNode p1 = solution.new ListNode(1);
		ListNode p2 = solution.new ListNode(2);
		ListNode p3 = solution.new ListNode(3);
		ListNode p4 = solution.new ListNode(3);
		ListNode p5 = solution.new ListNode(2);
		ListNode p6 = solution.new ListNode(2);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = p6;

		System.out.println(solution.isPalindrome(p1));
	}

}
