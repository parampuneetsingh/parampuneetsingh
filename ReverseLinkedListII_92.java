
//https://www.youtube.com/watch?v=v-Unz97b8NM

public class ReverseLinkedListII_92 {

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

	public ReverseLinkedListII_92() {
		head = null;
	}

	public void insertHead(int data) {
		ListNode temp = new ListNode(data);
		temp.next = head;
		head = temp;
	}

	public void reverseList(int m, int n) {
		reverseList2(head, m, n);
	}

	public ListNode reverseList2(ListNode head, int m, int n) {
		ListNode curr = new ListNode(-1);
		ListNode prev = new ListNode(-1);
		curr.next = head;
		prev.next = head;
		int i = 0;
		while (i < n) {
			curr = curr.next;
			i++;
		}
		i=1;
		while (i < m) {
			prev = prev.next;
			i++;
		}
		i = n - m + 1;
		ListNode post = curr.next;
		curr = prev.next;
		while (i > 0) {
			ListNode temp = curr.next;
			curr.next = post;
			post = curr;
			curr = temp;
			i--;
		}
		prev.next = post;
		return m > 1 ? head : post;
	}

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
		ReverseLinkedListII_92 createLinkedList = new ReverseLinkedListII_92();

		createLinkedList.insertHead(5);
		createLinkedList.insertHead(4);
		createLinkedList.insertHead(3);
		createLinkedList.insertHead(2);
		createLinkedList.insertHead(1);
		createLinkedList.print();
		createLinkedList.reverseList(2, 4);
		createLinkedList.print();
	}

}
