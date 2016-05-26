package leetcode;

/**
 * Insertion Sort List.
 * 
 * <p>
 * <b>Description: </b>Sort a linked list using insertion sort.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Insertion Sort.
 * </p>
 * 
 * <p>
 * <b>Status: </b>...
 * </p>
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

		ListNode p = null, q = head;
		ListNode qPre = null;
		while (q != null) {
			ListNode r = q.next;
			while (r != null && q.val > r.val) {
				qPre = r;
				r = r.next;
			}
			if (qPre != null) {
				qPre.next = q;
			}
			q.next = r;

			q = q.next;
		}

		return p;
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

		ListNode head = solution.insertionSortList(p1);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

}
