//https://leetcode.com/problems/reverse-nodes-in-k-group/
//https://www.youtube.com/watch?v=QD9xEicaxxI

public class ReverseNodesInKgroup_25 {

	ListNode head;

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverse(int k) {
		return reverseKGroup2(head, k);
	}

	// reverse K nodes from prev, return the last node of k, if not enough,
	// return null
	private ListNode reverseK(ListNode prev, int k) {
		ListNode head = prev.next;
		ListNode last = head;

		for (int i = 0; i < k; i++) {
			if (head == null) {
				return null;
			}
			ListNode next = head.next;
			if (i > 0) {
				ListNode tmp = prev.next;
				prev.next = head;
				last.next = next;
				head.next = tmp;
			}
			head = next;
		}
		return last;
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dump = new ListNode(0);
		dump.next = head;
		ListNode prev = dump;

		while (prev != null) {
			ListNode tmp = reverseK(prev, k);
			if (tmp == null) {
				// if failed, swap again to go back to original order.
				reverseK(prev, k);
			}
			prev = tmp;
		}
		return dump.next;
	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

	// Solution 2, Easy to understand
	public ListNode reverseKGroup2(ListNode head, int k) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;

		ListNode curr = head;
		ListNode currHead = head;

		int i = 0;

		while (curr != null) {
			i++;

			if (i == k) {
				ListNode temp = curr.next;
				curr.next = null;
				ListNode reverseHead = reverseList(currHead);
				prev.next = reverseHead;
				prev = currHead;

				currHead.next = temp;
				currHead = temp;

				i = 0;
				curr = temp;
				continue;
			}

			curr = curr.next;
		}
		return dummy.next;
	}

	public void insertHead(int data) {
		ListNode temp = new ListNode(data);
		temp.next = head;
		head = temp;
	}

	public static void main(String[] args) {
		ReverseNodesInKgroup_25 nodes = new ReverseNodesInKgroup_25();
		nodes.insertHead(5);
		nodes.insertHead(4);
		nodes.insertHead(3);
		nodes.insertHead(2);
		nodes.insertHead(1);
		nodes.reverse(2);
	}

}
