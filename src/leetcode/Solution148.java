package leetcode;

/**
 * Sort List.
 * 
 * <p>
 * <b>Description: </b>
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Bottom-Up Merge Sort.
 * </p>
 * 
 * <p>
 * <b>Reference: </b> {@link https://www.youtube.com/watch?v=lOUe8Q9jQow}
 * </p>
 * 
 * <p>
 * <b>Note: </b>Constant Space.
 * <p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution148 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		int N = 0;
		ListNode p = head;
		while (p != null) {
			N++;
			p = p.next;
		}

		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode p1 = head;
		ListNode p2 = p1;
		ListNode p3 = p2.next;
		int size = 1;
		int count = 0;

		while (size < N) {
			pre = dummy;
			p1 = pre.next;
			p2 = p1;
			p3 = p2;

			while (p1 != null) {
				count = size;
				while (count != 0 && p2.next != null) {
					count--;
					p2 = p2.next;
				}
				if (count > 0) {
					pre.next = p1;
					break;
				}

				p3 = p2;
				count = size;
				while (count != 0 && p3 != null) {
					count--;
					p3 = p3.next;
				}

				pre = merge(pre, p1, size, p2, size - count);

				if (p3 == null || count != 0)
					break;

				p1 = p3;
				p2 = p1;
			}
			size *= 2;
		}

		return dummy.next;
	}

	public ListNode merge(ListNode pre, ListNode p1, int size1, ListNode p2,
			int size2) {
		pre.next = p1;
		while (size1 != 0 && size2 != 0) {
			if (p2.val < p1.val) {
				pre.next = p2;
				p2 = p2.next;
				pre.next.next = p1;
				pre = pre.next;
				size2--;
			} else {
				pre = p1;
				p1 = p1.next;
				size1--;
			}
		}

		if (size2 == 0) {
			while (size1 != 0) {
				pre = pre.next;
				size1--;
			}
			pre.next = null;
			return pre;
		}

		if (size1 == 0) {
			pre.next = p2;
			while (size2 != 0) {
				pre = pre.next;
				size2--;
			}
		}

		return pre;
	}

	public static void main(String[] args) {
		Solution148 solution = new Solution148();

		ListNode p1 = solution.new ListNode(3);
		ListNode p2 = solution.new ListNode(4);
		ListNode p3 = solution.new ListNode(1);
		ListNode p4 = solution.new ListNode(4);
		ListNode p5 = solution.new ListNode(5);
		ListNode p6 = solution.new ListNode(6);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = p6;

		ListNode head = solution.sortList(p1);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

}
