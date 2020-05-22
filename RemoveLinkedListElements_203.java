public class RemoveLinkedListElements_203 {

	ListNode head = null;
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public void insertHead(int data) {
		ListNode temp = new ListNode(data);
		temp.next = head;
		head = temp;
	}
	
	 public void removeElement(int val) {
		 removeElements(head, val);
	 } 
	 
	 public ListNode removeElements(ListNode head, int val) {
	        ListNode n = new ListNode(0);
	        n.next = head;
	        ListNode curr = head;
	        ListNode prev = n;
	        
	        while (curr != null) {
	            if (curr.val == val) {
	            	prev.next = curr.next;
	            } else {
	            	prev = prev.next;
	            }
	            curr = curr.next;
	        }
	        
	        return n.next;
	    }
	 
	public static void main(String[] args) {
		RemoveLinkedListElements_203 nnode = new RemoveLinkedListElements_203();
		nnode.insertHead(6);
		nnode.insertHead(5);
		nnode.insertHead(4);
		nnode.insertHead(3);
		nnode.insertHead(6);
		nnode.insertHead(2);
		nnode.insertHead(1);
		nnode.removeElement(6);
	}

}
