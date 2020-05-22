public class PalindromeLinkedList_234 {
	
	ListNode head;	
	
	class ListNode {
		int val;
		ListNode prev;
		ListNode curr;
		ListNode next;
		
		public ListNode(int val) {
			this.val = val;
		}
		
		public int Data(int val) {
			return val;
		}
	}
	
	public void insertHead(int val) {
		ListNode temp = new ListNode(val);
		temp.next = head;
		head = temp;
	}
	
	public boolean checkPalindrome() {
		boolean res = isPalindrome(head);
		return res;
	}
	
	public ListNode reverse(ListNode head) {
        ListNode list1 = head;
        ListNode list2 = null;
        
        while (list1 != null) {
            ListNode temp = list1.next;
            list1.next = list2;
            list2 = list1;
            list1 = temp;
        }
        
        return list2;
    }
    
    public boolean isPalindrome(ListNode head) {
       
        ListNode fast = head;
        ListNode middle = head;
        
        while(middle != null && fast != null && fast.next != null) {
            middle = middle.next;
            fast = fast.next.next;
        }
        
        if (fast !=null) {
            middle = middle.next;
        }
        
        middle = reverse(middle);
        
       while (head != null && middle != null) {
			if (head.val != middle.val) {
                return false;
            }
			head = head.next;
			middle = middle.next;
		}
        
		return true;
    }
    
	public static void main(String[] args) {
		PalindromeLinkedList_234 createLinkedList = new PalindromeLinkedList_234();
		
		createLinkedList.insertHead(1);
		createLinkedList.insertHead(2);
		createLinkedList.insertHead(2);
		createLinkedList.insertHead(1);
		System.out.println(createLinkedList.checkPalindrome());
	}

}
