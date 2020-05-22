public class AddTwoNumbersLL_2 {

	ListNode1 head1;
	ListNode2 head2;

	public class ListNode1 {
		int val;
		ListNode1 next;

		public ListNode1(int val) {
			this.val = val;
			this.next = null;
		}
	}

	public class ListNode2 {
		int val;
		ListNode2 next;

		public ListNode2(int val) {
			this.val = val;
			this.next = null;
		}
	}

	public AddTwoNumbersLL_2() {
		head1 = null;
		head2 = null;
	}

	public void insertHead1(int data) {
		ListNode1 temp = new ListNode1(data);
		temp.next = head1;
		head1 = temp;
	}

	public void insertHead2(int data) {
		ListNode2 temp = new ListNode2(data);
		temp.next = head2;
		head2 = temp;
	}

	public void addNums() {
		addTwoNumbers(head1, head2);
	}

	// Solution 2
	public ListNode1 addTwoNumbers2(ListNode1 l1, ListNode2 l2) {
		ListNode1 list = new ListNode1(-1);
		ListNode1 curr = list;

		int carry = 0;

		while (l1 != null || l2 != null) {
			int a = (l1 == null) ? 0 : l1.val;
			int b = (l2 == null) ? 0 : l2.val;

			curr.next = new ListNode1((a + b + carry) % 10);
			carry = (a + b + carry) / 10;
			curr = curr.next;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}

		if (carry != 0) {
			curr.next = new ListNode1(1);
			curr = curr.next;
		}

		return list.next;
	}

	public ListNode1 addTwoNumbers(ListNode1 l1, ListNode2 l2) {
		int carry = 0;
		ListNode1 resp = new ListNode1(carry);
		ListNode1 current = resp;
		ListNode1 List1 = l1;
		ListNode2 List2 = l2;

		// ListNode1 respTemp = new ListNode1(carry);

		while (List1 != null || List2 != null) {
			if (List1 == null && List2 != null) {
				int sum = carry + List2.val;
				carry = sum / 10;

				current.next = new ListNode1(sum % 10);
				current = current.next;
				List2 = List2.next;
			} else if (List2 == null && List1 != null) {
				int sum = carry + List1.val;
				carry = sum / 10;

				current.next = new ListNode1(sum % 10);
				current = current.next;
				List1 = List1.next;
			} else {
				int sum = carry + List1.val + List2.val;
				carry = sum / 10;

				current.next = new ListNode1(sum % 10);
				current = current.next;
				List1 = List1.next;
				List2 = List2.next;
			}
		}

		if (carry > 0) {
			current.next = new ListNode1(carry);
		}

		return resp;
	}

	public static void main(String[] args) {

		AddTwoNumbersLL_2 createLinkedLst = new AddTwoNumbersLL_2();

		createLinkedLst.insertHead1(3);
		createLinkedLst.insertHead1(4);
		createLinkedLst.insertHead1(2);
		createLinkedLst.insertHead1(1);
		createLinkedLst.insertHead2(4);
		createLinkedLst.insertHead2(6);
		createLinkedLst.insertHead2(5);
		createLinkedLst.addNums();
	}

}
