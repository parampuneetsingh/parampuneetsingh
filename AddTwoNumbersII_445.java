import java.util.Stack;

//https://leetcode.com/problems/add-two-numbers-ii/
//https://www.youtube.com/watch?v=71NkQBIHxg8

public class AddTwoNumbersII_445 {

	ListNode l1;
	ListNode l2;

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

	public void insertHead1(int data) {
		ListNode temp = new ListNode(data);
		temp.next = l1;
		l1 = temp;
	}

	public void insertHead2(int data) {
		ListNode temp = new ListNode(data);
		temp.next = l2;
		l2 = temp;
	}

	public void addNumbers() {
		addTwoNumbers(l1, l2);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();

		ListNode list = new ListNode(-1);
		ListNode res = list;

		int carry = 0;

		while (l1 != null) {
			s1.push(l1.val);
			l1 = l1.next;
		}

		while (l2 != null) {
			s2.push(l2.val);
			l2 = l2.next;
		}

		while (!s1.isEmpty() || !s2.isEmpty()) {
			int s1Val = s1.isEmpty() ? 0 : s1.pop();
			int s2Val = s2.isEmpty() ? 0 : s2.pop();

			int t = s1Val + s2Val + carry;
			carry = t / 10;
			ListNode curr = new ListNode(t % 10);
			curr.next = res.next;
			res.next = curr;
		}

		if (carry != 0) {
			ListNode curr = new ListNode(1);
			curr.next = res.next;
			res.next = curr;
		}

		return list.next;
	}

	public static void main(String[] args) {
		AddTwoNumbersII_445 ll = new AddTwoNumbersII_445();
		ll.insertHead1(3);
		ll.insertHead1(4);
		ll.insertHead1(2);
		ll.insertHead1(7);
		ll.insertHead2(4);
		ll.insertHead2(6);
		ll.insertHead2(5);
		ll.addNumbers();
	}

}
