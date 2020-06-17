//https://leetcode.com/problems/partition-list/

public class PartitionList_86 {

	static ListNode head;

	class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
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

	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		ListNode result = dummy;

		ListNode node1 = head;
		while (node1 != null) {
			if (node1.val < x) {
				dummy.next = new ListNode(node1.val);
				dummy = dummy.next;
			}
			node1 = node1.next;
		}

		ListNode node2 = head;
		while (node2 != null) {
			if (node2.val >= x) {
				dummy.next = new ListNode(node2.val);
				dummy = dummy.next;
			}
			node2 = node2.next;
		}

		return result.next;
	}

	public static void main(String[] args) {
		PartitionList_86 createLinkedList = new PartitionList_86();
		createLinkedList.insertHead(2);
		createLinkedList.insertHead(5);
		createLinkedList.insertHead(2);
		createLinkedList.insertHead(3);
		createLinkedList.insertHead(4);
		createLinkedList.insertHead(1);
		createLinkedList.partition(head, 3);
	}

}
