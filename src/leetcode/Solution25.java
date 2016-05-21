package leetcode;

/**
 * Reverse Nodes in k-Group.
 * 
 * <p>
 * <b>Description: </b>Given a linked list, reverse the nodes of a linked list k
 * at a time and return its modified list.
 * </p>
 * 
 * <p>
 * <b>Algorithm: </b>Linked List.
 * </p>
 * 
 * <p>
 * <b>Status: </b>Accepted.
 * </p>
 * 
 * @author Jason
 *
 */
public class Solution25 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseLinkedList(ListNode preLink, ListNode head,
			ListNode tail, ListNode afterLink) {
		ListNode toBeLinkedIn = afterLink, p = head, q = p.next;
		while (p != tail) {
			p.next = toBeLinkedIn;
			toBeLinkedIn = p;
			p = q;
			q = p.next;
		}
		p.next = toBeLinkedIn;
		if (preLink != null)
			preLink.next = p;

		return head;
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null || k < 2)
			return head;

		ListNode preLink = null, afterLink = null;
		ListNode p = head, tempHead = head, tempTail = head, ansHead = head;
		int index = 0;
		while (true) {
			index = 0;
			while (index < k && p != null) {
				index++;
				tempTail = p;
				p = p.next;
			}
			if (index < k)
				return ansHead;
			else {
				if (ansHead == head) {
					ansHead = tempTail;
				}
				afterLink = p;
				preLink = reverseLinkedList(preLink, tempHead, tempTail,
						afterLink);
				tempHead = p;
				if (preLink == null) {
					return ansHead;
				}
			}
		}
	}

	public static void main(String[] args) {
		Solution25 solution = new Solution25();

		ListNode p1 = solution.new ListNode(1);
		ListNode p2 = solution.new ListNode(2);
		ListNode p3 = solution.new ListNode(3);
		ListNode p4 = solution.new ListNode(4);
		ListNode p5 = solution.new ListNode(5);

		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;

		ListNode head = solution.reverseKGroup(p1, 2);

		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println("#");
	}

}
