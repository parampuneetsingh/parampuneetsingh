//https://leetcode.com/problems/rotate-list/

public class RotateList_61 {

	ListNode head;

	class ListNode {
		int data;
		ListNode next;

		public ListNode(int data) {
			this.data = data;
		}

		public int Data(int data) {
			return data;
		}
	}

	public void insertHead(int data) {
		ListNode temp = new ListNode(data);
		temp.next = head;
		head = temp;
	}

	public void rotateList(int k) {
		rotateRight2(head, k);
	}

	public ListNode rotateRight(ListNode head, int k) {
		// Handle null cases
		if (head == null || head.next == null)
			return head;

		// Store list length
		ListNode curr = head;
		int length = 1;

		while (curr.next != null) {
			length++;
			curr = curr.next;
		}

		// Get rid of unneeded shifts, e.g 25 shifts on a list with 7 nodes is like
		// 25%7=4 shifts
		k = k % length;
		if (k == 0)
			return head;

		// Make the list cyclical
		curr.next = head;

		// Loop again until n-k and mark that node as the new queue, and return the next
		// as the new head
		ListNode prev = head;
		int i = 0;
		while (i < length - k - 1) {
			i++;
			prev = prev.next;
		}

		ListNode newHead = prev.next;
		prev.next = null;

		return newHead;
	}

	// Solution 2
	public ListNode rotateRight2(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;

		if (k == 0) {
			return head;
		}

		int len = 0;

		ListNode curr = head;

		while (curr != null) {
			curr = curr.next;
			len++;
		}

		ListNode node = head;

		int n = 0;

		if (k < len) {
			n = len - k;
		} else {
			n = len - (k % len);
		}

		while (n > 0) {
			ListNode t = node;
			ListNode l = node.next;
			node = l;
			t.next = null;

			while (l.next != null) {
				l = l.next;
			}

			l.next = t;
			n--;
		}

		return node;
	}

	public static void main(String[] args) {
		RotateList_61 rotate = new RotateList_61();
		rotate.insertHead(5);
		rotate.insertHead(4);
		rotate.insertHead(3);
		rotate.insertHead(2);
		rotate.insertHead(1);
		rotate.rotateList(2);
	}

}
