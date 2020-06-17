import java.util.Stack;

//https://leetcode.com/problems/reorder-list/

public class ReorderList_143 {

	static ListNode head;

	class ListNode {
		ListNode next;
		int val;

		public ListNode(int val) {
			this.val = val;
		}
	}

	public void insertHead(int data) {
		ListNode temp = new ListNode(data);
		temp.next = head;
		head = temp;
	}

	public void reorderList(ListNode head) {
		ListNode s = head;
		ListNode f = head;
		while (f != null && f.next != null) {
			s = s.next;
			f = f.next.next;
		}
		if (f != null)
			s = s.next;
		Stack<ListNode> stack = new Stack<ListNode>();
		while (s != null) {
			stack.push(s);
			s = s.next;
		}
		ListNode cur = head;
		while (!stack.isEmpty()) {
			ListNode n = stack.pop();
			ListNode tmp = cur.next;
			cur.next = n;
			n.next = tmp;
			cur = tmp;
		}
		if (cur != null)
			cur.next = null;
	}

	public static void main(String[] args) {
		ReorderList_143 list = new ReorderList_143();
		list.insertHead(5);
		list.insertHead(4);
		list.insertHead(3);
		list.insertHead(2);
		list.insertHead(1);
		list.reorderList(head);
	}

}
