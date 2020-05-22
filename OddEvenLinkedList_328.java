public class OddEvenLinkedList_328 {

	ListNode head;

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

	public ListNode changeList() {
		return oddEvenList(head);
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null)
			return null;
		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = even;
		
		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		
		odd.next = evenHead;
		
		return head;
	}

	public static void main(String[] args) {
		OddEvenLinkedList_328 list = new OddEvenLinkedList_328();
		list.insertHead(5);
		list.insertHead(4);
		list.insertHead(3);
		list.insertHead(2);
		list.insertHead(1);
		System.out.println(list.changeList());
	}

}
