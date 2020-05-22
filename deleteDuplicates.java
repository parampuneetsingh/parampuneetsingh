
public class deleteDuplicates {
	ListNode head;
	
	public class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int val) {
			this.val = val;
			this.next = null;
		} 
	}
	
	public deleteDuplicates() {
		head = null;
	}
	
	public void insertHead(int data) {
		ListNode node = new ListNode(data);
		node.next = head;
		head = node;
	}
	
	public void removeDuplicate() {
		deleteDuplicatesNodes(head);
	}
	
	public ListNode deleteDuplicatesNodes(ListNode head) {
		ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.next.val == temp.val) {
                temp.next = temp.next.next;
            } else {
            	temp = temp.next;
            }
        }
        return head;
	}
	
	public static void main(String[] args) {
		deleteDuplicates delDup = new deleteDuplicates();
		delDup.insertHead(3);
		delDup.insertHead(3);
		delDup.insertHead(2);
		delDup.insertHead(1);
		delDup.insertHead(1);
		delDup.removeDuplicate();
	}

}
