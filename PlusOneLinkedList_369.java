
public class PlusOneLinkedList_369 {

	ListNode head;

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

	public ListNode reverse(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;

		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}

		return prev;
	}

	public ListNode reverseList() {
		return plusOne(head);
	}

	public ListNode plusOne(ListNode head) {
		ListNode reverseList = reverse(head);
		reverseList.val++;
		ListNode newList = reverseList;

		while (newList != null && newList.val >= 10) {
			newList.val -= 10;

			if (newList.next != null) {
				newList.next.val++;
			} else {
				newList.next = new ListNode(1);
			}

			newList = newList.next;
		}

		return reverse(reverseList);
	}

	public static void main(String[] args) {
		PlusOneLinkedList_369 createLinkedList = new PlusOneLinkedList_369();
		createLinkedList.insertHead(9);
		createLinkedList.insertHead(2);
		createLinkedList.insertHead(1);
		createLinkedList.reverseList();
	}

}
