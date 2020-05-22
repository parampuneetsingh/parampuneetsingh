
public class ReverseLinkedList_206 {
	ListNode head;	
	
	class ListNode {
		int data;
		ListNode prev;
		ListNode curr;
		ListNode next;
		
		public ListNode(int data) {
			this.data = data;
		}
		
		public int Data(int data) {
			return data;
		}
	}
	
	public ReverseLinkedList_206() {
		head = null;
	}
	
	public void insertHead(int data) {
		ListNode temp = new ListNode(data);
		temp.next = head;
		head = temp;
	}
	
	public void reverseList() {
		head = reverseList(head);
	}
	
	public ListNode reverseList(ListNode head) {
		ListNode current = head;
		ListNode prev = null;
		
		while (current != null) {
			ListNode temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		
		return prev;
	}
	
/*	public ListNode reverseList() {
	ListNode first = head;
	ListNode prev = null;
	while (first != null) {
		ListNode temp = first.next;
		first.next = prev;
		prev = first;
		first = temp;
	}
	head = prev;
	return prev;
	}*/
	
	public void print() {
		ListNode current = head;
		while (current != null) {
			int data = current.data;
			System.out.print(data + " ");
			current = current.next;
		}
		System.out.println(" ");
	}
	
	public static void main(String[] args) {
		ReverseLinkedList_206 createLinkedList = new ReverseLinkedList_206();
		
		createLinkedList.insertHead(5);
		createLinkedList.insertHead(4);
		createLinkedList.insertHead(3);
		createLinkedList.insertHead(2);
		createLinkedList.insertHead(1);
		createLinkedList.print();
		createLinkedList.reverseList();
		createLinkedList.print();
	}

}
