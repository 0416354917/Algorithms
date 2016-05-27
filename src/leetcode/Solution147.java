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
 * <b>Status: </b>Accepted.
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

		ListNode p1pre = null, p1 = head, p2 = p1.next, p3 = p2.next,
				p2pre = head;

		while (p2 != null) {
			p1 = head;
			p1pre = null;

			p3 = p2.next;
			if (p2.val <= p1.val) {
				head = p2;
				p2.next = p1;
				p2pre.next = p3;
				p2 = p3;
			} else {
				while (p1.val < p2.val) {
					p1pre = p1;
					p1 = p1.next;
				}
				if (p1 != p2) {
					p1pre.next = p2;
					p2.next = p1;
					p2pre.next = p3;
				} else {
					p2pre = p2;
				}
				p2 = p3;
			}
		}

		return head;
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
			System.out.print(head.val + "  ");
			head = head.next;
		}
		System.out.println();
	}

}
