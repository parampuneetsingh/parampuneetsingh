//https://leetcode.com/problems/remove-duplicates-from-sorted-list/

public class RemoveDuplicatesfromSortedList_83 {

	ListNode head;

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public void insertHead(int data) {
		ListNode temp = new ListNode(data);
		temp.next = head;
		head = temp;
	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode curr = head;
		ListNode prev = head;

		while (prev != null && prev.next != null) {

			if (curr != null && curr.next != null && curr.val == curr.next.val) {

				while (curr != null && curr.next != null && curr.val == curr.next.val) {
					curr.next = curr.next.next;
				}

				if (curr == head) {
					head = head.next;
					prev = head;
					curr = head;
				} else {
					curr = curr.next;
					prev.next = curr;
				}
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
		return head;
	}

	public void delete() {
		deleteDuplicates(head);
	}

	public static void main(String[] args) {
		RemoveDuplicatesfromSortedList_83 list = new RemoveDuplicatesfromSortedList_83();
		
		list.insertHead(5);
		list.insertHead(4);
		list.insertHead(4);
		list.insertHead(3);
		list.insertHead(3);
		list.insertHead(2);
		list.insertHead(1);
		list.delete();
		
		/*
		list.insertHead(3);
		list.insertHead(2);
		list.insertHead(1);
		list.insertHead(1);
		list.insertHead(1);
		list.delete();*/
	}

}
