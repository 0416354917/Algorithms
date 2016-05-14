package leetcode;

/**
 * Insertion Sort List.
 * 
 * @author Jason
 *
 */
public class Solution147 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			this.val = x;
		}
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode p = head.next, q;
		while (p != null) {

			p = p.next;
		}

		return null;
	}

	public static void main(String[] args) {
		Solution147 solution = new Solution147();
		ListNode p1 = solution.new ListNode(3);
		ListNode p2 = solution.new ListNode(2);
		ListNode p3 = solution.new ListNode(4);
		ListNode p4 = solution.new ListNode(1);
		ListNode p5 = solution.new ListNode(5);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
	}

}
