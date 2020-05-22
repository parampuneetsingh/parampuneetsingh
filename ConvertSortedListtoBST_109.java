//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

public class ConvertSortedListtoBST_109 {
	ListNode head;
	TreeNode root;

	public class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	class ListNode {
		int val;
		ListNode prev;
		ListNode curr;
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

	public void print() {
		ListNode current = head;
		while (current != null) {
			int data = current.val;
			System.out.print(data + " ");
			current = current.next;
		}
		System.out.println(" ");
	}

	public TreeNode contructBST(ListNode head, int size) {
		if (size == 0) {
			return null;
		}

		int i = 0;
		ListNode current = head;
		
		while (i++ < size / 2) {
			current = current.next;
		}
		
		TreeNode root = new TreeNode(current.val);
		
		root.left = contructBST(head, size / 2);
		root.right = contructBST(current.next, (size - 1) / 2);
		return root;
	}

	public TreeNode sortedList() {
		return sortedListToBST(head);
	}

	public TreeNode sortedListToBST(ListNode head) {
		ListNode slow = head;

		int size = 0;

		while (slow != null) {
			slow = slow.next;
			size++;
		}

		return contructBST(head, size);
	}

	public static void main(String[] args) {
		ConvertSortedListtoBST_109 createLinkedList = new ConvertSortedListtoBST_109();

		createLinkedList.insertHead(9);
		createLinkedList.insertHead(5);
		createLinkedList.insertHead(0);
		createLinkedList.insertHead(-3);
		createLinkedList.insertHead(-10);
		createLinkedList.print();
		createLinkedList.sortedList();
	}

}
