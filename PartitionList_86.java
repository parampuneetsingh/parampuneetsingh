//https://leetcode.com/problems/partition-list/

public class PartitionList_86 {

	static ListNode head;

	class ListNode {
		int val;
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

    public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
        
        ListNode beforeMax = new ListNode(-1);
        ListNode node1 = beforeMax;
        
        ListNode afterMax = new ListNode(-1);
        ListNode node2 = afterMax;
        
        while(head != null) {
            if (head.val < x) {
                node1.next = new ListNode(head.val);
                node1 = node1.next;
            } else {
                node2.next = new ListNode(head.val);
                node2 = node2.next;
            }
            head = head.next;
        }
        
        node1.next = afterMax.next;
        
        return beforeMax.next;
    }

	public static void main(String[] args) {
		PartitionList_86 createLinkedList = new PartitionList_86();
		createLinkedList.insertHead(2);
		createLinkedList.insertHead(5);
		createLinkedList.insertHead(2);
		createLinkedList.insertHead(3);
		createLinkedList.insertHead(4);
		createLinkedList.insertHead(1);
		createLinkedList.partition(head, 3);
	}

}
