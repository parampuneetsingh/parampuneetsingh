public class MergeTwoSortedLists_21 {

	ListNode head1;
	ListNode head2;

	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	public MergeTwoSortedLists_21() {
		head1 = null;
		head2 = null;
	}

	public void insertHead1(int data) {
		ListNode temp = new ListNode(data);
		temp.next = head1;
		head1 = temp;
	}

	public void insertHead2(int data) {
		ListNode temp = new ListNode(data);
		temp.next = head2;
		head2 = temp;
	}

	public void print() {
		ListNode current = head1;
		while (current != null) {
			System.out.println(current.val);
			current = current.next;
		}
	}

	public void mergeLists() {
		head1 = mergeTwoLists(head1, head2);
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode temp = new ListNode(0);
		ListNode list1 = l1;
		ListNode list2 = l2;
		ListNode prev = temp;
		
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				prev.next = list1;
				list1 = list1.next;
			} else {
				prev.next = list2;
				list2 = list2.next;
			}
			prev = prev.next;
		}
		
		if (list1 != null) {
            prev.next = list1;
        }
        if (list2 != null) {
            prev.next = list2;
        }
		
		return temp.next;
	}

	public static void main(String[] args) {
		MergeTwoSortedLists_21 merge = new MergeTwoSortedLists_21();
		merge.insertHead1(1);
		merge.insertHead1(2);
		merge.insertHead1(4);
		merge.insertHead2(1);
		merge.insertHead2(3);
		merge.insertHead2(4);
		merge.mergeLists();
		// 1 -> 2 -> 3 -> 4 -> 5 -> 0
		// Output 1 -> 2 -> 3 -> 5
		// nnode.deleteValueNode(1);
		merge.print();

	}

}
