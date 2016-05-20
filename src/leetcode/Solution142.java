package leetcode;

/**
 * Linked List Cycle II.
 * 
 * <p>
 * <b>Status: Accepted.</b>
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution142 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}

		ListNode p = head.next, q = head.next.next;
		while (q != p && q.next != null && q.next.next != null) {
			p = p.next;
			q = q.next.next;
		}

		if (p != q) {
			return null;
		}

		ListNode meetNode = p;

		p = head;
		while (p != meetNode) {
			p = p.next;
			meetNode = meetNode.next;
		}

		return p;
	}

	public static void main(String[] args) {
		Solution142 solution = new Solution142();

		ListNode head = solution.new ListNode(1);
		ListNode p1 = solution.new ListNode(2);
		head.next = p1;
		p1.next = head;

		System.out.println(solution.detectCycle(head).val);
	}

}
